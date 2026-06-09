package com.example.arsyad_balance.Home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.arsyad_balance.data.model.NewsPost
import com.example.arsyad_balance.databinding.ItemNewsBinding

class NewsAdapter(private val listNews: List<NewsPost>) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    class NewsViewHolder(private val binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(news: NewsPost) {
            binding.apply {
                tvTitle.text = news.title ?: "Tanpa Judul"
                tvDescription.text = news.description ?: "Tanpa Deskripsi"
                
                // Ambil URL gambar dari Any? thumbnail
                val imageUrl = when (val thumb = news.thumbnail) {
                    is String -> thumb
                    is Map<*, *> -> thumb["large"] as? String ?: thumb["medium"] as? String ?: thumb["small"] as? String
                    else -> null
                }

                Glide.with(itemView.context)
                    .load(imageUrl)
                    .placeholder(android.R.drawable.ic_menu_gallery)
                    .error(android.R.drawable.ic_menu_report_image)
                    .into(ivThumbnail)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(listNews[position])
    }

    override fun getItemCount(): Int = listNews.size
}
