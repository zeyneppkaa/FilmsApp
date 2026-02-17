package com.example.filmsapp.data.entity

import java.io.Serializable

data class Film (var id: Int,
                 var ad: String,
                 var resim: String,
                 var fiyat: Int) : Serializable