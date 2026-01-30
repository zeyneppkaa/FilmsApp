package com.example.filmsapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.filmsapp.R
import com.example.filmsapp.databinding.FragmentHomeBinding
import com.example.filmsapp.ui.adapter.FilmAdapter
import com.example.filmsapp.ui.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: HomeViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.homeToolbarTitle = "Home"

        viewModel.filmsList.observe(viewLifecycleOwner){
            val filmAdapter = FilmAdapter(requireContext(), it)
            binding.filmsAdapter = filmAdapter
        }
        return binding.root
    }
}