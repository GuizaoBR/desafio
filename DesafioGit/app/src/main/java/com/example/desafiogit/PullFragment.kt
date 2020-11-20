package com.example.desafiogit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiogit.Custom.CustomViewModelFactory
import com.example.desafiogit.Custom.ListPullRecyclerView
import com.example.desafiogit.Model.Pull

class PullFragment : Fragment() {
    private var adapter: ListPullRecyclerView? = null
    private var finalListPull: ArrayList<Pull>? = ArrayList()
    companion object {
        fun newInstance() = PullFragment()
    }

    private lateinit var viewModel: PullViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.pull_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val mBundle: Bundle = arguments!!
        val user = mBundle.getString("user")
        val repo = mBundle.getString("repo")

        viewModel = ViewModelProvider(this, CustomViewModelFactory(user!!,repo!!)).get(PullViewModel::class.java)

        viewModel.init()

        viewModel.getPull().observe(this) { pull ->
            val listPullAPI: List<Pull>? = pull!!.listPull
            if (listPullAPI != null) {
                finalListPull!!.addAll(listPullAPI)
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
            adapter = ListPullRecyclerView(finalListPull!!, context!!)
            val recycler = view!!.findViewById<RecyclerView>(R.id.recyclerListRepo)
            recycler.adapter = adapter
        } else {
            adapter!!.notifyDataSetChanged()
        }


//        adapter!!.onItemClickListener = object : onItemClickListener {
//            override fun onItemClick(item: Any, posicao: Int) {
//                val fragmentB = PullFragment()
//                val bundle = Bundle()
//                val fragmentTransaction: FragmentTransaction = fragmentManager!!.beginTransaction()
//                val repo = item as Repository
//                bundle.putString("user", repo.user!!.login)
//                bundle.putString("repo", repo.name)
//                fragmentB.arguments = bundle
//                fragmentTransaction.replace(this@MainFragment.id, fragmentB, "repoPull")
//                fragmentTransaction.commit()
//
//            }


        }
    }

