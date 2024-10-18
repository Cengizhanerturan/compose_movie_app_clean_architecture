package com.gcyazilim.composemovieapp.domain.use_case.get_movies

import coil.network.HttpException
import com.gcyazilim.composemovieapp.data.remote.dto.toMovieList
import com.gcyazilim.composemovieapp.domain.model.Movie
import com.gcyazilim.composemovieapp.domain.repository.MovieRepository
import com.gcyazilim.composemovieapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetMovieUseCase
@Inject
constructor(private val repository: MovieRepository) {
    fun executeGetMovies(search: String): Flow<Resource<List<Movie>>> = flow {
        try {
            emit(Resource.Loading())
            val movieList = repository.getMovies(search)
            if (movieList.Response == "True") {
                emit(Resource.Success(movieList.toMovieList()))
            } else {
                emit(Resource.Error("No movie found!"))
            }
        } catch (e: IOException) {
            emit(Resource.Error("No internet connection"))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Error"))
        }
    }
}