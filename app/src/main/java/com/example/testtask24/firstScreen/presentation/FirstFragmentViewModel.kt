package com.example.testtask24.firstScreen.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtask24.firstScreen.data.SERVER_CODE_200
import com.example.testtask24.firstScreen.domain.api.SearchInteractor
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class FirstFragmentViewModel(val seachInteractor: SearchInteractor) : ViewModel() {
    private val searchLiveData =
        MutableLiveData<FirstFragmentState>(FirstFragmentState.BeforeSearch)
    private var searchJob: Job? = null


    init {
        updateState(FirstFragmentState.BeforeSearch)
    }

    fun getState(): LiveData<FirstFragmentState> = searchLiveData
    fun updateState(state: FirstFragmentState) {
        searchLiveData.value = state
    }

    fun searchCardInfo(number: String) {
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            seachInteractor.searchInfo(number).let {
                if (it.resultCode == SERVER_CODE_200) {
                    updateState(FirstFragmentState.FoundInfo(it.cardInfo!!))
                } else {
                    updateState(FirstFragmentState.Error)
                }

            }
        }
    }

}