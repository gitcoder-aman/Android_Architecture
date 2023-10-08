package com.tech.cheezyandroidarchitecutre._5RoomDatabase

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

object DatabaseBuilder {


    //create singleton object
    @Volatile  //when something is write in INSTANCE then all thread inform that.
    private var INSTANCE : ContactDatabase ?= null

    fun getDatabase(context : Context) : ContactDatabase{
        return INSTANCE ?: synchronized(this){  //synchronized is locking system which create on instance     // Code that should be executed by only one thread at a time

            val instance = Room.databaseBuilder(
                context.applicationContext,
                ContactDatabase::class.java,
                "contactDB"
            ).build()
            INSTANCE = instance
            instance
        }
    }
}