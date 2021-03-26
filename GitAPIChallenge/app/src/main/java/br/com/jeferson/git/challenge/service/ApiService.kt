package br.com.jeferson.git.challenge.service

import br.com.jeferson.git.challenge.model.Item
import br.com.jeferson.git.challenge.model.Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("search/repositories")
    fun getRepositories(
        @Query("q") q: String = "language:Java",
        @Query("sort") sort: String = "stars",
        @Query("page") page: Int
    ): Call<Response<Item>>
}