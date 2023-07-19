package com.negreira.santiago.movieapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.negreira.santiago.movieapi.entities.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {
    Movie findByTitle(String title);
    
    @Query("SELECT m FROM Movie m WHERE m.releaseYear >= 2000")
    List<Movie> findFeaturedMovies();
}
