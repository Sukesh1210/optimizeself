package com.tyss.movie_management.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
public class Movie {
    private Integer imdbRating;
    private String industry;
    private Integer releaseYear;
    private String studio;
    private String title;
}
