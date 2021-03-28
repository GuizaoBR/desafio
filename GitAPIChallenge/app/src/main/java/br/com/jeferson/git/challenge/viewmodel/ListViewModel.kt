package br.com.jeferson.git.challenge.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import androidx.paging.PagedList.BoundaryCallback
import br.com.jeferson.git.challenge.datasource.ItemsDataSource
import br.com.jeferson.git.challenge.datasource.ItemsFactory
import br.com.jeferson.git.challenge.model.Item


class ListViewModel : ViewModel() {
    val itemsPagedList: LiveData<PagedList<Item>>

    private val liveDataSource: LiveData<ItemsDataSource>
    private val liveDataListWithItems: LiveData<Boolean>

    private val TAG = ListViewModel::class.simpleName
    init {
        val factory = ItemsFactory()

        liveDataSource = factory.itemsLiveDataSource
        liveDataListWithItems = MutableLiveData<Boolean>()

        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(ItemsDataSource.TOTAL_PAGES)
            .build()

        itemsPagedList = LivePagedListBuilder(factory, config).setBoundaryCallback(object : BoundaryCallback<Item>() {
            override fun onZeroItemsLoaded() {
                Log.d(TAG, "onZeroItemsLoaded: ")
                liveDataListWithItems.setValue(false)
            }

            override fun onItemAtFrontLoaded(itemAtFront: Item) {
                Log.d(TAG, "onItemAtFrontLoaded: ")
                liveDataListWithItems.setValue(true)
            }

            override fun onItemAtEndLoaded(itemAtEnd: Item) {
                Log.d(TAG, "onItemAtEndLoaded: ")
                liveDataListWithItems.setValue(true)
            }
        }).build()

    }
}