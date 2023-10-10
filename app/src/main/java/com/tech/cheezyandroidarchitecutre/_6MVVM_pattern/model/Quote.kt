package com.tech.cheezyandroidarchitecutre._6MVVM_pattern.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quote")
data class Quote(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val text : String,
    val author : String
)
