package br.com.jeferson.git.challenge.viewmodel

import android.app.Application
import android.content.Intent
import android.net.Uri
import androidx.lifecycle.MutableLiveData
import br.com.jeferson.git.challenge.data.GitRepository
import br.com.jeferson.git.challenge.model.PRItem
import br.com.jeferson.git.challenge.service.ApiService
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.impl.annotations.SpyK
import io.mockk.verify
import org.hamcrest.CoreMatchers.any
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class ListPRViewModelTest {

    @RelaxedMockK
    lateinit var prItem: PRItem

    @RelaxedMockK
    lateinit var api: GitRepository

    @RelaxedMockK
    lateinit var app: Application


    private lateinit var viewModel: ListPRViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        viewModel = ListPRViewModel(api, app)
        every { app.startActivity(any()) } returns Unit
    }

    @After
    fun tearDown() {
    }


    @Test
    fun openWebSite_WithNulls() {
        every { prItem.htmlPage } returns null
        viewModel.openWebSite(prItem)
        verify(exactly = 0) { app.startActivity(any()) }
    }

    @Test
    fun openWebSite_WithSite() {
        every { prItem.htmlPage } returns "https://github.com/CyC2018/CS-Notes/pull/1066"
        viewModel.openWebSite(prItem)
        verify(exactly = 1) { app.startActivity(any()) }
    }
}