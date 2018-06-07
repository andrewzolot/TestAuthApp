package com.github.andrewzolot.testauthapp.ui

/**
 * Created by Zolotuev
 * Base presenter interface for MVP pattern
 */

interface Presenter{

    fun attachView(mvpView: MvpView)

    fun detachView()

}