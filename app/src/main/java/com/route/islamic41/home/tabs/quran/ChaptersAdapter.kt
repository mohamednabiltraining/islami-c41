package com.route.islamic41.home.tabs.quran

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.islamic41.databinding.ItemChapterBinding
import com.route.islamic41.model.Chapter

class ChaptersAdapter(
    val chapters: List<Chapter>,
) : RecyclerView.Adapter<ChaptersAdapter.ViewHolder>() {
    class ViewHolder(
        val itemBinding: ItemChapterBinding,
    ) : RecyclerView.ViewHolder(itemBinding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ViewHolder {
        val itemBinding =
            ItemChapterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            )
        return ViewHolder(itemBinding)
    }

    override fun getItemCount(): Int = chapters.size

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int,
    ) {
        val chapter = chapters[position]

        holder.itemBinding.englishTitleTv.text = chapter.titleEn
        holder.itemBinding.arabicTitleTv.text = chapter.titleAr
        holder.itemBinding.versesNumberTv.text = chapter.versesNumber
        // holder.itemBinding.chapterIndexTv.setText(chapter.index+1)
        holder.itemBinding.chapterIndexTv.text = "${chapter.index + 1}"
    }
}
