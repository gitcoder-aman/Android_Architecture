package com.tech.cheezyandroidarchitecutre._4QuotesApp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.tech.cheezyandroidarchitecutre.ui.theme.CheezyAndroidArchitecutreTheme

class QuotesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)
        val controller = WindowInsetsControllerCompat(window, window.decorView)
        controller.hide(WindowInsetsCompat.Type.systemBars())
        setContent {
            CheezyAndroidArchitecutreTheme {
                QuotesScreen(this)
            }
        }
    }
}