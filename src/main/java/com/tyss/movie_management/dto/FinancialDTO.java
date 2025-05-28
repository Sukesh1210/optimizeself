package com.tyss.movie_management.dto;

import com.tyss.movie_management.entity.Currency;
import com.tyss.movie_management.entity.Unit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class FinancialDTO {
	private Double budget;
	private Double revenue;
	private Unit unit;
	private Currency currency;

}
