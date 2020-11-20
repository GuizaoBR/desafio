package com.example.desafiogit.API

import androidx.lifecycle.LiveData
import com.example.desafiogit.Model.Repository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {

    companion object{
        val BASE_URL = "https://api.github.com/search/"
        private val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        fun <T> createService(serviceClass: Class<T>): T {
            return retrofit.create(serviceClass)
        }
    }



}