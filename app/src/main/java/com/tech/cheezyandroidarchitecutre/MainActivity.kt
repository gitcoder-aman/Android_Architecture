package com.tech.cheezyandroidarchitecutre

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
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
import com.tech.cheezyandroidarchitecutre._2ViewModelLiveData.MainViewModel
import com.tech.cheezyandroidarchitecutre._3ViewModelFactory.ViewModelFactoryScreen
import com.tech.cheezyandroidarchitecutre.ui.theme.CheezyAndroidArchitecutreTheme

class MainActivity : ComponentActivity() {

     lateinit var mainViewModel:MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
            CheezyAndroidArchitecutreTheme {
                var count by remember {
                    mutableStateOf(0)
                }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    lifecycle.addObserver(com.tech.cheezyandroidarchitecutre._1lifecycle_aware.Observer())
                    Log.d("@@MAIN", "onCreate: Activity on Create:")
                    mainViewModel.count.observe(this@MainActivity, Observer {  //LiveData use
                        count = it
                    })

//                    Column(
//                        modifier = Modifier.fillMaxSize(),
//                        horizontalAlignment = Alignment.CenterHorizontally,
//                        verticalArrangement = Arrangement.Center
//                    ) {
//                        Text(text = "Count: $count" )
//                        Button(onClick = { mainViewModel.increment() }) {
//                            Text(text = "Increment")
//                        }
//                    }
                    ViewModelFactoryScreen(this)
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d("@@MAIN", "onCreate: Activity on Resume:")
    }

    override fun onPause() {
        super.onPause()
        Log.d("@@MAIN", "onCreate: Activity on Pause:")
    }

    override fun onStop() {
        super.onStop()
        Log.d("@@MAIN", "onCreate: Activity on Stop:")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("@@MAIN", "onCreate: Activity on Destroy:")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
