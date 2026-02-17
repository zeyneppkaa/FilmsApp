package com.example.filmsapp.retrofit

import com.example.filmsapp.data.entity.FilmsResponse
import retrofit2.http.GET

interface FilmsDao {
    // http://kasimadalan.pe.hu/filmler_yeni/resimler/django.png
    // http://kasimadalan.pe.hu/ -> base url
    // filmler_yeni/tum_filmler.php -> web service url

    @GET("filmler_yeni/tum_filmler.php")
    suspend fun loadFilms(): FilmsResponse
}