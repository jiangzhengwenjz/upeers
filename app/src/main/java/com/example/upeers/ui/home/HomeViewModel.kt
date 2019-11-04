package com.example.upeers.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "The course list is currently empty. Press \"+\" button to add a course."
    }
    val text: LiveData<String> = _text
}