package com.tyss.movie_management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.util.List;
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movieId;
    private Integer imdbRating;
    private String industry;
    private Integer releaseYear;
    private String studio;
    private String title;

    @ManyToMany(mappedBy = "movies")
    private List<Actor> actors;

}
