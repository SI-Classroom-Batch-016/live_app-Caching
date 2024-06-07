package com.example.liveappcaching.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.liveappcaching.R
import com.example.liveappcaching.databinding.FragmentDetailBinding
import com.example.liveappcaching.ui.viewmodels.DetailViewModel


class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding

    private val viewModel: DetailViewModel by viewModels()

    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //getDrinkDetails liefert mir die LiveData und
        //sorgt dafür dass die Daten geladen und gecached werden
        viewModel.getDrinkDetails(args.drinkId).observe(viewLifecycleOwner) {
            if (it != null) {
                binding.textView.text = it.toString()
            }
        }


    }


}