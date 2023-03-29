package com.drodrigues.tvdome.presentation.view.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.drodrigues.tvdome.databinding.FragmentEpisodeDetailsBinding
import com.drodrigues.tvdome.presentation.viewmodel.MainViewModel
import com.squareup.picasso.Picasso
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class EpisodeDetailsFragment : Fragment() {

    private lateinit var binding: FragmentEpisodeDetailsBinding
    private val mainViewModel: MainViewModel by viewModel()
    private val args: EpisodeDetailsFragmentArgs by navArgs()

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentEpisodeDetailsBinding.inflate(layoutInflater)

        mainViewModel.getEpisodeByIdLiveData.observe(viewLifecycleOwner) { episode ->
            Picasso.get().load(episode.imageEntity.medium).into(binding.episodeCover)
            binding.episodeName.text = episode.name
            binding.episodeNumber.text = "Episode ${episode.number}"
            binding.episodeSeasonNumber.text = "Season ${episode.season}"
            binding.episodeRuntime.text = "${episode.runtime} min"
            binding.episodeSummary.text = HtmlCompat.fromHtml(episode.summary, HtmlCompat.FROM_HTML_MODE_LEGACY)
        }

        lifecycleScope.launch {
            mainViewModel.getEpisodeById(args.episodeId)
        }

        return binding.root
    }
}