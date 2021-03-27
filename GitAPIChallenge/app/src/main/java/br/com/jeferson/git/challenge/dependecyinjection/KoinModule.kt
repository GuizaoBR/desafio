package br.com.jeferson.git.challenge.dependecyinjection

import br.com.jeferson.git.challenge.data.GitRepository
import br.com.jeferson.git.challenge.datasource.GitRepositoryImpl
import br.com.jeferson.git.challenge.service.ApiService
import br.com.jeferson.git.challenge.service.ApiServiceImpl
import org.koin.dsl.module

var koinModules = module {
    single { ApiServiceImpl.buildService(ApiService::class.java) }
    single{ GitRepositoryImpl(get()) as GitRepository }
}