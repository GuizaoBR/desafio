package com.example.desafiogit.API

import androidx.lifecycle.MutableLiveData
import com.example.desafiogit.Model.ListPull
import com.example.desafiogit.Model.ListRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoryData {



    companion object{
        private var api: API? = null

        init {
            api = RetrofitService.createService (API::class.java)
        }

        fun getRepo(): MutableLiveData<ListRepository?>? {
            val repoData: MutableLiveData<ListRepository?> = MutableLiveData()

            val getRepo = api!!.getRepos()
            getRepo.enqueue(object : Callback<ListRepository?> {

                override fun onResponse(call: Call<ListRepository?>,
                                        response: Response<ListRepository?>) {
                    if (response.isSuccessful) {
                        repoData.value = response.body()
                    }
                }

                override fun onFailure(call: Call<ListRepository?>, t: Throwable) {
                    t.printStackTrace()
                    repoData.value = null
                }

            })
            return repoData
        }


        fun getPull(user: String, repo: String): MutableLiveData<ListPull?>? {
            val pullData: MutableLiveData<ListPull?> = MutableLiveData()

            val getPull = api!!.getPull(user, repo)
            getPull!!.enqueue(object : Callback<ListPull?> {
                override fun onResponse(call: Call<ListPull?>,
                                        response: Response<ListPull?>) {
                    if (response.isSuccessful) {
                        pullData.value = response.body()
                    }
                }

                override fun onFailure(call: Call<ListPull?>, t: Throwable) {
                    t.printStackTrace()
                    pullData.value = null
                }
            })
            return pullData
        }
    }





}