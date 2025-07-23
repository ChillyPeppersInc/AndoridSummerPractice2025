package com.example.summerpractice2025.istok.fragments

import Teacher
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.summerpractice2025.istok.databinding.FragmentTeacherDetailBinding

class TeacherDetailFragment : Fragment() {
    private var _binding: FragmentTeacherDetailBinding? = null
    private val binding get() = _binding!!

    companion object {
        private const val ARG_TEACHER = "teacher"

        fun newInstance(teacher: Teacher): TeacherDetailFragment {
            val args = Bundle().apply {
                putParcelable(ARG_TEACHER, teacher)
            }
            return TeacherDetailFragment().apply {
                arguments = args
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTeacherDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.getParcelable<Teacher>(ARG_TEACHER)?.let { teacher ->
            with(binding) {
                teacherImage.setImageResource(teacher.imageResId)
                teacherName.text = teacher.name
                teacherDescription.text = teacher.description
                teacherExam.text = teacher.exam
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}