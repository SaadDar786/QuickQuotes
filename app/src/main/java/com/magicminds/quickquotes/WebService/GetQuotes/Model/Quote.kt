package com.magicminds.quickquotes.WebService.GetQuotes.Model

/**
 * Created by saaddar on 10/19/18.
 */
class Quote {
    var author: String
    var cat: String
    var quote: String

    constructor(title: String, cat: String, quote: String) {
        this.author = title
        this.cat = cat
        this.quote = quote
    }
}