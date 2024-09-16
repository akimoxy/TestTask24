package com.example.testtask24.secondScreen.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtask24.firstScreen.domain.models.CardInfo
import com.example.testtask24.secondScreen.domain.HistoryInteractor
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class SecondFragmentViewModel(val historyInteractor: HistoryInteractor) : ViewModel() {
    private val historyLiveData =
        MutableLiveData<SecondFragmentState>(SecondFragmentState.EmptyHistory)

    init {
        getHistory()
    }

    fun getState(): LiveData<SecondFragmentState> = historyLiveData
    fun updateState(state: SecondFragmentState) {
        historyLiveData.value = state
    }

    var list = listOf<CardInfo>()
    fun getHistory() {
        viewModelScope.launch {
            historyInteractor.getAllHistory().collect {
                list = it
                if (list.isNotEmpty()) updateState(SecondFragmentState.History(list))
            }
        }
    }

}