package com.github.andrewzolot.testauthapp.ui

import android.support.v7.app.AlertDialog
import android.text.TextUtils
import com.github.andrewzolot.testauthapp.util.Const
import com.github.andrewzolot.testauthapp.R
import com.github.andrewzolot.testauthapp.data.WhetherService
import com.github.andrewzolot.testauthapp.data.model.MyReq
import com.github.andrewzolot.testauthapp.util.RxUtil
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * Created by Zolotuev
 */

class MainPresenter(val sessionService: WhetherService) : Presenter {

    private val coord = "" + Const.LATITUDE_MOSCOW +"," + Const.LONGTITUDE_MOSCOW
    private val units = Const.UNITS
    private val lang = Const.LANG

    private val ERROR_NO = 0
    private val ERROR_DIGIT = 1
    private val ERROR_LOWERCASE_LETTER = 2
    private val ERROR_UPPERCASE_LETTER = 3
    private val ERROR_LENGTH = 4

    private var mainView : MvpView? = null
    private var mDisposable : Disposable? = null

    override fun attachView(mvpView: MvpView) {
        mainView = mvpView
    }

    override fun detachView() {
        mainView = null
        mDisposable?.dispose()
    }

    fun onPasswordDrawableTouch(dialogBuilder: AlertDialog.Builder) {
        dialogBuilder.setTitle(R.string.password_helper_title).
                setMessage(R.string.password_helper).
                setNegativeButton("OK", { dialog, whichButton -> dialog.cancel()})
        dialogBuilder.create().show()
    }

    fun attemptLogin(emailStr : String, passwordStr : String){

        mainView?.onShowProgress(true)

        // Reset errors.
        var errorEmail : String? = null
        var errorPassword : String? = null
        mainView?.onSetLoginFormErrors(errorEmail, errorPassword)


        var cancel = false

        // Check for a valid email address.
        if (TextUtils.isEmpty(emailStr)) {
            errorEmail = mainView?.getStringFromResources(R.string.error_field_required)
            cancel = true
        } else if (!isEmailValid(emailStr)) {
            errorEmail = mainView?.getStringFromResources(R.string.error_invalid_email)
            cancel = true
        }

        // Check for a valid password.
        if (TextUtils.isEmpty(passwordStr)) {
            errorPassword = mainView?.getStringFromResources(R.string.error_field_required)
            cancel = true
        } else if (isPasswordValid(passwordStr) == ERROR_DIGIT) {
            errorPassword = mainView?.getStringFromResources(R.string.error_invalid_password_digit)
            cancel = true
        } else if (isPasswordValid(passwordStr) == ERROR_LOWERCASE_LETTER) {
            errorPassword = mainView?.getStringFromResources(R.string.error_invalid_password_lowercase)
            cancel = true
        } else if (isPasswordValid(passwordStr) == ERROR_UPPERCASE_LETTER) {
            errorPassword = mainView?.getStringFromResources(R.string.error_invalid_password_uppercase)
            cancel = true
        } else if (isPasswordValid(passwordStr) == ERROR_LENGTH) {
            errorPassword = mainView?.getStringFromResources(R.string.error_invalid_password_length)
            cancel = true
        }
        mainView?.onSetLoginFormErrors(errorEmail, errorPassword)
        if (cancel) {
            // There was an error; don't attempt login and focus the first
            mainView?.onShowProgress(false)
            mainView?.onRequestFocus()
        } else {
            // Perform whether forecast downloading.
            downloadData(coord, units, lang)
        }
    }

    private fun isEmailValid(email: String): Boolean {
        return email.contains("@")
    }


    private fun isPasswordValid(password: String): Int {
        val regexDigit = "[0-9]".toRegex()
        val regexUpperCase = "[A-Z]".toRegex()
        val regexLowerCase = "[a-z]".toRegex()
        // Check for a min 1 digit availability
        if (!regexDigit.containsMatchIn(password)) return ERROR_DIGIT
        // Check for a min 1 uppercase letter availability
        if (!regexUpperCase.containsMatchIn(password)) return ERROR_UPPERCASE_LETTER
        // Check for a min 1 lowercase letter availability
        if (!regexLowerCase.containsMatchIn(password)) return ERROR_LOWERCASE_LETTER
        // Check for password length
        if (password.length < 6) return ERROR_LENGTH
        return  ERROR_NO
    }

    private fun downloadData(coordinates : String, units : String, language : String) {

        checkViewAttached()
        RxUtil.dispose(mDisposable)
        sessionService.getData(Const.API_KEY, coordinates, units, language)
                .subscribe(object : Observer<MyReq>{

                    override fun onComplete() {

                    }

                    override fun onSubscribe(d: Disposable?) {
                        mDisposable = d
                    }

                    override fun onNext(value: MyReq?) {
                        mainView?.onShowProgress(false)
                        mainView?.showWhetherForecast(value)
                    }

                    override fun onError(e: Throwable?) {
                        e?.printStackTrace()
                        mainView?.onShowProgress(false)
                        mainView?.showError()
                    }
                })
    }

    fun isViewAttached(): Boolean {
        return mainView != null
    }


    fun checkViewAttached() {
        if (!isViewAttached()) throw MvpViewNotAttachedException()
    }

    class MvpViewNotAttachedException
        : RuntimeException("Please call Presenter.attachView(MvpView) before" + " requesting data to the Presenter")

}