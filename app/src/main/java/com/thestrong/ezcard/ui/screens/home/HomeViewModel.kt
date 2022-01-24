package com.thestrong.ezcard.ui.screens.home

import androidx.lifecycle.ViewModel
import com.thestrong.ezcard.data.repository.card.Card

class HomeViewModel(val card: Card) : ViewModel() {
    init {

    }



    override fun onCleared() {
        super.onCleared()
    }
}