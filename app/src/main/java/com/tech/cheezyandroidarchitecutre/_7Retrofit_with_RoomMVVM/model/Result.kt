package com.tech.cheezyandroidarchitecutre._7Retrofit_with_RoomMVVM.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quoteResult")
data class Result(

    @PrimaryKey(autoGenerate = true)
    val quoteId : Int,

    val _id: String,
    val author: String,
    val authorSlug: String,
    val content: String,
    val dateAdded: String,
    val dateModified: String,
    val length: Int
)