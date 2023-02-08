package com.example.ktorapicall.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.ktorapicall.databinding.PostItemBinding
import com.example.ktorapicall.model.Binance
import com.example.ktorapicall.model.Post

class PostAdapter : ListAdapter<Binance, RecyclerView.ViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Binance>() {

            override fun areItemsTheSame(oldItem: Binance, newItem: Binance): Boolean {
                return oldItem.openPrice  == newItem.openPrice
            }

            override fun areContentsTheSame(oldItem: Binance, newItem: Binance): Boolean {
                return oldItem.highPrice == newItem.highPrice || oldItem.lowPrice == newItem.lowPrice ||
                        oldItem.quoteVolume == newItem.quoteVolume
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RecyclerView.ViewHolder {
        val binding: PostItemBinding =
            PostItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder) {
            val item = getItem(position)
            holder.bind(item)
        }
    }


    inner class ViewHolder(private val itemBinding: PostItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(item: Binance) {
            itemBinding.apply {
                tvTitle.text = item.highPrice
                tvContent.text = item.lowPrice
                tvImg.load(item.quoteVolume)
            }
        }
    }
}