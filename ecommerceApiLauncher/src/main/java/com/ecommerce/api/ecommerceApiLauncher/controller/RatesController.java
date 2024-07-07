package com.ecommerce.api.ecommerceApiLauncher.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ecommerce.api.ecommerceApiLauncher.model.Rate;
import com.ecommerce.api.ecommerceApiLauncher.repository.RateRepository;
import com.ecommerce.api.ecommerceApiLauncher.service.RateService;

@RestController
public class RatesController {

	@Autowired
	private RateService service;

	@GetMapping("/all")
	public List<Rate> getRates() {
		return service.findAll();
	}

	@GetMapping("find/{id}")
	public String getById(@PathVariable long id) {
		Optional<Rate> rate = service.findById(id);
		if (rate.isEmpty()) {
			throw new ResourceNotFoundException("Rate not found with id " + id + ", specify another value");
		}
		Rate iRate = rate.get();
		return iRate.getPrice() + " " + iRate.getCurrencyCode();
	}
	
	
	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/create")
	public ResponseEntity<String> createRate(@RequestBody Rate rate) {
		service.create(rate);	
		return ResponseEntity.ok("Rate created successfully");
	}
	
	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateRatePrice(@PathVariable long id, @RequestBody Rate rate) {
		Optional<Rate> oRate = service.findById(id);
		
		if (oRate.isEmpty()) {
			throw new ResourceNotFoundException("Rate not found with id " + id + ", specify another value");
		}		
		Rate existingRate = oRate.get();
		existingRate.setPrice(rate.getPrice());
		service.create(existingRate);
		return ResponseEntity.ok("Rate price updated successfully");
	}
	
	
	 @ResponseStatus(HttpStatus.NO_CONTENT) // 204
	    @DeleteMapping("delete/{id}")
	    public ResponseEntity<String> deleteById(@PathVariable Long id) {
		 service.deleteById(id);
		 return ResponseEntity.ok("Rate price deleted successfully");
	    }
	 
	 @PostMapping("/applicable-rate")
	    public Rate getApplicableRate(@RequestBody Rate rateRequest) {
	        Optional<Rate> rate = service.findByColumns(
	        		rateRequest.getBrandId(),
	            rateRequest.getProductId(),
	            rateRequest.getStartDate()   
	        );
	        return rate.orElseThrow(() -> new RuntimeException("Applicable rate not found"));
	    }
	

}
