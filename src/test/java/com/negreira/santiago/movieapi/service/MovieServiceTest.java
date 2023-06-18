package com.negreira.santiago.movieapi.service;

import com.negreira.santiago.movieapi.entity.Movie;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.JRE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class MovieServiceTest {
    @Autowired
    private MovieService movieService;

    @Test
    @DisplayName("Save a movie")
    @EnabledForJreRange(min = JRE.JAVA_17)
    void save() {
        Movie movie = new Movie(22, "The Godfather", 1972,
                "Drama", "Francis Ford Coppola");

        Movie createdMovie = movieService.save(movie);
        System.out.println(createdMovie);

        assertNotNull(createdMovie);
    }

    @Test
    @DisplayName("Save a list of many movies")
    @EnabledForJreRange(min = JRE.JAVA_17)
    void saveAll() {
        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie(22, "The Godfather", 1972,
                "Drama", "Francis Ford Coppola"));
        movieList.add(new Movie(23, "The Godfather: Part II", 1974,
                "Drama", "Francis Ford Coppola"));
        movieList.add(new Movie(24, "The Godfather: Part III", 1990,
                "Drama", "Francis Ford Coppola"));
        movieList.add(new Movie(25, "The Shawshank Redemption", 1994,
                "Drama", "Frank Darabont"));

        List<Movie> createdMovies = movieService.saveAll(movieList);
        System.out.println(createdMovies);

        assertEquals(createdMovies.size(), 4);
    }
}