package com.magicminds.quickquotes.Quotes.Presenter

import com.magicminds.quickquotes.Quotes.QuoteListContract
import com.magicminds.quickquotes.WebService.Api.CallBackHandler
import com.magicminds.quickquotes.WebService.Controller.GetQuotesController
import com.magicminds.quickquotes.WebService.GetQuotes.Model.Quote
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by saaddar on 10/24/18.
 */
open class QuoteListPresenter : QuoteListContract.presenter, CallBackHandler {

    var  mView : QuoteListContract.view? = null

    override fun onStart(view: QuoteListContract.view) {
        mView = view
    }

    override fun onStop() {
        mView = null
    }

    override fun getQuotesList() {
        mView?.showLoadingIndicator()
        var controller : GetQuotesController = GetQuotesController()
        controller.onCreate(this)
        controller.onStart()


    }

    override fun getRandomQuote() {
        mView?.showLoadingIndicator()
    }

    override fun onSuccess(response: Any) {
        mView?.hideLoadingIndicator()

        if(response != null && response is ArrayList<*>) {
            mView?.updateQuoteList(response as ArrayList<Quote>)
        }

    }

    override fun onFailure(message: String) {
        mView?.hideLoadingIndicator()
        mView?.showExceptionMessage(message)
    }

}