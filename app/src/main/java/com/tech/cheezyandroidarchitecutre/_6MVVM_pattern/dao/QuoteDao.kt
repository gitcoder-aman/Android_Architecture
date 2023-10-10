package com.tech.cheezyandroidarchitecutre._6MVVM_pattern.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.tech.cheezyandroidarchitecutre._6MVVM_pattern.model.Quote

@Dao
interface QuoteDao {
    @Query("SELECT * from quote")
    fun getQuotes() : LiveData<List<Quote>> //this is already run on the background thread(Coroutine) because using liveData

    @Insert
    suspend fun insertQuote(quote : Quote)
}