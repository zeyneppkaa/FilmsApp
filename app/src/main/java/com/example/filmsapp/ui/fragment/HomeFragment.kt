package com.example.filmsapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.filmsapp.data.entity.Film
import com.example.filmsapp.databinding.FragmentHomeBinding
import com.example.filmsapp.ui.adapter.FilmAdapter

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.toolbarHome.title = "Home"
        binding.filmRv.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        val filmsList = ArrayList<Film>()
        val f1 = Film(1, "Django", "django", 24)
        val f2 = Film(2, "Interstellar", "interstellar", 32)
        val f3 = Film(3, "Inception", "inception", 16)
        val f4 = Film(4, "The Hateful Eight", "thehatefuleight", 28)
        val f5 = Film(5, "The Pianist", "thepianist", 18)
        val f6 = Film(6, "Anadoluda", "anadoluda", 10)
        filmsList.add(f1)
        filmsList.add(f2)
        filmsList.add(f3)
        filmsList.add(f4)
        filmsList.add(f5)
        filmsList.add(f6)

        val filmAdapter = FilmAdapter(requireContext(), filmsList)
        binding.filmRv.adapter = filmAdapter

        return binding.root
    }
}