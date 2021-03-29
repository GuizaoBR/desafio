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
    val liveDataListWithItems: LiveData<Boolean>

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
                liveDataListWithItems.value = false
                super.onZeroItemsLoaded()
            }

            override fun onItemAtFrontLoaded(itemAtFront: Item) {
                liveDataListWithItems.value = true
                super.onItemAtFrontLoaded(itemAtFront)
            }

            override fun onItemAtEndLoaded(itemAtEnd: Item) {
                liveDataListWithItems.value = true
                super.onItemAtFrontLoaded(itemAtEnd)
            }
        }).build()

    }
}