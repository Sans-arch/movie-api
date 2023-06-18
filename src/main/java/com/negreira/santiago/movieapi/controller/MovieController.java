package com.negreira.santiago.movieapi.controller;

import com.negreira.santiago.movieapi.entity.Movie;
import com.negreira.santiago.movieapi.service.MovieService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public Optional<Movie> listMovie(@PathVariable Integer id) {
        return movieService.getMovieById(id);
    }

    @PostMapping
    public ResponseEntity<List<Movie>> createMovies(@RequestBody List<Movie> movies) {
        List<Movie> createdMovies = movieService.saveAll(movies);
        return new ResponseEntity<>(createdMovies, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable Integer id) {
        movieService.deleteMovie(id);

        return ResponseEntity.noContent().build();
    }
}
