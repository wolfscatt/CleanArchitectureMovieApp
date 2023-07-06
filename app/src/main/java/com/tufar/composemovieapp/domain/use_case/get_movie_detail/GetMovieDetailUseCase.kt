package com.tufar.composemovieapp.domain.use_case.get_movie_detail

import com.tufar.composemovieapp.data.remote.dto.toMovieDetail
import com.tufar.composemovieapp.data.remote.dto.toMovieList
import com.tufar.composemovieapp.domain.model.Movie
import com.tufar.composemovieapp.domain.model.MovieDetail
import com.tufar.composemovieapp.domain.repository.MovieRepo
import com.tufar.composemovieapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOError
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(private val repo : MovieRepo) {
    fun executeGetMovieDetail(imdbId : String) : Flow<Resource<MovieDetail>> = flow{
        try {
            emit(Resource.Loading())
            val movieDetail = repo.getMovieDetail(imdbId)
            if (movieDetail.Response.equals("True")){
                emit(Resource.Success(movieDetail.toMovieDetail()))
            }else{
                emit(Resource.Error("Movie not Found"))
            }
        }catch (ex: IOError){
            emit(Resource.Error(ex.localizedMessage ?: "No internet connection"))
        }catch (ex: HttpException){
            emit(Resource.Error(ex.localizedMessage ?: "Request Error"))
        }
    }
}