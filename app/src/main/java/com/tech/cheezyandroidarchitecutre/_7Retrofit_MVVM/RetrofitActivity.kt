package com.tech.cheezyandroidarchitecutre._7Retrofit_MVVM

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.tech.cheezyandroidarchitecutre._7Retrofit_MVVM.model.Result
import com.tech.cheezyandroidarchitecutre._7Retrofit_MVVM.api.QuotesAPI
import com.tech.cheezyandroidarchitecutre._7Retrofit_MVVM.api.RetrofitHelper
import com.tech.cheezyandroidarchitecutre._7Retrofit_MVVM.repository.QuoteRepository
import com.tech.cheezyandroidarchitecutre._7Retrofit_MVVM.viewmodel.RetrofitViewModel
import com.tech.cheezyandroidarchitecutre._7Retrofit_MVVM.viewmodel.RetrofitViewModelFactory
import com.tech.cheezyandroidarchitecutre.ui.theme.CheezyAndroidArchitecutreTheme
import com.tech.cheezyandroidarchitecutre.ui.theme.Pink40
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RetrofitActivity : ComponentActivity() {
    private lateinit var retrofitViewModel: RetrofitViewModel

    @OptIn(DelicateCoroutinesApi::class)
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val quoteAPI = RetrofitHelper.getInstance().create(QuotesAPI::class.java)
        val repository = QuoteRepository(quoteAPI)
        retrofitViewModel = ViewModelProvider(
            this,
            RetrofitViewModelFactory(repository)
        )[RetrofitViewModel::class.java]

        setContent {
            CheezyAndroidArchitecutreTheme {

                var result by remember { mutableStateOf(emptyList<Result>()) }
//                val quotesAPI = RetrofitHelper.getInstance().create(QuotesAPI::class.java)
//
//                GlobalScope.launch {
//                    val response = quotesAPI.getQuotes(2)
//                    if (response.isSuccessful) {
//                        result = response.body()?.results!!
//                        Log.d("@@retrofit", "onCreate: ${response.body().toString()}")
//                    }
//                }
                retrofitViewModel.quotes.observe(this, Observer {
                    result = it.results
                })
                LazyColumn {
                    items(result) {
                        QuoteEachRow(quote = it)
                    }
                }
            }
        }
    }
}

@Composable
fun QuoteEachRow(quote: Result) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .height(200.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Pink40, shape = RoundedCornerShape(4.dp))
                .padding(8.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "id: " + quote._id)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "author: " + quote.author)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "content: " + quote.content)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "tags " + quote.tags.toString())
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "authorSlug: " + quote.authorSlug)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Date Added: " + quote.dateAdded)
        }

    }
}