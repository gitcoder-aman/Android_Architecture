package com.tech.cheezyandroidarchitecutre._7Retrofit_MVVM.model

data class Quote(
    val count: Int,
    val lastItemIndex: Int,
    val page: Int,
    val results: List<Result>,
    val totalCount: Int,
    val totalPages: Int
)