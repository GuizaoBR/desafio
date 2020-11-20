package com.example.desafiogit.API

import com.example.desafiogit.Model.ListPull
import com.example.desafiogit.Model.ListRepository
import com.example.desafiogit.Model.User
import retrofit2.Call;
import retrofit2.http.GET
import retrofit2.http.Path


interface API {

    @GET("repositories?q=language:Java&sort=stars&page=1")
    fun getRepos(): Call<ListRepository>

    @GET("repos/{user}/{repo}/pulls")
    fun getPull(@Path("user") user:String, @Path("repo") repo: String): Call<ListPull>?



}