package com.example.summerpractice2025.istok.fragments

import Restaurant
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.summerpractice2025.istok.databinding.FragmentRestaurantDetailBinding

class RestaurantDetailFragment : Fragment() {
    private var _binding: FragmentRestaurantDetailBinding? = null
    private val binding get() = _binding!!

    companion object {
        private const val ARG_RESTAURANT = "restaurant"

        fun newInstance(restaurant: Restaurant): RestaurantDetailFragment {
            val args = Bundle().apply {
                putParcelable(ARG_RESTAURANT, restaurant)
            }
            return RestaurantDetailFragment().apply {
                arguments = args
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRestaurantDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.getParcelable<Restaurant>(ARG_RESTAURANT)?.let { restaurant ->
            with(binding) {
                restaurantImage.setImageResource(restaurant.imageResId)
                restaurantName.text = restaurant.name
                restaurantDescription.text = restaurant.description
                restaurantPrice.text = "Средний чек: " + restaurant.price
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}