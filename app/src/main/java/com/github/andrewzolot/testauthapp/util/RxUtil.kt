package com.github.andrewzolot.testauthapp.util

import io.reactivex.disposables.Disposable

object RxUtil {

    fun dispose(disposable: Disposable?) {
        if (disposable != null && !disposable.isDisposed) {
            disposable.dispose()
        }
    }

}
