package com.example.summerpractice2025.istok

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.summerpractice2025.istok.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.btnLogin.setOnClickListener {
            handleLogin()
        }

        binding.btnRegister.setOnClickListener {
            handleRegistration()
        }
    }

    private fun handleLogin() {
        val username = binding.etUsername.text.toString()
        val password = binding.etPassword.text.toString()

        if (username.isNotEmpty() && password.isNotEmpty()) {
            // Заглушка - просто переходим в основное приложение
            startActivity(MainActivity.newIntent(this))
            finish()
        } else {
            showToast("Введите имя пользователя и пароль")
        }
    }

    private fun handleRegistration() {
        val username = binding.etUsername.text.toString()
        val password = binding.etPassword.text.toString()

        if (username.isNotEmpty() && password.isNotEmpty()) {
            showToast("Регистрация успешна (заглушка)")
            startActivity(MainActivity.newIntent(this))
            finish()
        } else {
            showToast("Введите имя пользователя и пароль")
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}