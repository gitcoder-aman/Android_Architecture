package com.tech.cheezyandroidarchitecutre._7Retrofit_with_RoomMVVM.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tech.cheezyandroidarchitecutre._7Retrofit_with_RoomMVVM.model.Result

@Database(entities = [Result::class], version = 1, exportSchema = false)
abstract class QuoteDatabase : RoomDatabase() {
    abstract fun quoteDao(): QuoteRetrofitDao

    companion object {

        @Volatile
        private var INSTANCE: QuoteDatabase? = null

        fun getDatabase(context: Context): QuoteDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        QuoteDatabase::class.java,
                        "quoteDB"
                    )
                        .build()
                }
            }
            return INSTANCE!!
        }
    }
}