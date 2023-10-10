package com.tech.cheezyandroidarchitecutre._6MVVM_pattern

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
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
import com.tech.cheezyandroidarchitecutre._6MVVM_pattern.database.QuoteDatabase
import com.tech.cheezyandroidarchitecutre._6MVVM_pattern.model.Quote
import com.tech.cheezyandroidarchitecutre._6MVVM_pattern.repository.QuoteRepository
import com.tech.cheezyandroidarchitecutre._6MVVM_pattern.viewmodel.QuoteViewModel
import com.tech.cheezyandroidarchitecutre._6MVVM_pattern.viewmodel.QuoteViewModelFactory
import com.tech.cheezyandroidarchitecutre.ui.theme.CheezyAndroidArchitecutreTheme
import com.tech.cheezyandroidarchitecutre.ui.theme.Pink40

class MvvmActivity : ComponentActivity() {
    private lateinit var quoteViewModel: QuoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            CheezyAndroidArchitecutreTheme {
                val dao = QuoteDatabase.getDatabase(applicationContext).quoteDao()
                val repository = QuoteRepository(dao)
                quoteViewModel = ViewModelProvider(
                    this,
                    QuoteViewModelFactory(repository)
                )[QuoteViewModel::class.java]

                var quotesList by remember { mutableStateOf(emptyList<Quote>()) }

                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Button(onClick = {
                                quoteViewModel.getQuotes().observe(this@MvvmActivity, Observer {
                                    quotesList = it
                                    Log.d("@@mvvm", "onCreate: $quotesList")
                                })
                            }) {
                                Text(text = "Show Quotes")
                            }
                            Button(onClick = {
                                val quote = Quote(0, "This is testing", "Testing")
                                quoteViewModel.insertQuote(quote)
                            }) {
                                Text(text = "Add Quotes")
                            }
                        }
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp)
                        ) {
                            items(quotesList) { quote ->
                                EachRow(quote = quote)
                            }
                        }


                    }
                }
            }
        }
    }
}

@Composable
fun EachRow(quote: Quote) {
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
            Text(text = quote.id.toString())
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = quote.text)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = quote.author)
        }
    }
}