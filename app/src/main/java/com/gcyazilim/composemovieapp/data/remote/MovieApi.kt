package com.gcyazilim.composemovieapp.data.remote

import com.gcyazilim.composemovieapp.data.remote.dto.MovieDetailDto
import com.gcyazilim.composemovieapp.data.remote.dto.MoviesDto
import com.gcyazilim.composemovieapp.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET(".")
    suspend fun getMovies(
        @Query("s") searchString: String,
        @Query("apikey") apiKey: String = API_KEY,
    ): MoviesDto

    @GET(".")
    suspend fun getMovieDetail(
        @Query("i") imdbID: String,
        @Query("apikey") apiKey: String = API_KEY,
    ): MovieDetailDto
}