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
import com.drodrigues.tvdome.databinding.FragmentEpisodesBinding
import com.drodrigues.tvdome.domain.entity.EpisodeEntity
import com.drodrigues.tvdome.presentation.view.adapter.EpisodeCardViewAdapter
import com.drodrigues.tvdome.presentation.view.listener.EpisodeCardClickListener
import com.drodrigues.tvdome.presentation.viewmodel.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class EpisodesFragment : Fragment(), EpisodeCardClickListener {

    private lateinit var binding: FragmentEpisodesBinding
    private val mainViewModel: MainViewModel by viewModel()
    private val args: EpisodesFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val clickListener = this
        binding = FragmentEpisodesBinding.inflate(layoutInflater)

        mainViewModel.getEpisodeListBySeasonIdLiveData.observe(viewLifecycleOwner) { episodeList ->
            binding.recyclerView.apply {
                layoutManager = GridLayoutManager(requireContext(), 2)
                adapter = EpisodeCardViewAdapter(episodeList, clickListener)
            }
        }

        lifecycleScope.launch(Dispatchers.Main) {
            mainViewModel.getEpisodeListBySeasonId(args.seasonId)
        }


        return binding.root
    }

    override fun onClick(episodeEntity: EpisodeEntity) {
        val action =
            EpisodesFragmentDirections.actionEpisodesFragmentToEpisodeDetailsFragment(episodeEntity.id)
        Navigation.findNavController(binding.root).navigate(action)
    }
}