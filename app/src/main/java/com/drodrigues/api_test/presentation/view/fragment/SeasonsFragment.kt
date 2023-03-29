package com.drodrigues.tvdome.presentation.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.drodrigues.tvdome.databinding.FragmentSeasonsBinding
import com.drodrigues.tvdome.domain.entity.SeasonEntity
import com.drodrigues.tvdome.presentation.view.adapter.SeasonCardViewAdapter
import com.drodrigues.tvdome.presentation.view.listener.SeasonCardClickListener
import com.drodrigues.tvdome.presentation.viewmodel.MainViewModel
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