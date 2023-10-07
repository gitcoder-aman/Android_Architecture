package com.tech.cheezyandroidarchitecutre._1lifecycle_aware

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

class Observer : DefaultLifecycleObserver {

    //if you want to when onCreate of lifecycle(Activity) is create then quick start onCreate of ObServer
    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        Log.d("@@MAIN", "OBSERVER: on Create:")
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        Log.d("@@MAIN", "OBSERVER: on Resume:")
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        Log.d("@@MAIN", "OBSERVER: on Pause:")
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        Log.d("@@MAIN", "OBSERVER: on Stop:")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        Log.d("@@MAIN", "OBSERVER: on Destroy:")
    }
}