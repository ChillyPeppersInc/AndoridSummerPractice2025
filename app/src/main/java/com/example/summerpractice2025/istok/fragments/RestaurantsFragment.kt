package com.example.summerpractice2025.istok.fragments

import Restaurant
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.summerpractice2025.istok.R
import com.example.summerpractice2025.istok.adapters.RestaurantsAdapter
import com.example.summerpractice2025.istok.databinding.FragmentRestaurantsBinding

class RestaurantsFragment : Fragment() {
    private var _binding: FragmentRestaurantsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRestaurantsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val restaurants = listOf(
            Restaurant("Токмач",
                R.drawable.tokmach,
                "Адрес: Профсоюзная 23А",
                220),
            Restaurant("Шаурма сити",
                R.drawable.shaurmacity,
                "Адрес: Пушкина 17",
                300),
            Restaurant("Домашняя столовая",
                R.drawable.domashka,
                "Адрес: Баумана 70",
                250),
            Restaurant("Вкусно и точка",
                R.drawable.mcdonalds,
                "Адрес: Баумана 70А",
                400),
            Restaurant("Фудкорт в кольце",
                R.drawable.kolco,
                "Адрес: Баумана 70А\n\nВкусно и точка, кфс, бургер кинг, gagawa и т.д",
                500),
            Restaurant("Исфара",
                R.drawable.isfara,
                "Адрес: Кремлёвская ул., 25/22",
                200)
        )

        binding.restaurantsRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.restaurantsRecyclerView.adapter = RestaurantsAdapter(restaurants) { restaurant ->
            val detailFragment = RestaurantDetailFragment.newInstance(restaurant)
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, detailFragment)
                .addToBackStack(null)
                .commit()
        }
        binding.restaurantsRecyclerView.setHasFixedSize(true)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}