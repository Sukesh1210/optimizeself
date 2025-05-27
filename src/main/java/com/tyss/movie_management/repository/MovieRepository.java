package com.tyss.movie_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tyss.movie_management.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer>{
	
	

}
