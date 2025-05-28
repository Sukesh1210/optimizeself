package com.tyss.movie_management.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.movie_management.dto.MovieDTO;
import com.tyss.movie_management.response.SuccessResponse;
import com.tyss.movie_management.service.MovieService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/movie")
public class MovieController {
	private final MovieService movieService;

//	@GetMapping(path = "/dummy")
//	public Object dummy() {
//		return MovieDTO.builder().languageDTO(LanguageDTO.builder().build())
//				.financialDTO(FinancialDTO.builder().build()).actorDTO(List.<ActorDTO>of(ActorDTO.builder().build()))
//				.build();
//	}

	@PostMapping(path = "/addMovie")
	public ResponseEntity<SuccessResponse> addMovie(@RequestBody MovieDTO movieDTO) {
		MovieDTO title = movieService.addMovie(movieDTO);
		return ResponseEntity.ofNullable(
				SuccessResponse.builder().message("Created Successfully")
				.data(movieDTO).status(HttpStatus.CREATED).timestamp(LocalDateTime.now()).build());

	}
	
	@GetMapping(path="/getMovie")
	public ResponseEntity<SuccessResponse> getMovie(@RequestParam Integer movieId) {
		MovieDTO movieDTO = movieService.getMovie(movieId);
		return ResponseEntity.ofNullable(
				SuccessResponse.builder().message("Fetch Successfully")
				.data(movieDTO).status(HttpStatus.FOUND).timestamp(LocalDateTime.now()).build());
	}

}
