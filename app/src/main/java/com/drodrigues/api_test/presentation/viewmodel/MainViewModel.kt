package com.drodrigues.api_test.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.drodrigues.api_test.domain.entity.ShowEntity
import com.drodrigues.api_test.domain.usecase.GetShowByIdUseCase
import com.drodrigues.api_test.domain.usecase.GetShowCompleteListUseCase
import kotlinx.coroutines.launch

internal class MainViewModel(
    private val getShowCompleteListUseCase: GetShowCompleteListUseCase,
    private val getShowByIdUseCase: GetShowByIdUseCase,
) : ViewModel() {

    private val _getShowCompleteListLiveData: MutableLiveData<List<ShowEntity>> = MutableLiveData()
    val getShowCompleteListLiveData: LiveData<List<ShowEntity>> = _getShowCompleteListLiveData

    private val _getShowByIdLiveData: MutableLiveData<ShowEntity> = MutableLiveData()
    val getShowByIdLiveData: LiveData<ShowEntity> = _getShowByIdLiveData

    suspend fun getShowCompleteList() {
        viewModelScope.launch {
            _getShowCompleteListLiveData.value = getShowCompleteListUseCase.execute()
        }
    }

    suspend fun getShowById(id: String) {
        viewModelScope.launch {
            _getShowByIdLiveData.value = getShowByIdUseCase.execute(id)
        }
    }

    suspend fun getSeasonListByShowId() {
        TODO()
    }

    suspend fun getEpisodeListBySeasonId() {
        TODO()
    }

    suspend fun searchShowByQuery() {
        TODO()
    }
}

