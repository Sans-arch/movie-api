package com.negreira.santiago.movieapi.controller;

import com.negreira.santiago.movieapi.entity.Movie;
import com.negreira.santiago.movieapi.service.MovieService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@Data
public class MovieController {
    private final MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> listAllMovies() {
        List<Movie> allMovies = movieService.listAll();
        return new ResponseEntity<>(allMovies, HttpStatus.OK);
    }
}
