package com.tech.cheezyandroidarchitecutre._5RoomDatabase

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.Observer
import com.tech.cheezyandroidarchitecutre.ui.theme.CheezyAndroidArchitecutreTheme
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.Date

class RoomActivity : ComponentActivity() {
    @OptIn(DelicateCoroutinesApi::class)
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CheezyAndroidArchitecutreTheme {
                val database = (application as MyApplication).database.contactDao()

                GlobalScope.launch {
                    database.insertContact(ContactEntity(0, "john", "9999", Date()))
                }
                database.getContact().observe(this, Observer {
                    Log.d("room@@", "onCreate: $it")
                })
            }

        }
    }
}