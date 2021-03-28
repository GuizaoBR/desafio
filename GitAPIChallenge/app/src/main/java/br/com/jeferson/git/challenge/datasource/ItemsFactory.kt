package br.com.jeferson.git.challenge.datasource

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import br.com.jeferson.git.challenge.model.Item

class ItemsFactory: DataSource.Factory<Int, Item>() {

    val itemsLiveDataSource = MutableLiveData<ItemsDataSource>()

    override fun create(): DataSource<Int, Item> {
        val itemsDataSource = ItemsDataSource()
        itemsLiveDataSource.postValue(itemsDataSource)

        return itemsDataSource
    }

}