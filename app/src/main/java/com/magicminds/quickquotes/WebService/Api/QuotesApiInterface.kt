package com.magicminds.quickquotes.WebService.Api

import com.magicminds.quickquotes.WebService.GetQuotes.Model.Quote
import retrofit2.Call

import retrofit2.http.GET

/**
 * Created by saaddar on 10/23/18.
 */
interface ApiServiceInterface {


    @GET("api/quotes")
    fun getQuotes():Call<ArrayList<Quote>>
}