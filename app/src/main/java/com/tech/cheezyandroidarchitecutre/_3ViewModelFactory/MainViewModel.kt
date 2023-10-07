package com.tech.cheezyandroidarchitecutre._3ViewModelFactory

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(private val initialValue : Int) : ViewModel() {

    //livedata
    private val _count = MutableLiveData<Int>(initialValue)

    val count: LiveData<Int>
        get() = _count

    fun increment() {
        Log.d("@@viewmodel", "increment: ${_count.value}")
        _count.value = _count.value!! + 1
    }
}