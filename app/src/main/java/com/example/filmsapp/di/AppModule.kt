package com.example.filmsapp.di

import com.example.filmsapp.data.datasource.FilmsDataSource
import com.example.filmsapp.data.repo.FilmsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideFilmsDataSource(): FilmsDataSource {
        return FilmsDataSource()
    }

    @Provides
    @Singleton
    fun provideFilmsRepository(fds: FilmsDataSource): FilmsRepository {
        return FilmsRepository(fds)
    }
}