package com.tech.cheezyandroidarchitecutre._4QuotesApp.viewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.tech.cheezyandroidarchitecutre._4QuotesApp.model.Quote

class QuotesMainViewModel(val context: Context) : ViewModel() {
    private var quoteList: Array<Quote> = emptyArray()
    private var index = 0

    init {
        quoteList = loadQuoteFromAssets()
    }

    private fun loadQuoteFromAssets(): Array<Quote> {

        //file read
        val inputStream = context.assets.open("quotes.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()

        val json = String(buffer, Charsets.UTF_8)  //convert into string form from gson data
        val gson = Gson()
        return gson.fromJson(json, Array<Quote>::class.java) //parse string data in Gson and return
    }

    private val _getQuote = MutableLiveData<Quote>(quoteList[index])

    val getQuote: LiveData<Quote>
        get() = _getQuote

    fun nextQuote() {
        index += 1
        _getQuote.value = quoteList[index]
    }
    fun previousQuote(){
        index -= 1
        _getQuote.value = quoteList[index]
    }
}