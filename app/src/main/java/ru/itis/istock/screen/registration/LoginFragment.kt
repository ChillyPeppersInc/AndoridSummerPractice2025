package ru.itis.istock.screen.detail

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import ru.itis.istock.DataBase.User
import ru.itis.istock.databinding.FragmentRegistrationBinding
import ru.itis.istock.R
import ru.itis.istock.databinding.FragmentLoginBinding
import ru.itis.istock.databinding.FragmentMainBinding
import ru.itis.istock.models.UserDataModel
import ru.itis.istock.utils.DatabaseManager
import ru.itis.istock.utils.Keys
import ru.itis.istock.utils.getParcelable


class LoginFragment: Fragment(R.layout.fragment_login) {

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

            emailEt.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(p0: Editable?) {}

                override fun onTextChanged(input: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            })

            emailEt.doOnTextChanged { input, _, _, _ ->
                val text = input ?: ""
                correctEmail = Patterns.EMAIL_ADDRESS.matcher(text).matches() and text.endsWith("@kpfu.ru")

                if (correctPassword and correctEmail) {
                    registrationBtn.isEnabled = true;
                } else {
                    registrationBtn.isEnabled = false;
                }
            }

            passwordEt.doOnTextChanged { input, _, _, _ ->
                val safeInput = input ?: ""
                val regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}\$".toRegex()

                correctPassword = safeInput.matches(regex)
                if (correctPassword and correctEmail) {
                    registrationBtn.isEnabled = true;
                } else {
                    registrationBtn.isEnabled = false;
                }
            }

            registrationBtn.setOnClickListener {
                val context = requireContext().applicationContext
                DatabaseManager.init(context)
                val userDao = DatabaseManager.userDao
                var email : String = emailEt.text.toString()
                val user = userDao.findByEmail(email)
                if (user != null) {
                    userDao.insert(User( email = email, password = passwordEt.text.toString()))
                    // findNavController()
//                    .navigate(R.id.action_loginFragment_to_userPageFragment, data)
                }
                else {
                    TODO("Исключение, если такой пользователь уже есть")
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }
}