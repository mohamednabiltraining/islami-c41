package com.route.islamic41.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.route.islamic41.R
import com.route.islamic41.databinding.ActivityMainBinding
import com.route.islamic41.home.tabs.hadeth.HadethFragment
import com.route.islamic41.home.tabs.RadioFragment
import com.route.islamic41.home.tabs.sebha.TasbehFragment
import com.route.islamic41.home.tabs.quran.QuranFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavView.setOnItemSelectedListener { menuItem ->
            var fragment: Fragment =
                when (menuItem.itemId) {
                    R.id.navigation_quran -> {
                        QuranFragment()
                    }

                    R.id.navigation_hadeth -> {
                        HadethFragment()
                    }

                    R.id.navigation_sebha -> {
                        TasbehFragment()
                    }

                    R.id.navigation_radio -> {
                        RadioFragment()
                    }

                    else -> {
                        RadioFragment()
                    }
                }
            showFragment(fragment)
            return@setOnItemSelectedListener true
        }
        binding.bottomNavView.selectedItemId = R.id.navigation_quran
    }

    fun showFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
