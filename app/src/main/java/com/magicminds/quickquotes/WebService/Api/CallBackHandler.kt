package com.magicminds.quickquotes.WebService.Api

import java.util.*

/**
 * Created by saaddar on 10/28/18.
 */
interface CallBackHandler {

    fun onSuccess(response: Any)
    fun onFailure(message: String)
}