package com.tech.cheezyandroidarchitecutre._7Retrofit_with_RoomMVVM.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tech.cheezyandroidarchitecutre._7Retrofit_with_RoomMVVM.repository.QuoteRepository

class RetrofitViewModelFactory(private val repository: QuoteRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return RetrofitViewModel(repository) as T
    }
}