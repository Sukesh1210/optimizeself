package com.tyss.movie_management.service;

import org.springframework.stereotype.Service;

import com.tyss.movie_management.dto.MovieDTO;
import com.tyss.movie_management.entity.Movie;
import com.tyss.movie_management.repository.MovieRepository;
import com.tyss.movie_management.utils.MovieUtils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MovieServiceImpl implements MovieService {

	private final MovieUtils  movieUtils;
	private final MovieRepository movieRepository;
	
	@Override
	public MovieDTO addMovie(MovieDTO movieDTO) {
		Movie movie = movieUtils.movieDtoToMovie(movieDTO);
		movieRepository.saveAndFlush(movie);
		return movieDTO;
		
	}

}
