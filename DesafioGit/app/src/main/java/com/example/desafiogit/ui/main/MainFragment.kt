package com.example.desafiogit.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiogit.Custom.ListRepositoryRecyclerView
import com.example.desafiogit.Custom.onItemClickListener
import com.example.desafiogit.Model.Repository
import com.example.desafiogit.PullFragment
import com.example.desafiogit.R


class MainFragment : Fragment() {
    private var adapter: ListRepositoryRecyclerView? = null
    private var finalListRepo: ArrayList<Repository>? = ArrayList()

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)

    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.init()

        viewModel.getListRepo().observe(this) { repo ->
            val listRepoAPI: List<Repository>? = repo!!.listRepository
            if (listRepoAPI != null) {
                finalListRepo!!.addAll(listRepoAPI)
                setAdapter()
                setLayoutManager()
                adapter!!.notifyDataSetChanged()

            }
        }


    }

    private fun setLayoutManager() {
        val layoutManager = LinearLayoutManager(context)
        val recycler = view!!.findViewById<RecyclerView>(R.id.recyclerListRepo)
        recycler.layoutManager = layoutManager

    }

    private fun setAdapter() {
        if (adapter == null) {
            adapter = ListRepositoryRecyclerView(finalListRepo!!, context!!)
            val recycler = view!!.findViewById<RecyclerView>(R.id.recyclerListRepo)
            recycler.adapter = adapter
        } else {
            adapter!!.notifyDataSetChanged()
        }


        adapter!!.onItemClickListener = object : onItemClickListener {
            override fun onItemClick(item: Any, posicao: Int) {
                val fragmentB = PullFragment()
                val bundle = Bundle()
                val fragmentTransaction: FragmentTransaction = fragmentManager!!.beginTransaction()
                val repo = item as Repository
                bundle.putString("user", repo.user!!.login)
                bundle.putString("repo", repo.name)
                fragmentB.arguments = bundle
                fragmentTransaction.replace(this@MainFragment.id, fragmentB, "repoPull")
                fragmentTransaction.commit()

            }


        }
    }
}




