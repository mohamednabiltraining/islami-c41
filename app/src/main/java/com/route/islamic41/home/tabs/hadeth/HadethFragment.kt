package com.route.islamic41.home.tabs.hadeth

import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.carousel.CarouselLayoutManager
import com.google.android.material.carousel.CarouselSnapHelper
import com.google.android.material.carousel.FullScreenCarouselStrategy
import com.route.islamic41.databinding.FragmentHadethBinding
import com.route.islamic41.model.Hadeth

class HadethFragment : Fragment() {
    lateinit var viewBinding: FragmentHadethBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        viewBinding = FragmentHadethBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    val hadethList:MutableList<Hadeth> = mutableListOf()
    lateinit var adapter :HadethCarouselAdapter
    lateinit var layoutManager : CarouselLayoutManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        readAhadethFile()
        initHadethRecycler()

    }

    private fun initHadethRecycler() {
        adapter = HadethCarouselAdapter(hadethList)
        layoutManager = CarouselLayoutManager(
            FullScreenCarouselStrategy(),
            CarouselLayoutManager.HORIZONTAL,
        )
        layoutManager.carouselAlignment = CarouselLayoutManager.ALIGNMENT_CENTER
        viewBinding.hadethRecyclerView.adapter = adapter
        viewBinding.hadethRecyclerView.layoutManager = layoutManager

        val snapHelper = CarouselSnapHelper()
        snapHelper.attachToRecyclerView(viewBinding.hadethRecyclerView)

        viewBinding.hadethRecyclerView.addItemDecoration(
            MarginItemDecoration(getMarginInPx())
        )

    }

    fun readAhadethFile(){
        val fileContent = activity?.assets?.open("hadeth/ahadeth.txt")
            ?.bufferedReader().use { it?.readText() }
        if(fileContent==null)return
        val hadethLinesList = fileContent.trim()
            .split("#")
        hadethLinesList.forEach { singleHadeth->
            val lines = singleHadeth.trim()
                .split("\n")
            val title = lines[0]
            val content = lines.takeLast(lines.size-1).joinToString("\n")
            val hadeth = Hadeth(title,content)
            hadethList.add(hadeth)
        }
    }

    fun getMarginInPx():Int{
        val r = resources
        val px = Math.round(
            TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 24f, r.displayMetrics
            )
        )
        return px
    }
}
