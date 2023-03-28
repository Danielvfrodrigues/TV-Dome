package com.drodrigues.api_test.framework.di

import com.drodrigues.api_test.BaseApplication
import com.drodrigues.api_test.data.repository.ShowRepositoryImpl
import com.drodrigues.api_test.data.source.ShowDataSource
import com.drodrigues.api_test.domain.repository.ShowRepository
import com.drodrigues.api_test.domain.usecase.GetShowByIdUseCase
import com.drodrigues.api_test.domain.usecase.GetShowByIdUseCaseImpl
import com.drodrigues.api_test.domain.usecase.GetShowCompleteListUseCase
import com.drodrigues.api_test.domain.usecase.GetShowCompleteListUseCaseImpl
import com.drodrigues.api_test.framework.AppConnector
import com.drodrigues.api_test.framework.data.source.ShowDataSourceImpl
import com.drodrigues.api_test.presentation.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

internal val applicationModule: Module = module {

    single {
        BaseApplication().getLifecycleOwner()
    }

    factory {
        AppConnector().getRetrofit()
    }

    factory<ShowDataSource> {
        ShowDataSourceImpl(
            retrofit = get(),
        )
    }

    factory<ShowRepository> {
        ShowRepositoryImpl(
            showDataSource = get(),
        )
    }

    factory<GetShowCompleteListUseCase> {
        GetShowCompleteListUseCaseImpl(
            showRepository = get(),
        )
    }

    factory<GetShowByIdUseCase> {
        GetShowByIdUseCaseImpl(
            showRepository = get()
        )
    }

    viewModel {
        MainViewModel(
            getShowCompleteListUseCase = get(),
            getShowByIdUseCase = get()
        )
    }

}
