package com.route.islamic41.home.tabs.chapterDetails

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.route.islamic41.databinding.ActivityChapterDetailsBinding
import com.route.islamic41.home.AppConstants
import com.route.islamic41.model.Chapter

class ChapterDetailsActivity : AppCompatActivity() {
    lateinit var viewBinding : ActivityChapterDetailsBinding
    var chapter:Chapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityChapterDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        init()
        initRecyclerView()
    }

    lateinit var adapter :VersesAdapter
    private fun initRecyclerView() {
        adapter = VersesAdapter(versesList)
        viewBinding.content.versesRecycler.adapter = adapter
    }

    fun init(){
        setSupportActionBar(viewBinding.toolbar.toolbar);
        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        supportActionBar?.setDisplayShowHomeEnabled(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            chapter = intent.getParcelableExtra(
                AppConstants.EXTRA.EXTRA_CHAPTER,
                Chapter::class.java
            )
        }else{
            chapter = intent.getParcelableExtra(
                AppConstants.EXTRA.EXTRA_CHAPTER
            )
        }
        viewBinding.toolbar.toolbarTitle.text = chapter?.titleEn
        viewBinding.content.chapterTitleAr.text = chapter?.titleAr
        readChapterDetails(chapter!!.index)
    }

    lateinit var versesList: List<String>
    fun readChapterDetails(chapterIndex:Int){
        val content  = assets.open("quran/${chapterIndex+1}.txt").bufferedReader().use { it.readText() }
        versesList = content.split("\n")

    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}