package com.tyss.movie_management.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
@AllArgsConstructor
@Data
@Entity
@Builder
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
    
    @JoinTable(
            name = "movie_actor",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Actor> actor;
    
    @OneToOne(mappedBy = "movie", cascade = CascadeType.ALL)
    private Financial financial;
    
    //Cascade helps manage related entities automatically
    
    
    @JoinColumn(name = "language_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Language language;
    

}
