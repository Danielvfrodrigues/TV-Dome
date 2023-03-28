package com.drodrigues.api_test.presentation.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.drodrigues.api_test.R
import com.drodrigues.api_test.databinding.FragmentFirstBinding
import com.drodrigues.api_test.databinding.FragmentSecondBinding
import com.drodrigues.api_test.presentation.view.adapter.CardViewAdapter
import com.drodrigues.api_test.presentation.viewmodel.MainViewModel
import com.squareup.picasso.Picasso
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    private val mainViewModel: MainViewModel by viewModel()
    private val args: SecondFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSecondBinding.inflate(layoutInflater)

        mainViewModel.getShowByIdLiveData.observe(viewLifecycleOwner) { show ->
            Picasso.get().load(show.imageEntity.medium).into(binding.showCover)
        }

        lifecycleScope.launch {
            mainViewModel.getShowById(args.showId)
        }


        return binding.root
    }

}