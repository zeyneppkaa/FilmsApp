package com.example.filmsapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.filmsapp.data.entity.Film
import com.example.filmsapp.databinding.FilmCardDesignBinding
import com.example.filmsapp.ui.fragment.HomeFragmentDirections
import com.google.android.material.snackbar.Snackbar

class FilmAdapter( var mContex : Context, var filmsList : List<Film> )
    : RecyclerView.Adapter<FilmAdapter.FilmCardDesignViewHolder>()

{
    inner class FilmCardDesignViewHolder( var design : FilmCardDesignBinding) : RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmCardDesignViewHolder {
        val binding = FilmCardDesignBinding.inflate(LayoutInflater.from(mContex), parent, false)
        return FilmCardDesignViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FilmCardDesignViewHolder, position: Int) {
        val film = filmsList.get(position)
        val d = holder.design

        d.imageViewFilm.setImageResource(mContex.resources.getIdentifier(film.image, "drawable", mContex.packageName))
        d.textViewPrice.text = "${film.price} TL"

        d.cardViewFilm.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(film)
            Navigation.findNavController(it).navigate(action)
        }

        d.buttonCart.setOnClickListener {
            Snackbar.make(it, "${film.name} added to chart", Snackbar.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return filmsList.size
    }

}