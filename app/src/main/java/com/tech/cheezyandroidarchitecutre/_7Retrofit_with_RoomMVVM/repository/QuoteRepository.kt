package com.tech.cheezyandroidarchitecutre._7Retrofit_with_RoomMVVM.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tech.cheezyandroidarchitecutre._7Retrofit_with_RoomMVVM.api.QuotesAPI
import com.tech.cheezyandroidarchitecutre._7Retrofit_with_RoomMVVM.db.QuoteDatabase
import com.tech.cheezyandroidarchitecutre._7Retrofit_with_RoomMVVM.model.Quote
import com.tech.cheezyandroidarchitecutre._7Retrofit_with_RoomMVVM.util.NetworkUtil

class QuoteRepository(
    private val quotesAPI: QuotesAPI,
    private val quoteDatabase: QuoteDatabase,
    private val applicationContext: Context
) {

    private val _quoteLiveData = MutableLiveData<Quote>()

    val quotes: LiveData<Quote>
        get() = _quoteLiveData

    suspend fun getQuotes(page: Int) {
        if (NetworkUtil.isNetworkAvailable(applicationContext)) { // when internet is available the hit api otherwise show data from room database
            val result = quotesAPI.getQuotes(page)
            if (result.isSuccessful && result.body() != null) {
                quoteDatabase.quoteDao().addQuote(result.body()!!.results)
                _quoteLiveData.postValue(result.body())
            }
        } else {
            val quotesResult = quoteDatabase.quoteDao().getQuotes()
            val quote = Quote(1,1,1,quotesResult,1,1)
            _quoteLiveData.postValue(quote)
        }

    }
}