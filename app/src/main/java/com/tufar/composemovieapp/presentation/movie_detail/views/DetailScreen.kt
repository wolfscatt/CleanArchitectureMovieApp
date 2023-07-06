package com.tufar.composemovieapp.presentation.movie_detail.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.tufar.composemovieapp.presentation.movie_detail.MovieDetailViewModel

@Composable
fun DetailScreen(viewModel: MovieDetailViewModel = hiltViewModel()) {

    val state = viewModel.state.value

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black),
    contentAlignment = Alignment.Center){
        state.movie?.let {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {
                Image(painter = rememberImagePainter(data = it.Poster),
                    contentDescription = it.Title,
                    modifier = Modifier
                        .padding(15.dp)
                        .size(300.dp, 300.dp)
                        .clip(RectangleShape)
                        .align(CenterHorizontally)
                )

                Text(
                    text = "Title: "+it.Title,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(13.dp),
                    color = Color.Green
                )
                Text(
                    text = "Year: "+it.Year,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(13.dp),
                    color = Color.Green
                )
                Text(
                    text = "Director: "+it.Director,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(13.dp),
                    color = Color.Green
                )
                Text(
                    text = "Actors: "+it.Actors,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(13.dp),
                    color = Color.Green
                )
                Text(
                    text = "Country: "+it.Country,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(13.dp),
                    color = Color.Green
                )
                Text(
                    text = "Genre: "+it.Genre,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(13.dp),
                    color = Color.Green
                )
                Text(
                    text = "Language: "+it.Language,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(13.dp),
                    color = Color.Green
                )
                Text(
                    text = "Awards: "+it.Awards,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(13.dp),
                    color = Color.Green
                )
                Text(
                    text = "IMDBRating: "+it.imdbRating,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(13.dp),
                    color = Color.Green
                )
            }
        }
        if (state.error.isNotBlank()){
            Text(text = state.error,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.error,
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
                .align(Center))
        }
        if (state.isLoading){
            CircularProgressIndicator(modifier = Modifier.align(Center))
        }
    }

}