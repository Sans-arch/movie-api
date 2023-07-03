package com.negreira.santiago.movieapi.repository;

import com.negreira.santiago.movieapi.entity.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {
    Movie findByTitle(String title);
}
