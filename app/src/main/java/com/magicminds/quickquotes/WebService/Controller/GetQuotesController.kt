package com.magicminds.quickquotes.WebService.Controller

import com.magicminds.quickquotes.Utilities.Constants
import com.magicminds.quickquotes.WebService.Api.ApiClient
import com.magicminds.quickquotes.WebService.Api.ApiServiceInterface
import com.magicminds.quickquotes.WebService.Api.CallBackHandler
import com.magicminds.quickquotes.WebService.GetQuotes.Model.Quote
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by saaddar on 10/28/18.
 */
open class GetQuotesController : Callback<ArrayList<Quote>> {

    var callBack : CallBackHandler? = null

    fun onCreate(call: CallBackHandler) {
        callBack = call
    }

    fun onStart() {

        var apiClient = ApiClient.getApiClient().create(ApiServiceInterface::class.java)
        apiClient.getQuotes().enqueue(this)

    }


    override fun onFailure(call: Call<ArrayList<Quote>>?, t: Throwable?) {
        if (t != null) {
            callBack?.onFailure(t.localizedMessage)
        } else {
            callBack?.onFailure(Constants.GET_QUOTES_ON_FAILURE)
        }

    }

    override fun onResponse(call: Call<ArrayList<Quote>>?, response: Response<ArrayList<Quote>>?) {

        if (response != null) {
            if(response.isSuccessful && response.body() != null){
                callBack?.onSuccess(response.body() as Any)
                return
            }
        }

        callBack?.onFailure(Constants.GET_QUOTES_ON_FAILURE)
    }
}