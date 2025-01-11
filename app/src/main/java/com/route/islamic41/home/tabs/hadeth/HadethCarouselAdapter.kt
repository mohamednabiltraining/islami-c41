package com.route.islamic41.home.tabs.hadeth

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.islamic41.databinding.ItemHadethBinding
import com.route.islamic41.model.Hadeth

class HadethCarouselAdapter (val hadethList:List<Hadeth>):RecyclerView.Adapter<HadethCarouselAdapter.ViewHolder>(){

    class ViewHolder(val viewBinding: ItemHadethBinding) : RecyclerView.ViewHolder(viewBinding.root) {

        fun bind(hadeth: Hadeth){
            viewBinding.title.text = hadeth.title
            viewBinding.content.text = hadeth.content

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = ItemHadethBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,false
        )
        return ViewHolder(itemBinding)
    }

    override fun getItemCount(): Int  = hadethList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hadeth = hadethList[position]
        holder.bind(hadeth)
    }
}