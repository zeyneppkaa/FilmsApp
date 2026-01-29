package com.example.filmsapp.data.repo

import com.example.filmsapp.data.datasource.FilmsDataSource
import com.example.filmsapp.data.entity.Film

class FilmsRepository {
    var fds = FilmsDataSource()
    suspend fun loadFilms() : List<Film> = fds.loadFilms()
}