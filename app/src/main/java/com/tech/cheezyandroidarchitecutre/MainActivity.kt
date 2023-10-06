package com.tech.cheezyandroidarchitecutre

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.tech.cheezyandroidarchitecutre.lifecycle_aware.Observer
import com.tech.cheezyandroidarchitecutre.ui.theme.CheezyAndroidArchitecutreTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CheezyAndroidArchitecutreTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                    lifecycle.addObserver(Observer())
                    Log.d("@@MAIN", "onCreate: Activity on Create:")
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
