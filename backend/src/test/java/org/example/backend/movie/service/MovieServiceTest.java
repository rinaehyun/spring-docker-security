package org.example.backend.movie.service;

import org.example.backend.movie.model.Movie;
import org.example.backend.movie.repository.MovieRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


class MovieServiceTest {

    MovieRepository movieRepository = mock(MovieRepository.class);
    MovieService movieService = new MovieService(movieRepository);

    @Test
    void retrieveAllMoviesTest_whenDBIsEmpty_thenReturnEmptyList() {
        // GIVEN
        List<Movie> movies = new ArrayList<>();
        when(movieRepository.findAll()).thenReturn(movies);

        // WHEN
        List<Movie> actual = movieService.getAllMovies();

        // THEN
        List<Movie> expected = new ArrayList<>();

        verify(movieRepository, times(1)).findAll();
        assertEquals(expected, actual);
        assertThat(actual).isEmpty();
    }

    @Test
    void retrieveAllMoviesTest_whenDBHasData_thenReturnAsList() {
        // GIVEN
        List<Movie> movies = List.of(
                new Movie("123", "Old Boy", "Action"),
                new Movie("456", "xxx", "romance")
        );
        when(movieRepository.findAll()).thenReturn(movies);

        // WHEN
        List<Movie> actual = movieService.getAllMovies();

        // THEN
        List<Movie> expected = List.of(
                new Movie("123", "Old Boy", "Action"),
                new Movie("456", "xxx", "romance")
        );

        verify(movieRepository, times(1)).findAll();
        assertEquals(expected, actual);
    }
}