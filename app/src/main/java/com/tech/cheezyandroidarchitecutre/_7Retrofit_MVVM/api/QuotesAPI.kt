package com.tech.cheezyandroidarchitecutre._7Retrofit_MVVM.api

import com.tech.cheezyandroidarchitecutre._7Retrofit_MVVM.model.Quote
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuotesAPI {

    //https://quotable.io/quotes?page=1
    @GET("/quotes")
    suspend fun getQuotes(@Query("page")page : Int) : Response<Quote>
}