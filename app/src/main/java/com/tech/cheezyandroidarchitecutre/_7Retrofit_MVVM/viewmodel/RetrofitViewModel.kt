package com.tech.cheezyandroidarchitecutre._7Retrofit_MVVM.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tech.cheezyandroidarchitecutre._7Retrofit_MVVM.model.Quote
import com.tech.cheezyandroidarchitecutre._7Retrofit_MVVM.repository.QuoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RetrofitViewModel(private val repository: QuoteRepository) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getQuotes(1)
        }
    }
    val quotes : LiveData<Quote>
        get() = repository.quotes
}