package com.example.summerpractice2025.istok.fragments

import EducationalResource
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.summerpractice2025.istok.R
import com.example.summerpractice2025.istok.adapters.ResourcesAdapter
import com.example.summerpractice2025.istok.databinding.FragmentResourcesBinding

class ResourcesFragment : Fragment() {
    private var _binding: FragmentResourcesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResourcesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val resources = listOf(
            EducationalResource("Канал TheBatya", R.drawable.thebatya, "Разбор билетов по дискре и алгему", "https://www.youtube.com/channel/UCapIu0SouNfqYFdZjoPPgaw"),
            EducationalResource("Канал Профессор Лобанов", R.drawable.lobanov, "Разбор билетов по дискре", "https://www.youtube.com/@baronsamedi1511"),
            EducationalResource("Док TomatoJuice по проге 1 семестр", R.drawable.tomatojuice, "", ""),
            EducationalResource("Презентации М.М. Абрамского по ИиП 1 семестр", R.drawable.abr, "", "")
        )

        binding.resourcesRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.resourcesRecyclerView.adapter = ResourcesAdapter(resources) { resource ->
            val detailFragment = ResourceDetailFragment.newInstance(resource)
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, detailFragment)
                .addToBackStack(null)
                .commit()
        }
        binding.resourcesRecyclerView.setHasFixedSize(true)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}