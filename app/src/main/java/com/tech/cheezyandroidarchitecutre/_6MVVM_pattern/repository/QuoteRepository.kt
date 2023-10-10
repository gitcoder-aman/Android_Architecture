package com.tech.cheezyandroidarchitecutre._6MVVM_pattern.repository

import androidx.lifecycle.LiveData
import com.tech.cheezyandroidarchitecutre._6MVVM_pattern.dao.QuoteDao
import com.tech.cheezyandroidarchitecutre._6MVVM_pattern.model.Quote

class QuoteRepository(private val quoteDao : QuoteDao) {
    fun getQuote() : LiveData<List<Quote>> {
        return quoteDao.getQuotes()
    }
    suspend fun insertQuote(quote: Quote){
        quoteDao.insertQuote(quote)
    }
}