package com.gcyazilim.composemovieapp.data.di

import com.gcyazilim.composemovieapp.data.remote.MovieApi
import com.gcyazilim.composemovieapp.data.repository.MovieRepositoryImpl
import com.gcyazilim.composemovieapp.domain.repository.MovieRepository
import com.gcyazilim.composemovieapp.domain.use_case.get_movies.GetMovieUseCase
import com.gcyazilim.composemovieapp.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMovieApi(): MovieApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMovieRepository(api: MovieApi): MovieRepository {
        return MovieRepositoryImpl(api)
    }
}