package com.github.andrewzolot.testauthapp.ui

import com.github.andrewzolot.testauthapp.data.model.MyReq

/**
 * Created by Zolotuev
 * Base View interface from MVP pattern
 */

interface MvpView{

    fun onSetLoginFormErrors(emailError : String?, passwordError : String?)

    fun onRequestFocus()

    fun onShowProgress(show : Boolean)

    fun showError()

    fun showWhetherForecast(myReq: MyReq?)

    fun getStringFromResources(id: Int): String

}