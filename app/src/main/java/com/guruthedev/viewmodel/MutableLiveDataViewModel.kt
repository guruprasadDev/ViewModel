package com.guruthedev.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MutableLiveDataViewModel : ViewModel() {

    var textMutableLiveData = MutableLiveData<String>()
    var btnMutableLiveData = MutableLiveData<String>()

    init {
        textMutableLiveData.value = "Hey, Follow my Instagram page"
        btnMutableLiveData.value = "FOLLOW"
    }

    fun updateText(){
        textMutableLiveData.value = "Welcome to my Instagram page and thanks for following"
        btnMutableLiveData.value = "FOLLOWING"

    }
}