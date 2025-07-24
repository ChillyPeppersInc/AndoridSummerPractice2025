package com.example.summerpractice2025.istok.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.summerpractice2025.istok.databinding.FragmentOtherBinding
import com.example.summerpractice2025.istok.AuthActivity

class OtherFragment : Fragment() {
    private var _binding: FragmentOtherBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOtherBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Ссылки на соцсети
        binding.antonVk.setOnClickListener {
            openUrl("https://vk.com/waytothedoom")
        }
        binding.antonTg.setOnClickListener {
            openUrl("https://t.me/tiktokerOMG")
        }
        binding.timurTg.setOnClickListener {
            openUrl("https://t.me/JrMladshiy")
        }
        binding.samirTg.setOnClickListener {
            openUrl("https://t.me/sam1rrrr")
        }
        binding.arslanTg.setOnClickListener {
            openUrl("https://t.me/Arslan_Khs")
        }

        // Ссылка на Donation Alerts
        binding.donationAlerts.setOnClickListener {
            openUrl("https://www.donationalerts.com/r/ваш_ник") // Замените на свою ссылку
        }

        // Кнопка выхода
        binding.logoutButton.setOnClickListener {
            // Очистка данных авторизации (зависит от вашей реализации)
            requireActivity().finish()
            startActivity(Intent(requireContext(), AuthActivity::class.java))
        }
    }

    private fun openUrl(url: String) {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}