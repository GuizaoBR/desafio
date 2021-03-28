package br.com.jeferson.git.challenge.datasource

import androidx.paging.PageKeyedDataSource
import br.com.jeferson.git.challenge.model.Item
import br.com.jeferson.git.challenge.service.ApiService
import br.com.jeferson.git.challenge.service.ApiServiceImpl
import retrofit2.Call
import retrofit2.Callback
import br.com.jeferson.git.challenge.model.Response
class ItemsDataSource: PageKeyedDataSource<Int, Item>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Item>
    ) {
        val service = ApiServiceImpl.buildService(ApiService::class.java)
        val call = service.getRepositories(page = FIRST_PAGE)


        call.enqueue(object: Callback<Response<Item>> {
            override fun onFailure(call: Call<Response<Item>>, t: Throwable) {
            }
            override fun onResponse(
                call: Call<Response<Item>>,
                response: retrofit2.Response<Response<Item>>
            ) {
                if (response.isSuccessful) {
                    val apiResponse = response.body()!!
                    val responseItem = apiResponse.items

                    responseItem?.let {
                        callback.onResult(it, null, FIRST_PAGE + 1)
                    }
                }
            }


        })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Item>) {

        val service = ApiServiceImpl.buildService(ApiService::class.java)
        val call = service.getRepositories(page = params.key)

        call.enqueue(object: Callback<Response<Item>> {
            override fun onFailure(call: Call<Response<Item>>, t: Throwable) {

            }

            override fun onResponse(call: Call<Response<Item>>, response: retrofit2.Response<Response<Item>>) {
                if (response.isSuccessful) {
                    val apiResponse = response.body()!!
                    val responseItem = apiResponse.items
                    val key = params.key + 1

                    responseItem?.let {
                        callback.onResult(it, key)
                    }
                }
            }



        })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Item>) {
        val service = ApiServiceImpl.buildService(ApiService::class.java)
        val call = service.getRepositories(page = params.key)
        call.enqueue(object: Callback<Response<Item>>{
            override fun onFailure(call: Call<Response<Item>>, t: Throwable) {
            }

            override fun onResponse(call: Call<Response<Item>>, response: retrofit2.Response<Response<Item>>) {
                if (response.isSuccessful) {
                    val apiResponse = response.body()!!
                    val responseItem = apiResponse.items

                    val key = if (params.key > 1) params.key -1 else 0

                    responseItem?.let {
                        callback.onResult(it, key)
                    }
                }
            }



        })
    }

    companion object {
        const val FIRST_PAGE = 1
        const val TOTAL_PAGES = 10
    }

}