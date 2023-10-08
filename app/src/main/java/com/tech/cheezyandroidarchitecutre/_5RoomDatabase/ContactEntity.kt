package com.tech.cheezyandroidarchitecutre._5RoomDatabase

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "contact")
data class ContactEntity(
    @PrimaryKey(autoGenerate = true)
    val id : Long,
    val name : String,
    val phone : String,

    val createDate : Date
)
