package ru.itis.istock

import AppDatabase
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import com.bumptech.glide.Glide
import kotlinx.coroutines.launch
import ru.itis.istock.databinding.ActivityMainBinding
import ru.itis.istock.R


class MainActivity : AppCompatActivity() {

    private var counter = 0

    private var viewBinding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding?.root)

        initViews()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewBinding = null
    }

    private fun initViews() {

    }
}