package com.magicminds.quickquotes.Quotes.View


import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.magicminds.quickquotes.R
import com.magicminds.quickquotes.WebService.GetQuotes.Model.Quote
import kotlinx.android.synthetic.main.list_item_quote.view.*

/**
 * Created by saaddar on 10/25/18.
 */
class QuoteListAdapter (var appContext: Context): RecyclerView.Adapter<QuoteHolder>() {

    private var mData = ArrayList<Quote>()
    private var context: Context? = null

    init {
        context = appContext
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): QuoteHolder {

        val v = LayoutInflater.from(parent?.context).inflate(R.layout.list_item_quote, parent, false)
        return QuoteHolder(v);
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: QuoteHolder?, position: Int) {
        holder?.quoteDescription?.text = mData.get(position).quote
    }

    fun updateData(list: ArrayList<Quote>){

        mData.clear()
        mData.addAll(list)
        this.notifyDataSetChanged()
    }
}

class QuoteHolder(v: View) : RecyclerView.ViewHolder(v){
    var quoteDescription = v.quote_description
}