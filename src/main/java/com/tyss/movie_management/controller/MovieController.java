package com.tyss.movie_management.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.movie_management.dto.ActorDTO;
import com.tyss.movie_management.dto.FinancialDTO;
import com.tyss.movie_management.dto.LanguageDTO;
import com.tyss.movie_management.dto.MovieDTO;
import com.tyss.movie_management.response.SuccessResponse;
import com.tyss.movie_management.service.MovieService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/movie")
public class MovieController {
	private final MovieService movieService;

	@GetMapping(path = "/dummy")
	public Object dummy() {
		return MovieDTO.builder().languageDTO(LanguageDTO.builder().build())
				.financialDTO(FinancialDTO.builder().build()).actorDTO(List.<ActorDTO>of(ActorDTO.builder().build()))
				.build();
	}

	@PostMapping(path = "/addMovie")
	public ResponseEntity<SuccessResponse> addMovie(@RequestBody MovieDTO movieDTO) {

//		return new ResponseEntity<SuccessResponse>(null)
//				.ok(new SuccessResponse("movie Added", movieService.addMovie(movieDTO), HttpStatus.CREATED, LocalDateTime.now()));
//		
		return new ResponseEntity<>(
			    new SuccessResponse("Movie added", movieService.addMovie(movieDTO), HttpStatus.CREATED, LocalDateTime.now()),
			    HttpStatus.CREATED
			);

	}

}
