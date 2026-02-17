package com.example.filmsapp.data.datasource

import com.example.filmsapp.data.entity.Film
import com.example.filmsapp.retrofit.FilmsDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FilmsDataSource(var fdao: FilmsDao) {
    suspend fun loadFilms() : List<Film> =
        withContext(Dispatchers.IO){
            return@withContext fdao.loadFilms().filmler
        }
}