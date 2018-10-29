package com.magicminds.quickquotes.Quotes

import com.magicminds.quickquotes.WebService.GetQuotes.Model.Quote

/**
 * Created by saaddar on 10/24/18.
 */
interface QuoteListContract {

    interface presenter {

        fun getQuotesList()
        fun getRandomQuote()
        fun onStart(view:QuoteListContract.view)
        fun onStop()

    }

    interface view {

        fun showLoadingIndicator()
        fun hideLoadingIndicator()
        fun updateQuoteList(list: ArrayList<Quote>)
        fun showExceptionMessage(message: String)

    }
}