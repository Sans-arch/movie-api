package com.negreira.santiago.movieapi.services;

import com.negreira.santiago.movieapi.dtos.MovieDTO;
import com.negreira.santiago.movieapi.entities.Movie;
import com.negreira.santiago.movieapi.repositories.MovieRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MovieService {
	
	@Autowired
    private MovieRepository movieRepository;

    public List<MovieDTO> getAll() {
    	List<Movie> moviesFromEntity = (List<Movie>) movieRepository.findAll();
    	
    	return moviesFromEntity.stream()
                .map(MovieDTO::new).toList();
    }
    
    public List<MovieDTO> getFeaturedMovies() {
    	return movieRepository.findFeaturedMovies().stream()
                .map(MovieDTO::new).toList();
    }

    public MovieDTO getMovieByName(String name) {
    	Movie movie = movieRepository.findByTitle(name);
        return new MovieDTO(movie);
    }

    public Movie save(Movie movie) {
        if (movie == null) {
            throw new IllegalArgumentException("Movie cannot be null");
        }

        return movieRepository.save(movie);
    }

    public List<Movie> saveAll(List<Movie> movies) {
        return (List<Movie>) movieRepository.saveAll(movies);
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

    public MovieDTO getMovieById(Long id) {
        Optional<Movie> movie = movieRepository.findById(id);
        return movie.isPresent() ? new MovieDTO(movie.get()) : null;
    }
}
