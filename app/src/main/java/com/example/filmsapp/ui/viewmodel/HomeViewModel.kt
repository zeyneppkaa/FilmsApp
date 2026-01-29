package com.example.filmsapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.filmsapp.data.entity.Film
import com.example.filmsapp.data.repo.FilmsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    var fRepo = FilmsRepository()
    var filmsList = MutableLiveData<List<Film>>()
    init {
        loadFilms()
    }
    fun loadFilms(){
        CoroutineScope(Dispatchers.Main).launch {
            filmsList.value = fRepo.loadFilms()
        }
    }
}