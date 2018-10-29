package com.magicminds.quickquotes.Quotes.View

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import com.magicminds.quickquotes.Quotes.Presenter.QuoteListPresenter
import com.magicminds.quickquotes.Quotes.QuoteListContract
import com.magicminds.quickquotes.R
import com.magicminds.quickquotes.WebService.GetQuotes.Model.Quote

/**
 * Created by saaddar on 10/24/18.
 */
open class QuoteListFragment : android.support.v4.app.Fragment(), QuoteListContract.view {

    var recyclerView : RecyclerView? = null
    var progressIndicator : ProgressBar? = null
    var errorMessage : TextView? = null
    var mPresenter : QuoteListContract.presenter? = null


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view: View = inflater!!.inflate(R.layout.quotes_fragment, container,
                false)
        recyclerView = view.findViewById<RecyclerView>(R.id.quote_list) as RecyclerView
        progressIndicator = view.findViewById(R.id.progressBar)
        errorMessage = view.findViewById(R.id.errView)

        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mPresenter = QuoteListPresenter()
        mPresenter?.onStart(this)

        // Set up recycler view
        recyclerView?.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))

        recyclerView?.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL,false);

        val adapter = QuoteListAdapter(context)
        recyclerView?.adapter = adapter

        // Get the quotes
        getQuoteList()

    }

    fun getQuoteList(){
        showLoadingIndicator()
        mPresenter?.getQuotesList();
    }


    override fun showLoadingIndicator() {
        progressIndicator?.visibility = View.VISIBLE
    }

    override fun hideLoadingIndicator() {
        progressIndicator?.visibility = View.GONE
    }

    override fun updateQuoteList(list: ArrayList<Quote>) {
        (recyclerView?.adapter as QuoteListAdapter).updateData(list)
    }

    override fun showExceptionMessage(message: String) {
        errorMessage?.text = message
        errorMessage?.visibility = View.VISIBLE
    }

    override fun onDestroy() {
        mPresenter?.onStop()
        super.onDestroy()
    }

}