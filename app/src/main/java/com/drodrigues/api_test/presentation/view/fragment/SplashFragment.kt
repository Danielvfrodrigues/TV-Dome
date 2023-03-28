package com.drodrigues.api_test.presentation.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.drodrigues.api_test.databinding.FragmentSplashBinding

/**
 * An example full-screen fragment that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class SplashFragment : Fragment() {

    private lateinit var binding: FragmentSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentSplashBinding.inflate(layoutInflater)
        navigate()

        return binding.root
    }

    private fun navigate() {
        val action =
            SplashFragmentDirections.actionSplashFragmentToFirstFragment()
        Navigation.findNavController(binding.root).navigate(action)
    }
}