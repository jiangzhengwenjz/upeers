package com.example.upeers.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "The list is currently empty. Click \"+\" icon to choose a course."
    }
    val text: LiveData<String> = _text
}