package com.gcyazilim.composemovieapp.domain.use_case.get_movie_detail

import coil.network.HttpException
import com.gcyazilim.composemovieapp.data.remote.dto.toMovieDetail
import com.gcyazilim.composemovieapp.domain.model.MovieDetail
import com.gcyazilim.composemovieapp.domain.repository.MovieRepository
import com.gcyazilim.composemovieapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetMovieDetailsUseCase
@Inject
constructor(private val repository: MovieRepository) {
    fun executeGetMovieDetails(imdbID: String): Flow<Resource<MovieDetail>> = flow {
        try {
            emit(Resource.Loading())
            val movieDetail = repository.getMovieDetail(imdbID)
            emit(Resource.Success(movieDetail.toMovieDetail()))
        } catch (e: IOException) {
            emit(Resource.Error("No internet connection"))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Error"))
        }
    }
}