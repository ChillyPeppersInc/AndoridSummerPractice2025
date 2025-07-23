package com.example.summerpractice2025.istok.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.util.Patterns
import android.view.View
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class RegistrationFragment : Fragment(R.layout.fragment_registration) {

    private var viewBinding: FragmentRegistrationBinding? = null
    private var correctEmail = false;
    private var correctPassword = false;
    private var correctRepeatPassword = false;


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = FragmentRegistrationBinding.bind(view)
        initViews()
    }

    private fun initViews() {
        viewBinding?.apply {

            registrationButton.isEnabled = false
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
                if (correctPassword and correctEmail and correctRepeatPassword) {
                    registrationButton.isEnabled = true;
                } else {
                    registrationButton.isEnabled = false;
                }
            }

            passwordEt.doOnTextChanged { input, _, _, _ ->
                val safeInput = input ?: ""
                val regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}\$".toRegex()

                correctPassword = safeInput.matches(regex)
                if (!correctPassword) {
                    passwordTv.visibility = View.VISIBLE
                } else {
                    passwordTv.visibility = View.INVISIBLE
                }
                if (correctPassword and correctEmail and correctRepeatPassword) {
                    registrationButton.isEnabled = true;
                } else {
                    registrationButton.isEnabled = false;
                }
            }

            repeatPasswordEt.doOnTextChanged { input, _, _, _ ->
                val safeInput = input ?: ""

                correctRepeatPassword = safeInput.toString() == passwordEt.text.toString()
                if (!correctRepeatPassword) {
                    repeatPasswordTv.visibility = View.VISIBLE
                } else {
                    repeatPasswordTv.visibility = View.INVISIBLE
                }
                if (correctPassword and correctEmail and correctRepeatPassword) {
                    registrationButton.isEnabled = true;
                } else {
                    registrationButton.isEnabled = false;
                }
            }

            registrationButton.setOnClickListener {
                val userDao = DatabaseManager.userDao
                val email = emailEt.text.toString()
                val user = userDao.findByEmail(email)!!.value
                Log.d("DB_TEST", "Found user: ${user}")
                if (user == null) {
                    val testUser = User(
                        email = "test@example.com",
                        password = "123456"
                    )
                    lifecycleScope.launch {
                        withContext(Dispatchers.IO) {
                            DatabaseManager.userDao.insert(testUser)
                            Log.d("DB_TEST", "Записано!")
//                            findNavController()
//                                .navigate(R.id.action_registrationFragment_to_mainActivity)
//                        }
                         }
                    }
                } else {
                    registratioTv.visibility = View.VISIBLE
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }
}