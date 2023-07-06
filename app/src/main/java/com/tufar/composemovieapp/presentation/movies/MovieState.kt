package com.tufar.composemovieapp.presentation.movies

import com.tufar.composemovieapp.domain.model.Movie

data class MovieState(
    val isLoading : Boolean = false,
    val movies : List<Movie> = emptyList(),
    val error : String = "",
    val search : String = "John Wick"
)
