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

        viewBinding.tvSebhaNum.text = "${AppConstants.counter}"
        viewBinding.imgSebha.setOnClickListener { sebhaClick() }
    }

    private fun sebhaClick() {
        AppConstants.counter++
        viewBinding.tvSebhaNum.text = "${AppConstants.counter}"
    }
}
