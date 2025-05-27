package com.tyss.movie_management.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
public class MovieDTO {
	
    private Integer imdbRating;
    private String industry;
    private Integer releaseYear;
    private String studio;
    private String title;
    
    private List<ActorDTO> actorDTO; 
    
    private LanguageDTO languageDTO;
    
    private FinancialDTO financialDTO;
}
