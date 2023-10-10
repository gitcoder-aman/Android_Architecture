package com.tech.cheezyandroidarchitecutre._6MVVM_pattern.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tech.cheezyandroidarchitecutre._6MVVM_pattern.repository.QuoteRepository

class QuoteViewModelFactory(private val quoteRepository: QuoteRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return QuoteViewModel(quoteRepository = quoteRepository) as T
    }
}