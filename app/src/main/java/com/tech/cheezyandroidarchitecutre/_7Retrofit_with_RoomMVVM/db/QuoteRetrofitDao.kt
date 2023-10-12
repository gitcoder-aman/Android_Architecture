package com.tech.cheezyandroidarchitecutre._7Retrofit_with_RoomMVVM.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.tech.cheezyandroidarchitecutre._7Retrofit_with_RoomMVVM.model.Result

@Dao
interface QuoteRetrofitDao {
    @Insert
    suspend fun addQuote(quotes : List<Result>)

    @Query("select * from quoteResult")
    suspend fun getQuotes() : List<Result>
}