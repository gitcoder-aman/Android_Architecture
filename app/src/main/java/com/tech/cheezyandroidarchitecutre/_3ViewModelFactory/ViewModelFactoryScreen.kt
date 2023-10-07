package com.tech.cheezyandroidarchitecutre._3ViewModelFactory

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.tech.cheezyandroidarchitecutre.MainActivity

@Composable
fun ViewModelFactoryScreen(context: MainActivity) {

    //parameter value initialize in viewModel
    var mainViewModelFactory =
        ViewModelProvider(context, MainViewModelProviderFactory(10))[MainViewModel::class.java]
    var count by remember {
        mutableStateOf(0)
    }
    mainViewModelFactory.count.observe(context, Observer {
        count = it
    })

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Count: $count")
            Button(onClick = { mainViewModelFactory.increment() }) {
                Text(text = "Increment")
            }
        }
    }

}