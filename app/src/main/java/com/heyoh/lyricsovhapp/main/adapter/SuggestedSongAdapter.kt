package com.heyoh.lyricsovhapp.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.heyoh.lyricsovhapp.databinding.ItemSuggestedSongBinding
import com.heyoh.lyricsovhapp.extensions.diffUtil
import com.heyoh.models.SuggestedSong

class SuggestedSongAdapter(val onClicked: (suggestedSong: SuggestedSong) -> Unit) :
    RecyclerView.Adapter<SuggestedSongAdapter.ViewHolder>() {

    var list: List<SuggestedSong> by diffUtil(emptyList())

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemSuggestedSongBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class ViewHolder(private val binding: ItemSuggestedSongBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(suggestedSong: SuggestedSong) {
            with(binding) {

                artisNameTextView.text = suggestedSong.artistName
                songNameTextView.text = suggestedSong.songName

                Glide.with(itemView.context)
                    .load(suggestedSong.imageURL)
                    .centerCrop()
                    .into(songImageView)

                itemView.setOnClickListener {
                    onClicked.invoke(suggestedSong)
                }
            }
        }
    }
}