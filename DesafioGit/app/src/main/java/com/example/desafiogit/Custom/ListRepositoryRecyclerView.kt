package com.example.desafiogit.Custom

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiogit.Model.Repository
import com.example.desafiogit.R
import com.squareup.picasso.Picasso

class ListRepositoryRecyclerView(
    private var listRepo: ArrayList<Repository>,
    private val context: Context
    ): RecyclerView.Adapter<ListRepositoryRecyclerView.ViewHolder>() {

        var onItemClickListener : onItemClickListener? = null

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(context).inflate(R.layout.item_list_repo, parent, false)
            return ViewHolder(view)
        }

        override fun getItemCount(): Int {
            return listRepo.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val repo  = listRepo[position]
            holder.bind(repo, position)
        }



        inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
            var textUserName: TextView? =  itemView.findViewById(R.id.textUserName)
            var imagetUserImage: ImageView? = itemView.findViewById(R.id.imageUser)
            var textNumberStar: TextView? = itemView.findViewById(R.id.textNumberStars)
            var textNumberFork: TextView? = itemView.findViewById(R.id.textNumberForks)
            var textDescription: TextView? = itemView.findViewById(R.id.textDescRepo)
            var textNameRepo: TextView? = itemView.findViewById(R.id.textNameRepo)

            var repo : Repository? = null

            init {
                itemView.setOnClickListener { onItemClickListener!!.onItemClick(repo!!, adapterPosition) }
            }



            fun bind(repository: Repository, position: Int) {
                this.repo = repository
                textUserName!!.text = repository.user!!.login
                textDescription!!.text = repository.description
                textNameRepo!!.text = repository.name
                textNumberFork!!.text = repository.numberFork
                textNumberStar!!.text = repository.numberStars
                Picasso.with(context).load(repository.user!!.avatar_url).into(imagetUserImage!!);

            }

        }

    }