package com.tufar.composemovieapp.data.remote.dto

import com.tufar.composemovieapp.domain.model.Movie

data class MoviesDto(
    val Response: String,
    val Search: List<Search>,
    val totalResults: String
)

fun MoviesDto.toMovieList() : List<Movie>{
    return Search.map { search -> Movie(search.Title, search.Year, search.Poster, search.imdbID) }
}