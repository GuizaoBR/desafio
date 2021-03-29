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
import androidx.navigation.fragment.navArgs
import br.com.jeferson.git.challenge.R
import br.com.jeferson.git.challenge.model.Item
import br.com.jeferson.git.challenge.model.PRItem
import br.com.jeferson.git.challenge.viewmodel.ListPRViewModel
import br.com.jeferson.git.challenge.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.fragment_list_repo.*
import kotlinx.android.synthetic.main.item_list.*
import java.lang.ref.WeakReference
import org.koin.android.viewmodel.ext.android.viewModel

class ListPRFragment : Fragment(), OnPRClickListener {

    companion object {
        fun newInstance() = ListPRFragment()
    }

     private val viewModel: ListPRViewModel by viewModel()

    private val adapter = PRAdapter(WeakReference(this))

    private val args by navArgs<ListPRFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initList()
        loadList()

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_list_pr, container, false)
    }

    private fun initList() {
        recycler_view.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    private fun loadList() {
        viewModel.prListLiveData.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
        viewModel.getPrList(args.name,args.login)
    }



    override fun onSelectItem(item: PRItem) {
        viewModel.openWebSite(item)
    }

}