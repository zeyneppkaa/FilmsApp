package com.example.filmsapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.filmsapp.R
import com.example.filmsapp.data.entity.Film
import com.example.filmsapp.databinding.FilmCardDesignBinding
import com.example.filmsapp.ui.fragment.HomeFragmentDirections
import com.google.android.material.snackbar.Snackbar

class FilmAdapter(var mContext : Context, var filmsList : List<Film> )
    : RecyclerView.Adapter<FilmAdapter.FilmCardDesignViewHolder>()

{
    inner class FilmCardDesignViewHolder( var design : FilmCardDesignBinding) : RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmCardDesignViewHolder {
        val binding : FilmCardDesignBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.film_card_design, parent, false)
        return FilmCardDesignViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FilmCardDesignViewHolder, position: Int) {
        val film = filmsList.get(position)
        val d = holder.design

        val url = "http://kasimadalan.pe.hu/filmler_yeni/resimler/${film.resim}"
        Glide.with(mContext).load(url).override(500,750).into(d.imageViewFilm)

        d.filmObject = film
        d.cardViewFilm.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(film)
            Navigation.findNavController(it).navigate(action)
        }

        d.buttonCart.setOnClickListener {
            Snackbar.make(it, "${film.ad} added to chart", Snackbar.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return filmsList.size
    }

}