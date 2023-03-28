package com.drodrigues.api_test.presentation.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.drodrigues.api_test.databinding.FragmentFirstBinding
import com.drodrigues.api_test.domain.entity.ShowEntity
import com.drodrigues.api_test.presentation.view.adapter.CardViewAdapter
import com.drodrigues.api_test.presentation.view.listener.ShowCardClickListener
import com.drodrigues.api_test.presentation.viewmodel.MainViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class FirstFragment : Fragment(), ShowCardClickListener {

    private lateinit var binding: FragmentFirstBinding
    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val firstFragment = this

        binding = FragmentFirstBinding.inflate(layoutInflater)

        mainViewModel.getShowCompleteListLiveData.observe(viewLifecycleOwner) { showList ->
            binding.recyclerView.apply {
                layoutManager = GridLayoutManager(requireContext(), 3)
                adapter = CardViewAdapter(showList, firstFragment)
            }
        }

        lifecycleScope.launch {
            mainViewModel.getShowCompleteList()
        }

        return binding.root
    }

    override fun onClick(showEntity: ShowEntity) {
        val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment("1")
        Navigation.findNavController(binding.root).navigate(action)
    }

}