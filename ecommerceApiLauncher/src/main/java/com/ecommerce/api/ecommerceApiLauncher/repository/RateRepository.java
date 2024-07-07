package com.ecommerce.api.ecommerceApiLauncher.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.ecommerce.api.ecommerceApiLauncher.model.Rate;

public interface RateRepository extends JpaRepository<Rate,Long> {

	Optional<Rate> findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(Long productId, Long brandId, LocalDate date,LocalDate date2);
	
	 
	}