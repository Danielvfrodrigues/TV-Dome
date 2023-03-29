package com.drodrigues.api_test.framework.di

import com.drodrigues.api_test.data.repository.MainRepositoryImpl
import com.drodrigues.api_test.data.source.MainDataSource
import com.drodrigues.api_test.domain.repository.MainRepository
import com.drodrigues.api_test.domain.usecase.*
import com.drodrigues.api_test.domain.usecase.GetShowByIdUseCase
import com.drodrigues.api_test.domain.usecase.GetShowByIdUseCaseImpl
import com.drodrigues.api_test.domain.usecase.GetShowCompleteListUseCase
import com.drodrigues.api_test.domain.usecase.GetShowCompleteListUseCaseImpl
import com.drodrigues.api_test.framework.AppConnector
import com.drodrigues.api_test.framework.data.source.MainDataSourceImpl
import com.drodrigues.api_test.presentation.viewmodel.MainViewModel
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
