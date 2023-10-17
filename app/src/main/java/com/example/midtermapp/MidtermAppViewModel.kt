package com.example.midtermapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MidtermAppViewModel : ViewModel() {
    var numOfAttempts: MutableLiveData<Int> = MutableLiveData()
    var playerName: MutableLiveData<String> = MutableLiveData()
    var guess: MutableLiveData<Int> = MutableLiveData()

    fun incrementAttempts() {
        val currentAttempts = numOfAttempts.value ?: 0
        numOfAttempts.value = currentAttempts + 1
    }
}
