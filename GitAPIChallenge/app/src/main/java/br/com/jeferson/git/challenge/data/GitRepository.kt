package br.com.jeferson.git.challenge.data

import br.com.jeferson.git.challenge.model.PRItem

interface GitRepository {

    fun getRepositories()
    fun getPRList(userName: String, repository: String, onResponse: (List<PRItem>?) -> Unit)
}