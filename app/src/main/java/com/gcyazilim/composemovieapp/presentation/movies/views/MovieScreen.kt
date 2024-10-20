package com.gcyazilim.composemovieapp.presentation.movies.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.gcyazilim.composemovieapp.presentation.Screen
import com.gcyazilim.composemovieapp.presentation.movies.MoviesEvent
import com.gcyazilim.composemovieapp.presentation.movies.view_model.MoviesViewModel

@Composable
fun MovieScreen(
    navController: NavController,
    innerPadding: PaddingValues,
    viewModel: MoviesViewModel = hiltViewModel()
) {

    val state = viewModel.state.value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(innerPadding)
    ) {
        Column() {
            MovieSearchBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                hint = "Batman",
            ) {
                viewModel.onEvent(MoviesEvent.Search(it))
            }

            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(state.movies) { movie ->
                    MovieListRow(movie = movie) {
                        navController.navigate(Screen.MovieDetailScreen.route + "/${movie.imdbID}")
                    }
                }
            }
        }

        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(14.dp)
                    .align(Alignment.Center)
            )
        }

        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }

}