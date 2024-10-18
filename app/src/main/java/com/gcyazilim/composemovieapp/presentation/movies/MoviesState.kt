package com.gcyazilim.composemovieapp.presentation.movies

import com.gcyazilim.composemovieapp.domain.model.Movie

data class MoviesState(
    val isLoading: Boolean = false,
    val movies: List<Movie> = emptyList(),
    val error: String = "",
    val search: String = "batman"
)
