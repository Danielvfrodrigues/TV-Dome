package com.drodrigues.api_test.presentation.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.drodrigues.api_test.databinding.FragmentEpisodesBinding
import com.drodrigues.api_test.presentation.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class EpisodesFragment : Fragment() {

    private lateinit var binding: FragmentEpisodesBinding
    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentEpisodesBinding.inflate(layoutInflater)

//        val action =
//            ShowDetailsFragmentDirections.actionShowDetailsFragmentToSeasonsFragment(args.showId)
//        Navigation.findNavController(binding.root).navigate(action)

        return binding.root
    }
}