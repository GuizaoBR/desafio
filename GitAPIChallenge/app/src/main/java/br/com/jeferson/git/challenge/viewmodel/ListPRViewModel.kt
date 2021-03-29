package br.com.jeferson.git.challenge.viewmodel

import android.app.Application
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.net.Uri
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import br.com.jeferson.git.challenge.data.GitRepository
import br.com.jeferson.git.challenge.model.PRItem


class ListPRViewModel(private val gitRepo: GitRepository,private val app: Application) : AndroidViewModel(
    app
) {

     val prListLiveData = MutableLiveData<List<PRItem>>()


    fun getPrList(userName: String, repository: String) {
        gitRepo.getPRList(userName, repository) {
            prListLiveData.postValue(it)
        }
    }

    fun openWebSite(prItem: PRItem) {
        prItem.htmlPage?.let {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(it))
            browserIntent.flags = FLAG_ACTIVITY_NEW_TASK
            app.startActivity(browserIntent)
        }
    }

}