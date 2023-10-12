package com.tech.cheezyandroidarchitecutre._7Retrofit_with_RoomMVVM.model

data class Quote(
    val count: Int,
    val lastItemIndex: Int,
    val page: Int,
    val results: List<Result>,
    val totalCount: Int,
    val totalPages: Int
)