package com.github.andrewzolot.testauthapp.data

import com.github.andrewzolot.testauthapp.util.Const
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Zolotuev
 * Class generator to generate retrofit service
 */

object ServiceGenerator {

    var rxAdapter = RxJava2CallAdapterFactory.create()

    private val builder = Retrofit.Builder()
            .baseUrl(Const.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(rxAdapter)

    private val retrofit = builder.build()

    fun <S> createService(serviceClass: Class<S>): S {
        return retrofit.create(serviceClass)
    }
}
