package com.example.filmsapp.data.entity

import java.io.Serializable

data class Film ( var id: Int,
                  var name: String,
                  var image: String,
                  var price: Int ) : Serializable