package com.example.desafiogit.Custom

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiogit.Model.Pull
import com.example.desafiogit.Model.Repository
import com.example.desafiogit.R
import com.squareup.picasso.Picasso

class ListPullRecyclerView(
    private var listPull: ArrayList<Pull>,
    private val context: Context
    ): RecyclerView.Adapter<ListPullRecyclerView.ViewHolder>() {

        var onItemClickListener : AdapterView.OnItemClickListener? = null

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(context).inflate(R.layout.item_list_pull, parent, false)
            return ViewHolder(view)
        }

        override fun getItemCount(): Int {
            return listPull.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val pull  = listPull[position]
            holder.bind(pull, position)
        }




        inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
            var textUserName: TextView? =  itemView.findViewById(R.id.textUserName)
            var imagetUserImage: ImageView? = itemView.findViewById(R.id.imageUser)
            var textDescription: TextView? = itemView.findViewById(R.id.textDescPull)
            var textNameRepo: TextView? = itemView.findViewById(R.id.textNamePull)
//            private var pull: Pull? = null
//
//            init {
//                itemView.setOnClickListener { onItemClickListener!!.onItemClick(pull!!, adapterPosition) }
//            }



            fun bind(pull: Pull, position: Int) {
                textUserName!!.text = pull.user!!.login
                textDescription!!.text = pull.description
                textNameRepo!!.text = pull.name
                Picasso.with(context).load(pull.user!!.avatar_url).into(imagetUserImage!!);

            }

        }

    }