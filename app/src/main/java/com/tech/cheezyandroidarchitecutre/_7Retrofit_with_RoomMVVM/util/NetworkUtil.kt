package com.tech.cheezyandroidarchitecutre._7Retrofit_with_RoomMVVM.util

import android.content.Context
import android.net.ConnectivityManager

class NetworkUtil{

    companion object{
        fun isNetworkAvailable(context: Context): Boolean {
            val connectivityManager =
                (context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager)
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            return activeNetworkInfo != null && activeNetworkInfo.isConnected
        }
    }
}