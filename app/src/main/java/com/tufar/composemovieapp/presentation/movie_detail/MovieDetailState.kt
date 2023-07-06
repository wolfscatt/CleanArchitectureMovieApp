package com.tufar.composemovieapp.presentation.movie_detail

import com.tufar.composemovieapp.domain.model.MovieDetail

data class MovieDetailState(
    val isLoading : Boolean = false,
    val movie : MovieDetail? = null,
    val error : String = ""
)
