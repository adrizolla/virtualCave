package com.ecommerce.api.ecommerceApiLauncher.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.api.ecommerceApiLauncher.model.Rate;
import com.ecommerce.api.ecommerceApiLauncher.repository.RateRepository;

@Service
public class RateService {
	
	@Autowired
	private RateRepository repository;

	    public List<Rate> findAll() {
	        return repository.findAll();
	    }
	    
	    public Optional<Rate> findById(Long id) {
	        return repository.findById(id);
	    }
	    
	    public Rate create(Rate rate) {
	        return repository.save(rate);
	    }
	    
	    public void deleteById(long id) {
	         repository.deleteById(id);
	    }
	    
	    public Optional<Rate> findByColumns(long brandId,long productId,LocalDate date) {
	        return repository.findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(brandId, productId,date,date);
	    }
}
