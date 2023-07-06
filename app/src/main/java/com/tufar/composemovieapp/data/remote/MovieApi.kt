package com.tufar.composemovieapp.data.remote

import com.tufar.composemovieapp.data.remote.dto.MovieDetailDto
import com.tufar.composemovieapp.data.remote.dto.MoviesDto
import com.tufar.composemovieapp.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    //https://www.omdbapi.com/?apikey=f029f3e5&i=tt1285016
    //https://www.omdbapi.com/?apikey=f029f3e5&s=ironman

    @GET(" ")
    suspend fun getMovies(
        @Query("s") searchString : String,
        @Query("apikey") apiKey : String = API_KEY) : MoviesDto

    @GET(" ")
    suspend fun getMovieDetail(
        @Query("i") imdbId : String,
        @Query("apikey") apiKey : String = API_KEY) : MovieDetailDto
}