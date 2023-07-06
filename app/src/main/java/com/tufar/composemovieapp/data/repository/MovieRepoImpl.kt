package com.tufar.composemovieapp.data.repository

import com.tufar.composemovieapp.data.remote.MovieApi
import com.tufar.composemovieapp.data.remote.dto.MovieDetailDto
import com.tufar.composemovieapp.data.remote.dto.MoviesDto
import com.tufar.composemovieapp.domain.repository.MovieRepo
import javax.inject.Inject

class MovieRepoImpl @Inject constructor(private val api : MovieApi): MovieRepo{
    override suspend fun getMovies(search: String): MoviesDto {
        return api.getMovies(search)
    }

    override suspend fun getMovieDetail(imdbId: String): MovieDetailDto {
        return api.getMovieDetail(imdbId)
    }
}