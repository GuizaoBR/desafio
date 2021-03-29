package br.com.jeferson.git.challenge.datasource

import br.com.jeferson.git.challenge.data.GitRepository
import br.com.jeferson.git.challenge.model.PRItem
import br.com.jeferson.git.challenge.service.ApiService
import retrofit2.Call
import retrofit2.Callback

class GitRepositoryImpl(private val apiService: ApiService) : GitRepository{

    override fun getRepositories() = Unit

    override fun getPRList(userName: String, repository: String, onResponse: (List<PRItem>?) ->Unit) {
        apiService.getPRList(userName, repository).enqueue(object: Callback<List<PRItem>> {
            override fun onFailure(call: Call<List<PRItem>>, t: Throwable) {
                onResponse.invoke(null)
            }

            override fun onResponse(
                call: Call<List<PRItem>>,
                response: retrofit2.Response<List<PRItem>>
            ) {
                response.body()?.let {
                    onResponse.invoke(it)
                }
            }

        })
    }
}