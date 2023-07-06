package com.negreira.santiago.movieapi.repository;

import com.negreira.santiago.movieapi.entity.Movie;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {
    Movie findByTitle(String title);
    
    @Query("SELECT m FROM Movie m WHERE m.releaseYear >= 2000")
    List<Movie> findFeaturedMovies();
}
