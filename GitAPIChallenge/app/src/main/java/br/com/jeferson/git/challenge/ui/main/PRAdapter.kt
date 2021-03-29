package br.com.jeferson.git.challenge.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.jeferson.git.challenge.R
import br.com.jeferson.git.challenge.model.PRItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_list_pr.view.*
import java.lang.ref.WeakReference

class PRAdapter(private val onListClickListener: WeakReference<OnPRClickListener>) : ListAdapter<PRItem, PRAdapter.ViewHolder>(PULLS_COMPARATOR) {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val prName = view.tv_pr_name
        private val prDescription = view.tv_pr_descr
        private val login = view.tv_pr_login
        private val avatar = view.iv_avatar

        fun bind(prItem: PRItem){
            prName.text = prItem.title
            prDescription.text = prItem.body
            login.text = prItem.user.login


            Picasso.get()
                .load(prItem.user.avatarUrl)
                .into(avatar)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_pr, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val prItem = getItem(position)
        prItem?.let {
            holder.bind(it)
            holder.itemView.setOnClickListener {
                getItem(position)?.let { item ->
                    onListClickListener.get()?.onSelectItem(item) }
            }
        }
    }

    companion object {
        private val PULLS_COMPARATOR = object: DiffUtil.ItemCallback<PRItem>() {
            override fun areItemsTheSame(oldItem: PRItem, newItem: PRItem): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: PRItem, newItem: PRItem): Boolean =
                newItem == oldItem
        }
    }

}

