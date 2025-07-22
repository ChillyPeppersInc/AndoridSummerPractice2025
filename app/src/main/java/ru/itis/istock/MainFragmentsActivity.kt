package ru.itis.istock

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.NavHostFragment
import ru.itis.istock.R

class MainFragmentsActivity : AppCompatActivity() {

    private val mainContainerId = R.id.main_fragment_container

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_fragments)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initNavigation()

//        supportFragmentManager.commit {
//            add(mainContainerId, MainFragment())
//        }
    }

    private fun initNavigation() {
        val navHostFragment = supportFragmentManager.findFragmentById(mainContainerId) as? NavHostFragment
        val navController = navHostFragment?.navController
    }
}