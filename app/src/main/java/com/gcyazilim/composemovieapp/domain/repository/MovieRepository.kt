package com.gcyazilim.composemovieapp.domain.repository

import com.gcyazilim.composemovieapp.data.remote.dto.MovieDetailDto
import com.gcyazilim.composemovieapp.data.remote.dto.MoviesDto

interface MovieRepository {
    suspend fun getMovies(search: String): MoviesDto

    suspend fun getMovieDetail(imdbID: String): MovieDetailDto
}