package com.github.andrewzolot.testauthapp.util

import android.text.method.PasswordTransformationMethod
import android.view.View

/**
 * Created by Zolotuev
 * Class allow change default password transformation symbol
 */

class MyPasswordTransformation : PasswordTransformationMethod() {

    override fun getTransformation(source: CharSequence?, view: View?): CharSequence {
        return PasswordCharSequence(source)
    }

    private class PasswordCharSequence(val source: CharSequence?) : CharSequence {
        override val length: Int
            get() = source!!.length

        override fun get(index: Int): Char {
            return '\u25CF'
        }

        override fun subSequence(startIndex: Int, endIndex: Int): CharSequence {
            return source!!.subSequence(startIndex, endIndex)
        }

    }
}