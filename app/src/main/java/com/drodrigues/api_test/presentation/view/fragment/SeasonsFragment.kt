package com.drodrigues.api_test.presentation.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.drodrigues.api_test.databinding.FragmentSeasonsBinding
import com.drodrigues.api_test.domain.entity.SeasonEntity
import com.drodrigues.api_test.presentation.view.adapter.SeasonCardViewAdapter
import com.drodrigues.api_test.presentation.view.listener.SeasonCardClickListener
import com.drodrigues.api_test.presentation.viewmodel.MainViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class SeasonsFragment : Fragment(), SeasonCardClickListener {

    private lateinit var binding: FragmentSeasonsBinding
    private val mainViewModel: MainViewModel by viewModel()
    private val args: SeasonsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val clickListener = this
        binding = FragmentSeasonsBinding.inflate(layoutInflater)

        mainViewModel.getSeasonListByShowIdLivedata.observe(viewLifecycleOwner) { seasonList ->
            binding.recyclerView.apply {
                layoutManager = GridLayoutManager(requireContext(), 1)
                adapter = SeasonCardViewAdapter(seasonList, clickListener)
            }
        }

        lifecycleScope.launch {
            mainViewModel.getSeasonListByShowId(args.showId)
        }

        return binding.root
    }

    override fun onClick(seasonEntity: SeasonEntity) {
        val action =
            SeasonsFragmentDirections.actionSeasonsFragmentToEpisodesFragment(seasonEntity.id)
        Navigation.findNavController(binding.root).navigate(action)
    }
}