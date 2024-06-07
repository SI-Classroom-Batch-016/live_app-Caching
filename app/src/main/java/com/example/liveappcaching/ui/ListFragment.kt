package com.example.liveappcaching.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.liveappcaching.databinding.FragmentListBinding
import com.example.liveappcaching.ui.viewmodels.ListViewModel

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private val viewModel: ListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loadData()

        viewModel.drinks.observe(viewLifecycleOwner) { drinks ->
            Log.d("DrinkLiveData", drinks.toString())

            binding.drinksRV.adapter = DrinkAdapter(drinks) { clickedDrink ->
                Log.d("onDrinkClicked", clickedDrink.name)

                findNavController().navigate(
                    ListFragmentDirections.actionListFragmentToDetailFragment(
                        drinkId = clickedDrink.id
                    )
                )
            }
        }
    }
}