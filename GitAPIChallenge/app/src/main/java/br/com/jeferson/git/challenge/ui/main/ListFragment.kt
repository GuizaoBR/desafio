package br.com.jeferson.git.challenge.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import br.com.jeferson.git.challenge.R
import br.com.jeferson.git.challenge.model.Item
import br.com.jeferson.git.challenge.viewmodel.ListViewModel
import java.lang.ref.WeakReference

class ListFragment : Fragment(), OnListClickListener {

    companion object {
        fun newInstance() = ListFragment()
    }

     val viewModel: ListViewModel by viewModels()

    private val adapter = ItemsAdapter(WeakReference(this))

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_list_repo, container, false)
    }


    override fun onSelectItem(item: Item) {
        TODO("Not yet implemented")
    }

}