package com.negreira.santiago.movieapi.service;

import com.negreira.santiago.movieapi.entity.Movie;
import com.negreira.santiago.movieapi.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAll() {
        return (List<Movie>) movieRepository.findAll();
    }

    public Movie getMovieByName(String name) {
        return movieRepository.findByName(name);
    }

    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }
}
