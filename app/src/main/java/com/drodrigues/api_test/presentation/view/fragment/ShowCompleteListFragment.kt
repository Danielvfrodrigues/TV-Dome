package com.drodrigues.tvdome.presentation.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.drodrigues.tvdome.databinding.FragmentShowCompleteListBinding
import com.drodrigues.tvdome.domain.entity.ShowEntity
import com.drodrigues.tvdome.presentation.view.adapter.ShowCardViewAdapter
import com.drodrigues.tvdome.presentation.view.listener.ShowCardOnClickListener
import com.drodrigues.tvdome.presentation.viewmodel.MainViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class ShowCompleteListFragment : Fragment(), ShowCardOnClickListener {

    private lateinit var binding: FragmentShowCompleteListBinding
    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentShowCompleteListBinding.inflate(layoutInflater)

        val clickListener = this
        mainViewModel.getShowCompleteListLiveData.observe(viewLifecycleOwner) { showList ->
            binding.recyclerView.apply {
                layoutManager = GridLayoutManager(requireContext(), 2)
                adapter = ShowCardViewAdapter(showList, clickListener)
            }
        }

        mainViewModel.searchShowByQueryLiveData.observe(viewLifecycleOwner) { showList ->
            binding.recyclerView.apply {
                layoutManager = GridLayoutManager(requireContext(), 2)
                val list: ArrayList<ShowEntity> = arrayListOf()
                for (show in showList) {
                    list.add(show.showEntity)
                }
                adapter = ShowCardViewAdapter(list.toList(), clickListener)
            }
        }

        binding.showSearchButton.setOnClickListener {
            lifecycleScope.launch {
                val inputText = binding.showSearchTextInput.text.toString()
                mainViewModel.searchShowByQuery(inputText)
            }
        }

        lifecycleScope.launch {
            mainViewModel.getShowCompleteList()
        }

        return binding.root
    }

    override fun onClick(showEntity: ShowEntity) {
        val action = ShowCompleteListFragmentDirections
                .actionShowCompleteListFragmentToShowDetailsFragment(showEntity.id.toString())
        Navigation.findNavController(binding.root).navigate(action)
    }

}