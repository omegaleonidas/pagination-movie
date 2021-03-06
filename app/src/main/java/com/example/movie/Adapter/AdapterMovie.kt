package com.example.movie.Adapter

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.movie.Model.ResultsItem
import com.example.movie.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_view.view.*

class AdapterMovie :
    PagedListAdapter<ResultsItem, RecyclerView.ViewHolder>(ResultsItem().DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return movieHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (holder is movieHolder) {
            holder.bindTo(getItem(position))
        }
    }

    class movieHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindTo(item: ResultsItem?) {

            itemView.title.text = item?.name
            itemView.descripsi.text = item?.description
//                     Picasso.get()
//                .load("https://image.tmdb.org/t/p/w500${item?.posterPath}")
//                .into(itemView.image)
//
//
//            Glide.with(itemView.context).load("https://image.tmdb.org/t/p/w500${item?.posterPath}")
//                .centerCrop()
//                .listener(new RequestListener<Drawable>()
//
//                .placeholder(R.drawable.prooses)
//                .into(itemView.image)

            Glide.with(itemView.context)
                .load("https://image.tmdb.org/t/p/w500${item?.posterPath}")

                .listener(object : RequestListener<Drawable?> {
                    override fun onLoadFailed(
                        @Nullable e: GlideException?,
                        model: Any,
                        target: Target<Drawable?>,
                        isFirstResource: Boolean
                    ): Boolean {
                        itemView.pbLoading.setVisibility(View.GONE)

                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any,
                        target: Target<Drawable?>,
                        dataSource: DataSource,
                        isFirstResource: Boolean
                    ): Boolean {
                        itemView.pbLoading.setVisibility(View.GONE)
                        return false
                    }
                })
                .into(itemView.image)



        }

    }

}

