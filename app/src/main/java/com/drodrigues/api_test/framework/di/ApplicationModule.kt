package com.drodrigues.tvdome.framework.di

import com.drodrigues.tvdome.data.repository.MainRepositoryImpl
import com.drodrigues.tvdome.data.source.MainDataSource
import com.drodrigues.tvdome.domain.repository.MainRepository
import com.drodrigues.tvdome.domain.usecase.*
import com.drodrigues.tvdome.domain.usecase.GetShowByIdUseCase
import com.drodrigues.tvdome.domain.usecase.GetShowByIdUseCaseImpl
import com.drodrigues.tvdome.domain.usecase.GetShowCompleteListUseCase
import com.drodrigues.tvdome.domain.usecase.GetShowCompleteListUseCaseImpl
import com.drodrigues.tvdome.framework.AppConnector
import com.drodrigues.tvdome.framework.data.source.MainDataSourceImpl
import com.drodrigues.tvdome.presentation.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

internal val applicationModule: Module = module {

    factory {
        AppConnector().getRetrofit()
    }

    factory<MainDataSource> {
        MainDataSourceImpl(
            retrofit = get(),
        )
    }

    factory<MainRepository> {
        MainRepositoryImpl(
            mainDataSource = get(),
        )
    }

    factory<GetShowCompleteListUseCase> {
        GetShowCompleteListUseCaseImpl(
            mainRepository = get(),
        )
    }

    factory<GetShowByIdUseCase> {
        GetShowByIdUseCaseImpl(
            mainRepository = get()
        )
    }

    factory<GetSeasonListByShowIdUseCase> {
        GetSeasonListByShowIdUseCaseImpl(
            mainRepository = get()
        )
    }

    factory<GetEpisodeListBySeasonIdUseCase> {
        GetEpisodeListBySeasonIdUseCaseImpl(
            mainRepository = get()
        )
    }

    factory<GetEpisodeByIdUseCase> {
        GetEpisodeByIdUseCaseImpl(
            mainRepository = get()
        )
    }

    factory<SearchShowByQueryUseCase> {
        SearchShowByQueryUseCaseImpl(
            mainRepository = get()
        )
    }

    viewModel {
        MainViewModel(
            getShowCompleteListUseCase = get(),
            getShowByIdUseCase = get(),
            getSeasonListByShowIdUseCase = get(),
            getEpisodeListBySeasonIdUseCase = get(),
            getEpisodeByIdUseCase = get(),
            searchShowByQueryUseCase = get()
        )
    }

}
