package com.tech.cheezyandroidarchitecutre._7Retrofit_MVVM.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tech.cheezyandroidarchitecutre._7Retrofit_MVVM.api.QuotesAPI
import com.tech.cheezyandroidarchitecutre._7Retrofit_MVVM.model.Quote

class QuoteRepository(private val quotesAPI: QuotesAPI) {

    private val _quoteLiveData = MutableLiveData<Quote>()

    val quotes : LiveData<Quote>
        get() = _quoteLiveData
    suspend fun getQuotes(page : Int){
        val result = quotesAPI.getQuotes(page)

        if(result.isSuccessful && result.body() != null){
            _quoteLiveData.postValue(result.body())
        }
    }
}