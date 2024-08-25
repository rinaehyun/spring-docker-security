package org.example.backend.movie.controller;

import org.example.backend.movie.model.Movie;
import org.example.backend.movie.repository.MovieRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MovieControllerIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MovieRepository movieRepository;


    @Test
    @DirtiesContext
    void retrieveAllMoviesTest_whenRepoIsEmpty_thenReturnEmptyList() throws Exception {
        // GIVEN

        // WHEN
        mockMvc.perform(get("/api/movie"))
                // THEN
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    @Test
    @DirtiesContext
    void retrieveAllMoviesTest_whenRepoHasData_thenReturnMovieList() throws Exception {
        // GIVEN
        movieRepository.save(new Movie("123", "Old Boy", "Action"));
        movieRepository.save(new Movie("456", "xxx", "Romance"));

        // WHEN
        mockMvc.perform(get("/api/movie"))
                // THEN
                .andExpect(status().isOk())
                .andExpect(content().json("""
                    [
                        {
                          "id": "123",
                          "title": "Old Boy",
                          "genre": "Action"
                        },
                        {
                          "id": "456",
                          "title": "xxx",
                          "genre": "Romance"
                        }
                    ]
                """));
    }
}
