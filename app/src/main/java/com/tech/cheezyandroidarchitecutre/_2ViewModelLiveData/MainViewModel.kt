package com.tech.cheezyandroidarchitecutre._2ViewModelLiveData

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    //livedata
    private val _count = MutableLiveData<Int>(0)

    val count: LiveData<Int>
        get() = _count

    fun increment() {
        Log.d("@@viewmodel", "increment: ${_count.value}")
        _count.value = _count.value!! + 1
    }

}