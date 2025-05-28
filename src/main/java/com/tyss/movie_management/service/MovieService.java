package com.tyss.movie_management.service;

import com.tyss.movie_management.dto.MovieDTO;

public interface MovieService {

	MovieDTO addMovie(MovieDTO movieDTO);
	
	MovieDTO getMovie(Integer movieId);

}
