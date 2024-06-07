package com.example.liveappcaching.ui.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.liveappcaching.data.Repository
import com.example.liveappcaching.data.local.getInstance
import com.example.liveappcaching.data.model.DrinkDetails
import kotlinx.coroutines.launch

class DetailViewModel(application: Application) : AndroidViewModel(application) {


    private val repository = Repository(getInstance(application))

    fun getDrinkDetails(id : Int) : LiveData<DrinkDetails> {

        viewModelScope.launch {
            repository.cacheDrinkDetails(id)

            Log.d("DetailViewModel", "1")
        }
        Log.d("DetailViewModel", "2")
        return repository.drinkDetails(id)
    }



}