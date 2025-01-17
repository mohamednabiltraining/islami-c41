package com.route.islamic41.home.tabs.sebha

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islamic41.databinding.FragmentSebhaBinding
import com.route.islamic41.home.AppConstants

class TasbehFragment : Fragment() {
    lateinit var viewBinding: FragmentSebhaBinding
    var rotationScale = 0.0f
    var zekrTurn = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        viewBinding = FragmentSebhaBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.imgSebha.setOnClickListener { sebhaClick() }
    }

    private fun sebhaClick() {
        AppConstants.counter++
        rotationScale += 3.6f
        viewBinding.tvSebhaText.text = AppConstants.zekr[zekrTurn]
        viewBinding.tvSebhaNum.text = "${AppConstants.counter}"
        viewBinding.imgSebha.rotation = rotationScale
        if (AppConstants.counter % 33 == 0) zekrTurn++
        if (AppConstants.counter == 100) resetSebha()
    }

    private fun resetSebha() {
        AppConstants.counter = 0
        rotationScale = 0.0f
        zekrTurn = 0
    }
}
