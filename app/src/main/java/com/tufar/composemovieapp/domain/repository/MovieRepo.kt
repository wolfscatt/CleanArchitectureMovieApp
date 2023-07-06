package com.tufar.composemovieapp.domain.repository

import com.tufar.composemovieapp.data.remote.dto.MovieDetailDto
import com.tufar.composemovieapp.data.remote.dto.MoviesDto

interface MovieRepo {
    suspend fun getMovies(search : String) : MoviesDto
    suspend fun getMovieDetail(imdbId : String) : MovieDetailDto
}