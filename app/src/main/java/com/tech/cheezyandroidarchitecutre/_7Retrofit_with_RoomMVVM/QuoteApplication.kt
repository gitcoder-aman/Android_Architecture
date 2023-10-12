package com.tech.cheezyandroidarchitecutre._7Retrofit_with_RoomMVVM

import android.app.Application
import com.tech.cheezyandroidarchitecutre._7Retrofit_with_RoomMVVM.api.QuotesAPI
import com.tech.cheezyandroidarchitecutre._7Retrofit_with_RoomMVVM.api.RetrofitHelper
import com.tech.cheezyandroidarchitecutre._7Retrofit_with_RoomMVVM.db.QuoteDatabase
import com.tech.cheezyandroidarchitecutre._7Retrofit_with_RoomMVVM.repository.QuoteRepository

class QuoteApplication : Application() {

    lateinit var quoteRepository: QuoteRepository
    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        val quoteAPI = RetrofitHelper.getInstance().create(QuotesAPI::class.java)
        val database = QuoteDatabase.getDatabase(applicationContext)
        quoteRepository = QuoteRepository(quoteAPI,database,applicationContext)
    }
}