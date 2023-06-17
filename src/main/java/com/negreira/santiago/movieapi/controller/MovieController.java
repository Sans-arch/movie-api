package com.negreira.santiago.movieapi.controller;

import com.negreira.santiago.movieapi.entity.Movie;
import com.negreira.santiago.movieapi.service.MovieService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@Data
public class MovieController {
    private final MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> listAllMovies() {
        List<Movie> allMovies = movieService.getAll();
        return new ResponseEntity<>(allMovies, HttpStatus.OK);
    }

    @GetMapping(params = "name")
    public Movie listMovie(String name) {
        return movieService.getMovieByName(name);
    }

    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        Movie createdMovie = movieService.save(movie);
        return new ResponseEntity<>(createdMovie, HttpStatus.CREATED);
    }
}
