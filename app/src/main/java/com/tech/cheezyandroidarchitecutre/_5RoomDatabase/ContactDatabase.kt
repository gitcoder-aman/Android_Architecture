package com.tech.cheezyandroidarchitecutre._5RoomDatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.tech.cheezyandroidarchitecutre._5RoomDatabase.convertors.Convertors

@Database(entities = [ContactEntity::class], version = 2) //when do some update in database then change version id
@TypeConverters(Convertors::class)
abstract class ContactDatabase : RoomDatabase() {
    abstract fun contactDao() : ContactDAO
}