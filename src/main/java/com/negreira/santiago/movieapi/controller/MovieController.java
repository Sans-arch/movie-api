package com.negreira.santiago.movieapi.controller;

import com.negreira.santiago.movieapi.entity.Movie;
import com.negreira.santiago.movieapi.service.MovieService;
import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@Data
public class MovieController {
	
	@Autowired
    private MovieService movieService;
	
	@PostMapping
    public List<Movie> createMovies(@RequestBody List<Movie> movies) {
        List<Movie> createdMovies = movieService.saveAll(movies);
        return createdMovies;
    }

    @GetMapping
    public List<Movie> listAllMovies() {
        List<Movie> allMovies = movieService.getAll();
        
        return allMovies;
    }
    
    @GetMapping(params = "name")
    public Movie listMovie(String name) {
        return movieService.getMovieByName(name);
    }

    @GetMapping("/{id}")
    public Movie listMovie(@PathVariable Integer id) {
        return movieService.getMovieById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable Integer id) {
        movieService.deleteMovie(id);

        return ResponseEntity.noContent().build();
    }
}
