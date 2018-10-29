package com.magicminds.quickquotes.WebService.GetQuotes.Model

import com.google.gson.annotations.SerializedName

/**
 * Created by saaddar on 10/19/18.
 */
data class Quote (@SerializedName("title") var title: String, @SerializedName("cat") var category: String, @SerializedName("quote")
var quote: String)