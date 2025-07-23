package com.example.summerpractice2025.istok.fragments

import EducationalResource
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.summerpractice2025.istok.databinding.FragmentResourceDetailBinding

class ResourceDetailFragment : Fragment() {
    private var _binding: FragmentResourceDetailBinding? = null
    private val binding get() = _binding!!

    companion object {
        private const val ARG_RESOURCE = "resource"

        fun newInstance(resource: EducationalResource): ResourceDetailFragment {
            val args = Bundle().apply {
                putParcelable(ARG_RESOURCE, resource)
            }
            return ResourceDetailFragment().apply {
                arguments = args
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResourceDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.getParcelable<EducationalResource>(ARG_RESOURCE)?.let { resource ->
            with(binding) {
                resourceImage.setImageResource(resource.imageResId)
                resourceTitle.text = resource.title
                resourceDescription.text = resource.description
                resourceLink.text = resource.link
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}