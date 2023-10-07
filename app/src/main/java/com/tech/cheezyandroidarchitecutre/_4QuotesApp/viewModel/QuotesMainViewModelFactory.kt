package com.tech.cheezyandroidarchitecutre._4QuotesApp.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class QuotesMainViewModelFactory(private val context : Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return QuotesMainViewModel(context) as T
    }
}