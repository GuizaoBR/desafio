package br.com.jeferson.git.challenge.dependecyinjection

import android.app.Application
import br.com.jeferson.git.challenge.data.GitRepository
import br.com.jeferson.git.challenge.datasource.GitRepositoryImpl
import br.com.jeferson.git.challenge.service.ApiService
import br.com.jeferson.git.challenge.service.ApiServiceImpl
import br.com.jeferson.git.challenge.viewmodel.ListPRViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

var koinModules = module {
    single { ApiServiceImpl.buildService(ApiService::class.java) }
    single{ GitRepositoryImpl(get()) as GitRepository }

    viewModel { ListPRViewModel(get(), androidContext() as Application) }
}