package com.example.summerpractice2025.istok.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.summerpractice2025.istok.databinding.FragmentTeachersBinding


class TeachersFragment : Fragment() {
    private var _binding: FragmentTeachersBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTeachersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.titleText.text = "Список преподавателей"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}