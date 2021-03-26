package br.com.jeferson.git.challenge.datasource

import br.com.jeferson.git.challenge.data.GitRepository
import br.com.jeferson.git.challenge.service.ApiService

class GitRepositoryImpl(private val apiService: ApiService) : GitRepository{

    override fun getRepositories() = Unit

}