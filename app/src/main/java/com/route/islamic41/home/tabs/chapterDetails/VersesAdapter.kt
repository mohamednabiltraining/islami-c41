package com.route.islamic41.home.tabs.chapterDetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.islamic41.databinding.ItemVerseBinding

class VersesAdapter(val verses:List<String>) :RecyclerView.Adapter<VersesAdapter.ViewHolder>(){

    class ViewHolder(val viewBinding:ItemVerseBinding) :RecyclerView.ViewHolder(
        viewBinding.root
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding = ItemVerseBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,false
        )
        return ViewHolder(viewBinding)
    }

    override fun getItemCount(): Int = verses.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.viewBinding.content.text = verses[position]
    }
}