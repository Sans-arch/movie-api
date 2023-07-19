package com.negreira.santiago.movieapi.controllers;

import com.negreira.santiago.movieapi.dtos.MovieDTO;
import com.negreira.santiago.movieapi.entities.Movie;
import com.negreira.santiago.movieapi.services.MovieService;

import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@Data
@RequestMapping("/api/movies")
public class MovieController {
	
	@Autowired
    private MovieService movieService;
	
	@PostMapping
    public List<Movie> createMovies(@RequestBody List<Movie> movies) {
        List<Movie> createdMovies = movieService.saveAll(movies);
        return createdMovies;
    }

    @GetMapping
    public List<MovieDTO> listAllMovies() {
        return movieService.getAll();
    }
    
    @GetMapping("/featured")
    public List<MovieDTO> listFeatured() {
    	return movieService.getFeaturedMovies();
    }
    
    @GetMapping(params = "name")
    public MovieDTO listMovie(String name) {
        return movieService.getMovieByName(name);
    }

    @GetMapping("/{id}")
    public MovieDTO listMovie(@PathVariable Long id) {
        return movieService.getMovieById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }
}
