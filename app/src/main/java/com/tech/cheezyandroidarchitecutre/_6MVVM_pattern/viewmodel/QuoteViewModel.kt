package com.tech.cheezyandroidarchitecutre._6MVVM_pattern.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tech.cheezyandroidarchitecutre._6MVVM_pattern.model.Quote
import com.tech.cheezyandroidarchitecutre._6MVVM_pattern.repository.QuoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuoteViewModel(private val quoteRepository: QuoteRepository) : ViewModel() {
    fun getQuotes(): LiveData<List<Quote>> {
        return quoteRepository.getQuote()
    }

    fun insertQuote(quote: Quote) {
        viewModelScope.launch(Dispatchers.IO) {
            quoteRepository.insertQuote(quote)
        }
    }
}