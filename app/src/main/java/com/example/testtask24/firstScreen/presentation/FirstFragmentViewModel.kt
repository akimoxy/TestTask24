package com.example.testtask24.firstScreen.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtask24.firstScreen.data.SERVER_CODE_200
import com.example.testtask24.firstScreen.domain.api.SearchInteractor
import com.example.testtask24.firstScreen.domain.models.Bank
import com.example.testtask24.firstScreen.domain.models.CardInfo
import com.example.testtask24.firstScreen.domain.models.Country
import com.example.testtask24.firstScreen.domain.models.NumberCard
import com.example.testtask24.secondScreen.domain.HistoryInteractor
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class FirstFragmentViewModel(
    val seachInteractor: SearchInteractor,
    val historyInteractor: HistoryInteractor
) : ViewModel() {
    private val searchLiveData =
        MutableLiveData<FirstFragmentState>(FirstFragmentState.BeforeSearch)

    init {
        updateState(FirstFragmentState.BeforeSearch)
    }

    fun getState(): LiveData<FirstFragmentState> = searchLiveData
    private fun updateState(state: FirstFragmentState) {
        searchLiveData.value = state
    }

    fun searchCardInfo(number: String) {
        viewModelScope.launch {
            seachInteractor.searchInfo(number).let {
                if (it.resultCode == SERVER_CODE_200) {
                    updateState(FirstFragmentState.FoundInfo(it.cardInfo!!))
                    historyInteractor.saveToHistory(it.cardInfo)
                } else {
                    updateState(FirstFragmentState.Error)
                }
            }
        }
    }

}