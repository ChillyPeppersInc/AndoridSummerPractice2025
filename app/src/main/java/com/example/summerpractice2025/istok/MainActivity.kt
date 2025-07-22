package com.example.summerpractice2025.istok

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.summerpractice2025.istok.databinding.ActivityMainBinding
import com.example.summerpractice2025.istok.fragments.FoodFragment
import com.example.summerpractice2025.istok.fragments.ResourcesFragment
import com.example.summerpractice2025.istok.fragments.TeachersFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Устанавливаем первый фрагмент при запуске
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, TeachersFragment())
                .commit()
        }

        binding.bottomNav.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_teachers -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, TeachersFragment())
                        .commit()
                    true
                }
                R.id.nav_food -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, FoodFragment())
                        .commit()
                    true
                }
                R.id.nav_resources -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, ResourcesFragment())
                        .commit()
                    true
                }
                else -> false
            }
        }
    }
    companion object {
        fun newIntent(context: Context) = Intent(context, MainActivity::class.java)
    }
}