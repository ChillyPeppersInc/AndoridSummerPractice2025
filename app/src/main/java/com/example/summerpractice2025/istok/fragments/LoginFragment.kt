package com.example.summerpractice2025.istok.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.util.Patterns
import android.view.View
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.liveData
import androidx.navigation.fragment.findNavController
import androidx.paging.LOG_TAG
import com.example.summerpractice2025.istok.databinding.FragmentRegistrationBinding
import com.example.summerpractice2025.istok.DateBase.DatabaseManager
import com.example.summerpractice2025.istok.R
import com.example.summerpractice2025.istok.DateBase.User
import com.example.summerpractice2025.istok.DateBase.AppDatabase
import com.example.summerpractice2025.istok.DateBase.UserDao
import com.example.summerpractice2025.istok.databinding.FragmentLoginBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class LoginFragment : Fragment(R.layout.fragment_login) {

    private var viewBinding: FragmentLoginBinding? = null
    private var correctEmail = false;
    private var correctPassword = false;

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = FragmentLoginBinding.bind(view)
        initViews()
    }

    private fun initViews() {
        viewBinding?.apply {

            loginButton.isEnabled = false
            emailEt.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(p0: Editable?) {}

                override fun onTextChanged(input: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            })

            emailEt.doOnTextChanged { input, _, _, _ ->
                val text = input ?: ""
                correctEmail = Patterns.EMAIL_ADDRESS.matcher(text).matches() and text.endsWith("@kpfu.ru")

                if (!correctEmail) {
                    emailTv.visibility = View.VISIBLE
                } else {
                    emailTv.visibility = View.INVISIBLE
                }
                if (correctEmail) {
                    loginButton.isEnabled = true;
                } else {
                    loginButton.isEnabled = false;
                }
            }

            passwordEt.doOnTextChanged { input, _, _, _ ->
                val safeInput = input ?: ""
                val regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}\$".toRegex()

                correctPassword = safeInput.matches(regex)
            }

            loginButton.setOnClickListener {
                val userDao = DatabaseManager.userDao
                val email = emailEt.text.toString()
                lifecycleScope.launch {
                    val user = userDao.findByEmail(email)
                    if (user?.password == passwordEt.text.toString()) {
                        findNavController().navigate(R.id.action_loginFragment_to_mainActivity)
                    } else {
                        loginTv.visibility = View.VISIBLE
                    }
                }
            }

            goToRegistrationBtn.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_registrationFragment)
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }
}