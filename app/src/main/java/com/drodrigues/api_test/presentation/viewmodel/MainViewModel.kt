package com.drodrigues.tvdome.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.drodrigues.tvdome.domain.entity.EpisodeEntity
import com.drodrigues.tvdome.domain.entity.SearchResponseEntity
import com.drodrigues.tvdome.domain.entity.SeasonEntity
import com.drodrigues.tvdome.domain.entity.ShowEntity
import com.drodrigues.tvdome.domain.usecase.*
import kotlinx.coroutines.launch

internal class MainViewModel(
    private val getShowCompleteListUseCase: GetShowCompleteListUseCase,
    private val getShowByIdUseCase: GetShowByIdUseCase,
    private val getSeasonListByShowIdUseCase: GetSeasonListByShowIdUseCase,
    private val getEpisodeListBySeasonIdUseCase: GetEpisodeListBySeasonIdUseCase,
    private val getEpisodeByIdUseCase: GetEpisodeByIdUseCase,
    private val searchShowByQueryUseCase: SearchShowByQueryUseCase
) : ViewModel() {

    private val _getShowCompleteListLiveData: MutableLiveData<List<ShowEntity>> = MutableLiveData()
    val getShowCompleteListLiveData: LiveData<List<ShowEntity>> = _getShowCompleteListLiveData

    private val _getShowByIdLiveData: MutableLiveData<ShowEntity> = MutableLiveData()
    val getShowByIdLiveData: LiveData<ShowEntity> = _getShowByIdLiveData

    private val _getSeasonListByShowIdLiveData: MutableLiveData<List<SeasonEntity>> = MutableLiveData()
    val getSeasonListByShowIdLivedata: LiveData<List<SeasonEntity>> = _getSeasonListByShowIdLiveData

    private val _getEpisodeListBySeasonIdLiveData: MutableLiveData<List<EpisodeEntity>> = MutableLiveData()
    val getEpisodeListBySeasonIdLiveData: LiveData<List<EpisodeEntity>> = _getEpisodeListBySeasonIdLiveData

    private val _getEpisodeByIdLiveData: MutableLiveData<EpisodeEntity> = MutableLiveData()
    val getEpisodeByIdLiveData: LiveData<EpisodeEntity> = _getEpisodeByIdLiveData

    private val _searchShowByQueryLiveData: MutableLiveData<List<SearchResponseEntity>> = MutableLiveData()
    val searchShowByQueryLiveData: LiveData<List<SearchResponseEntity>> = _searchShowByQueryLiveData

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

    suspend fun getSeasonListByShowId(showId: String) {
        viewModelScope.launch {
            _getSeasonListByShowIdLiveData.value = getSeasonListByShowIdUseCase.execute(showId)
        }
    }

    suspend fun getEpisodeListBySeasonId(seasonId: String) {
        viewModelScope.launch {
            _getEpisodeListBySeasonIdLiveData.value = getEpisodeListBySeasonIdUseCase.execute(seasonId)
        }
    }

    suspend fun getEpisodeById(episodeId: String) {
        viewModelScope.launch {
            _getEpisodeByIdLiveData.value = getEpisodeByIdUseCase.execute(episodeId)
        }
    }

    suspend fun searchShowByQuery(query: String) {
        viewModelScope.launch {
            _searchShowByQueryLiveData.value = searchShowByQueryUseCase.execute(query)
        }
    }
}

