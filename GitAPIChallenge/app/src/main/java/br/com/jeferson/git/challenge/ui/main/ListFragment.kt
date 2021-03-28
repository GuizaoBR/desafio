package br.com.jeferson.git.challenge.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import br.com.jeferson.git.challenge.R
import br.com.jeferson.git.challenge.model.Item
import br.com.jeferson.git.challenge.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.fragment_list_repo.*
import kotlinx.android.synthetic.main.item_list.*
import java.lang.ref.WeakReference

class ListFragment : Fragment(), OnListClickListener {

    companion object {
        fun newInstance() = ListFragment()
    }

     val viewModel: ListViewModel by viewModels()

    private val adapter = ItemsAdapter(WeakReference(this))

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initList()
        loadList()

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_list_repo, container, false)
    }
    private fun initList() {
        recycler_view.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    private fun loadList() {
        viewModel.itemsPagedList.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
    }



    override fun onSelectItem(item: Item) {
        val login = tv_login.text.toString()
        val name = tv_repo_name.text.toString()
        TODO("open new fragment")
    }

}