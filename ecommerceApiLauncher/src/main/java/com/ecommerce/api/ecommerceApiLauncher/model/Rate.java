package com.ecommerce.api.ecommerceApiLauncher.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;

import java.time.LocalDate;

/*Rate Model with Constructor Getters Setters toString*/


@Entity
@Table(name = "T_RATES")
public class Rate {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "t_rates_seq")
    @SequenceGenerator(name = "t_rates_seq", sequenceName = "t_rates_seq", allocationSize = 1)
    @Column(name = "id")
	private Long id;
	
	@Column(name = "brand_id")
    private Long brandId;
	
	@Column(name = "product_id")
    private Long productId;
	
	@Column(name = "start_date")
    private LocalDate startDate;
    
	@Column(name = "end_date")
    private LocalDate endDate;
    
	@Column(name = "price")
    private Integer price;
    
	@Column(name = "currency_code")
    private String currencyCode;
    

	public Rate(Long id, Long brandId, Long productId, LocalDate startDate, LocalDate endDate, Integer price,
			String currencyCode) {
		super();
		this.id = id;
		this.brandId = brandId;
		this.productId = productId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
		this.currencyCode = currencyCode;
	}

	
	public Rate() {
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	@Override
	public String toString() {
		return "Rate [id=" + id + ", brandId=" + brandId + ", productId=" + productId + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", price=" + price + ", currencyCode=" + currencyCode + "]";
	}

	
}