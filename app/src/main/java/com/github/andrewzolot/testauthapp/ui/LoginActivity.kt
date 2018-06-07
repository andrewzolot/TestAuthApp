package com.github.andrewzolot.testauthapp.ui

import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView

import android.os.StrictMode
import android.support.v7.app.AlertDialog
import android.view.Menu
import android.view.MenuItem
import android.view.MotionEvent
import com.github.andrewzolot.testauthapp.*
import com.github.andrewzolot.testauthapp.data.ServiceGenerator
import com.github.andrewzolot.testauthapp.data.WhetherService
import com.github.andrewzolot.testauthapp.data.model.MyReq
import com.github.andrewzolot.testauthapp.util.MyPasswordTransformation

import kotlinx.android.synthetic.main.activity_login.*

/**
 * Created by Zolotuev
 * A login screen that offers login via email/password.
 */
class LoginActivity : AppCompatActivity(), MvpView {

    private lateinit var mainPresenter : MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setSupportActionBar(toolbar)

        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder().permitAll().build())

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.toolbar_title)
        // Init presenter
        mainPresenter = MainPresenter(ServiceGenerator.createService(WhetherService::class.java))
        mainPresenter.attachView(this)

        password.setOnEditorActionListener(TextView.OnEditorActionListener { _, id, _ ->
            if (id == EditorInfo.IME_ACTION_DONE || id == EditorInfo.IME_NULL) {
                mainPresenter.attemptLogin(email.text.toString(), password.text.toString())
                return@OnEditorActionListener true
            }
            false
        })
        password.transformationMethod = MyPasswordTransformation()
        email_sign_in_button.setOnClickListener { mainPresenter.attemptLogin(email.text.toString(), password.text.toString())}
        password.setOnTouchListener{ view: View, motionEvent: MotionEvent ->
            val DRAWABLE_RIGHT = 2
            if (motionEvent.action == MotionEvent.ACTION_UP){
                if(motionEvent.getRawX() >= (password.getRight() - password
                                            .getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())){
                    mainPresenter.onPasswordDrawableTouch(AlertDialog.Builder(this))
                }
            }
            false
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.create_menu, menu);
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    /**
     * Shows the progress UI and hides the login form.
     */

    override fun onShowProgress(show: Boolean) {

        login_progress.visibility = if (show) View.VISIBLE else View.GONE

    }

    /**
     * Set errors after validity check
     */

    override fun onSetLoginFormErrors(emailError: String?, passwordError: String?) {
        password.error = passwordError
        email.error = emailError
    }

    /**
     * Request focus for view with error
     */

    override fun onRequestFocus() {
        if (password.error != null) password.requestFocus()
        if (email.error != null) email.requestFocus()
    }

    override fun showWhetherForecast(myReq: MyReq?) {
        var result = "=)"
        if (myReq != null) result = "В Москве сейчас " + myReq.currently?.temperature + " " +'\u00B0'
        val mes = Snackbar.make(email_sign_in_button, result, Snackbar.LENGTH_LONG)
        mes.show()
    }

    /**
     * Show error if problems with Whether Service
     */

    override fun showError() {
        val mes = Snackbar.make(email_sign_in_button, R.string.forecast_request_error, Snackbar.LENGTH_LONG)
        mes.show()
    }

    override fun getStringFromResources(id: Int): String {
        return resources.getString(id)
    }

    public override fun onDestroy() {
        mainPresenter.detachView()
        super.onDestroy()
    }

}
