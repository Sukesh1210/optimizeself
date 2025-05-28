package com.tyss.movie_management.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.tyss.movie_management.dto.ActorDTO;
import com.tyss.movie_management.dto.FinancialDTO;
import com.tyss.movie_management.dto.LanguageDTO;
import com.tyss.movie_management.dto.MovieDTO;
import com.tyss.movie_management.entity.Actor;
import com.tyss.movie_management.entity.Financial;
import com.tyss.movie_management.entity.Language;
import com.tyss.movie_management.entity.Movie;

@Component
public class MovieUtils {
	public static Movie movieDtoToMovie(MovieDTO movieDTO) {
		Movie movie = Movie
				.builder().title(movieDTO.getTitle()).studio(movieDTO.getStudio()).industry(
						movieDTO.getIndustry())
				.imdbRating(movieDTO.getImdbRating()).releaseYear(movieDTO.getReleaseYear())
				.language(Language.builder().languageName(movieDTO.getLanguageDTO().getLanguageName()).build())
				.financial(movieDTO.getFinancialDTO() != null ? Financial.builder()
						.budget(movieDTO.getFinancialDTO().getBudget()).revenue(movieDTO.getFinancialDTO().getRevenue())
						.currency(movieDTO.getFinancialDTO().getCurrency()).unit(movieDTO.getFinancialDTO().getUnit())
						.build() : null)
				.build();

		List<Actor> actors = new ArrayList<>();

		for (ActorDTO actorDTO : movieDTO.getActorDTO()) {
			actors.add(Actor.builder().actorName(actorDTO.getActorName()).birthYear(actorDTO.getBirthYear()).build());

			movie.setActor(actors);
		}
		return movie;
	}

	public static MovieDTO movieToMovieDTO(Movie movie) {
		MovieDTO movieDTO = MovieDTO.builder().title(movie.getTitle()).studio(movie.getStudio())
				.industry(movie.getIndustry()).imdbRating(movie.getImdbRating()).releaseYear(movie.getReleaseYear())
				.languageDTO(LanguageDTO.builder().languageName(movie.getLanguage().getLanguageName()).build())

				.financialDTO(
						movie.getFinancial() != null ? FinancialDTO.builder().budget(movie.getFinancial().getBudget())
								.revenue(movie.getFinancial().getRevenue()).currency(movie.getFinancial().getCurrency())
								.unit(movie.getFinancial().getUnit()).build() : null)
				.build();

		List<ActorDTO> actorDTOs = new ArrayList<>();

		for (Actor actor : movie.getActor()) {
			actorDTOs.add(ActorDTO.builder().actorName(actor.getActorName()).birthYear(actor.getBirthYear()).build());

			movieDTO.setActorDTO(actorDTOs);
		}

		return movieDTO;
	}

}
