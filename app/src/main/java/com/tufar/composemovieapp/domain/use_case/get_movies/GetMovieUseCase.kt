package com.tufar.composemovieapp.domain.use_case.get_movies

import com.tufar.composemovieapp.data.remote.dto.toMovieList
import com.tufar.composemovieapp.domain.model.Movie
import com.tufar.composemovieapp.domain.repository.MovieRepo
import com.tufar.composemovieapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOError
import javax.inject.Inject

class GetMovieUseCase @Inject constructor(private val repo : MovieRepo){

    fun executeGetMovies(searhString : String) : Flow<Resource<List<Movie>>> = flow{
        try {
            emit(Resource.Loading())
            val movieList = repo.getMovies(searhString)
            if (movieList.Response.equals("True")){
                emit(Resource.Success(movieList.toMovieList()))
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