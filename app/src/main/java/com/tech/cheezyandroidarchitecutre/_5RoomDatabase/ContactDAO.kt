package com.tech.cheezyandroidarchitecutre._5RoomDatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ContactDAO {

    @Insert
    suspend fun insertContact(contact : ContactEntity)

    @Update
    suspend fun updateContact(contact : ContactEntity)

    @Delete
    suspend fun deleteContact(contact: ContactEntity)

    @Query("SELECT * FROM contact")
    fun getContact() : LiveData<List<ContactEntity>>  //coroutine check is that liveData or not,if livedata then coroutine execute in background thread.
    //which is compatible coroutine with livedata
}