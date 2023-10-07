package com.tech.cheezyandroidarchitecutre._4QuotesApp

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tech.cheezyandroidarchitecutre.R
import com.tech.cheezyandroidarchitecutre._4QuotesApp.model.Quote
import com.tech.cheezyandroidarchitecutre._4QuotesApp.viewModel.QuotesMainViewModel
import com.tech.cheezyandroidarchitecutre._4QuotesApp.viewModel.QuotesMainViewModelFactory

@Composable
fun QuotesScreen(context: QuotesActivity) {

    val cntx = LocalContext.current
    var quoteMainViewModel = ViewModelProvider(
        context,
        QuotesMainViewModelFactory(cntx)
    )[QuotesMainViewModel::class.java]

    val linearGradient = Brush.verticalGradient(
        colors = listOf(Color(0xFFC33764), Color(0xFF1D2671))
    )

    var quotes by remember {
        mutableStateOf<Quote>(Quote("", ""))
    }
    quoteMainViewModel.getQuote.observe(context, Observer {
        quotes = it
        Log.d("@@quote", "QuotesScreen: $it")
    })

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopStart) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(brush = linearGradient)
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = "Quotes App", style = TextStyle(
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.W600,
                    fontStyle = FontStyle.Italic
                )
            )
            CardLayout(quote = quotes)

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(onClick = { quoteMainViewModel.previousQuote() }) {
                    Text(text = "Previous")
                }
                Button(onClick = { quoteMainViewModel.nextQuote() }) {
                    Text(text = "Next")
                }
            }
        }
    }
}

@Composable
fun CardLayout(quote: Quote) {
    Card(
        modifier = Modifier
            .height(200.dp)
            .fillMaxWidth(),
        shape = CardDefaults.elevatedShape,
        colors = CardDefaults.cardColors(containerColor = Color.Red),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.Start
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_format_quote_24),
                contentDescription = null, tint = Color.White
            )
            quote.text?.let {
                Text(
                    text = it, style = TextStyle(
                        color = Color.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.W600,
                        textAlign = TextAlign.Center
                    ), modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
            quote.author?.let {
                Text(
                    text = it, style = TextStyle(
                        color = Color.White,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W300,
                        textAlign = TextAlign.Start
                    ), modifier = Modifier.align(Alignment.Start)
                )
            }
        }
    }
}