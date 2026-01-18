package com.example.filmsapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.filmsapp.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    private lateinit var binding : FragmentDetailBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)

        val bundle : DetailFragmentArgs by navArgs()
        val film = bundle.film
        binding.toolbarDetail.title = film.name
        binding.ivFilm.setImageResource(
            resources.getIdentifier(film.image, "drawable", requireContext().packageName)
        )
        binding.tvPrice.text = "${film.price} TL"
        return binding.root
    }
}