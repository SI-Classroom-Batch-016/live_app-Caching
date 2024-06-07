package com.example.liveappcaching.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.liveappcaching.data.Repository
import com.example.liveappcaching.data.local.getInstance
import kotlinx.coroutines.launch

class ListViewModel(application: Application) : AndroidViewModel(application) {


    private val repository = Repository(getInstance(application))

    val drinks = repository.drinks


    fun loadData(){
        viewModelScope.launch {
            repository.loadData()
        }
    }
}