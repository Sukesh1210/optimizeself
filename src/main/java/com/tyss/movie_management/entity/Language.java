package com.tyss.movie_management.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Entity
@Table(name="languages")
public class Language {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer languageId;
	private String languageName;
	
	
	@OneToMany(mappedBy = "language")
    private List<Movie> movie;

}
