package com.gcyazilim.composemovieapp.data.repository

import com.gcyazilim.composemovieapp.data.remote.MovieApi
import com.gcyazilim.composemovieapp.data.remote.dto.MovieDetailDto
import com.gcyazilim.composemovieapp.data.remote.dto.MoviesDto
import com.gcyazilim.composemovieapp.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl
@Inject
constructor(
    private val api: MovieApi
) : MovieRepository {
    override suspend fun getMovies(search: String): MoviesDto = api.getMovies(search)

    override suspend fun getMovieDetail(imdbID: String): MovieDetailDto = api.getMovieDetail(imdbID)
}