package com.negreira.santiago.movieapi.repositories;

import com.negreira.santiago.movieapi.dtos.MovieDTO;
import com.negreira.santiago.movieapi.entities.Movie;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@ActiveProfiles("test")
class MovieRepositoryTest {
    @Autowired
    EntityManager entityManager;

    @Autowired
    MovieRepository movieRepository;

    @Test
    @DisplayName("Should get Movie successfully from database")
    void findFeaturedMoviesSuccess() {
        MovieDTO data = new MovieDTO(1L, "Matrix", "Crazy Movie", 1999,
                "Action", "Lana Wachowski", 80.5, 89.2, "a");
        this.createMovie(data);

        Optional<List<Movie>> result = this.movieRepository.findFeaturedMovies();

        assertThat(result.isEmpty()).isTrue();
    }

    private Movie createMovie(MovieDTO data) {
        Movie newMovie = new Movie(data);
        this.entityManager.persist(newMovie);
        return newMovie;
    }
}