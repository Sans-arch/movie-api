package com.negreira.santiago.movieapi.entities;

import com.negreira.santiago.movieapi.dtos.MovieDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "movies")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;
    
    @Column
    private String originInfo;

    @Column
    private Integer releaseYear;

    @Column
    private String genres;

    @Column
    private String director;
    
    @Column
    private Double imdbRating;
    
    @Column
    private Double rottenRating;
    
    @Column(columnDefinition = "TEXT", length = 1000)
    private String posterUrl;

    public Movie(MovieDTO movieDTO) {
        this.id = movieDTO.getId();
        this.title = movieDTO.getTitle();
        this.originInfo = movieDTO.getOriginInfo();
        this.releaseYear = movieDTO.getReleaseYear();
        this.genres = movieDTO.getGenres();
        this.director = movieDTO.getDirector();
        this.imdbRating = movieDTO.getImdbRating();
        this.rottenRating = movieDTO.getRottenRating();
        this.posterUrl = movieDTO.getPosterUrl();
    }
}
