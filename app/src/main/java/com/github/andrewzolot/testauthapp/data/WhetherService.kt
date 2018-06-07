package com.github.andrewzolot.testauthapp.data

import com.github.andrewzolot.testauthapp.data.model.MyReq
import io.reactivex.Observable

import retrofit2.http.*

/**
 * Created by Zolotuev
 */

interface WhetherService {

    @GET("/forecast/{sec_code}/{coordinates}")
    fun getData(@Path("sec_code") securityCode: String,
                @Path("coordinates") coordinates: String,
                @Query("units")  units: String,
                @Query("lang") lang: String): Observable<MyReq>

}
