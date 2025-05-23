package com.tyss.movie_management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
@Entity
@Table(name="financials")
public class Financial {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer financialId;
	private Double budget;
	private Double revenue;
	private Unit unit;
	private Currency currency;
	
	 @OneToOne
	    @JoinColumn(name = "movie_id")
	    private Movie movie;


}
