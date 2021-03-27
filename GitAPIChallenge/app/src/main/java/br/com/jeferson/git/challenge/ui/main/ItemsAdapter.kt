package br.com.jeferson.git.challenge.ui.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import br.com.jeferson.git.challenge.R
import br.com.jeferson.git.challenge.model.Item
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_list.view.*
import java.lang.ref.WeakReference


class ItemsAdapter(private val onListClickListener: WeakReference<OnListClickListener>)
    : PagedListAdapter<Item, ItemsAdapter.ViewHolder>(ITEMS_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val items = getItem(position)
        items?.let {
            holder.bind(it)
            holder.itemView.setOnClickListener {
                getItem(position)?.let { item ->
                    onListClickListener.get()?.onSelectItem(item) }
            }

        }

    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val repoName = view.tv_repo_name
        private val repoDescr = view.tv_description
        private val forksCount = view.tv_forks_count
        private val starsCount = view.tv_stars_count
        private val login = view.tv_login
        private val avatar = view.image_avatar

        fun bind(item: Item) {
            repoName.text = item.name
            repoDescr.text = item.description
            forksCount.text = item.forksCount.toString()
            starsCount.text = item.stargazersCount.toString()
            login.text = item.owner.login

            Picasso.get()
                .load(item.owner.avatarUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .into(avatar)
        }
    }

    companion object {

        private val ITEMS_COMPARATOR = object: DiffUtil.ItemCallback<Item>() {
            override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean =
                oldItem.id == newItem.id

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean =
                newItem == oldItem

        }
    }

}