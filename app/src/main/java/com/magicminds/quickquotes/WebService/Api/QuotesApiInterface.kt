package com.magicminds.quickquotes.WebService.Api

import com.magicminds.quickquotes.WebService.GetQuotes.Model.Quote
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

/**
 * Created by saaddar on 10/23/18.
 */
interface ApiServiceInterface {


    @GET("api/quotes")
    fun getQuotes():Call<List<Quote>>

    companion object Factory {
        fun create(): ApiServiceInterface {
            val retrofit = Retrofit.Builder()
                    .addConverterFactory(MoshiConverterFactory.create())
                    .baseUrl("https://talaikis.com/")
                    .build()

            return retrofit.create(ApiServiceInterface::class.java);
        }
    }
}