package com.magicminds.quickquotes.WebService.Api

import com.magicminds.quickquotes.Utilities.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by saaddar on 10/28/18.
 */
class ApiClient {

    companion object Factory {
        fun getApiClient(): Retrofit {
            val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(Constants.BASE_URL)
                    .build()

            return  retrofit
        }
    }
}