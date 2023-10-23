package com.negreira.santiago.movieapi.dtos;

import com.negreira.santiago.movieapi.entities.Movie;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MovieDTO {
	private Long id;
    private String title;
    private String originInfo;
    private Integer releaseYear;
    private String genres;
    private String director;
    private Double imdbRating;
    private Double rottenRating;
    private String posterUrl;
    
    public MovieDTO(Movie entity) {
    	id = entity.getId();
    	title = entity.getTitle();
    	originInfo = entity.getOriginInfo();
    	releaseYear = entity.getReleaseYear();
    	genres = entity.getGenres();
    	director = entity.getDirector();
    	imdbRating = entity.getImdbRating();
    	rottenRating = entity.getRottenRating();
    	posterUrl = entity.getPosterUrl();
    }

}
