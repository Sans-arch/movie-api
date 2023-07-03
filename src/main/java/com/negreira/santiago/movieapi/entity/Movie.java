package com.negreira.santiago.movieapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
    private Integer id;

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
    
    @Column
    private String posterUrl;
}
