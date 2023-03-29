package com.drodrigues.api_test.presentation.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.drodrigues.api_test.databinding.FragmentShowCompleteListBinding
import com.drodrigues.api_test.domain.entity.ShowEntity
import com.drodrigues.api_test.presentation.view.adapter.ShowCardViewAdapter
import com.drodrigues.api_test.presentation.view.listener.ShowCardClickListener
import com.drodrigues.api_test.presentation.viewmodel.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class ShowCompleteListFragment : Fragment(), ShowCardClickListener {

    private lateinit var binding: FragmentShowCompleteListBinding
    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val firstFragment = this
        binding = FragmentShowCompleteListBinding.inflate(layoutInflater)

        mainViewModel.getShowCompleteListLiveData.observe(viewLifecycleOwner) { showList ->
            binding.recyclerView.apply {
                layoutManager = GridLayoutManager(requireContext(), 3)
                adapter = ShowCardViewAdapter(showList, firstFragment)
            }
        }

        lifecycleScope.launch(Dispatchers.Main) {
            mainViewModel.getShowCompleteList()
        }

        return binding.root
    }

    override fun onClick(showEntity: ShowEntity) {
        val action =
            ShowCompleteListFragmentDirections.actionShowCompleteListFragmentToShowDetailsFragment(showEntity.id.toString())
        Navigation.findNavController(binding.root).navigate(action)
    }

}