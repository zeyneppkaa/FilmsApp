package com.example.filmsapp.data.datasource

import com.example.filmsapp.data.entity.Film
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FilmsDataSource {
    suspend fun loadFilms() : List<Film> =
        withContext(Dispatchers.IO){
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

            return@withContext filmsList
        }
}