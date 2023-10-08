package com.tech.cheezyandroidarchitecutre._5RoomDatabase

import android.app.Application

class MyApplication : Application() {
    val database by lazy { DatabaseBuilder.getDatabase(this) }
}