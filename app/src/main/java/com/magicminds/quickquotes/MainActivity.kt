package com.magicminds.quickquotes

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.magicminds.quickquotes.Core.FragmentUtility
import com.magicminds.quickquotes.Quotes.View.QuoteListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    fun initView() {

        FragmentUtility.replaceFragment(QuoteListFragment(), supportFragmentManager, R.id.mainLayout, "QuoteListFragment" ,true,true )
    }


}
