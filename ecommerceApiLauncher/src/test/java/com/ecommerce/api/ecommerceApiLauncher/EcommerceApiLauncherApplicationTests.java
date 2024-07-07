package com.ecommerce.api.ecommerceApiLauncher;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import static org.mockito.BDDMockito.given;

import com.ecommerce.api.ecommerceApiLauncher.controller.*;
import com.ecommerce.api.ecommerceApiLauncher.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
class EcommerceApiLauncherApplicationTests {

	@Test
	void contextLoads() {
	}
	   @Autowired
	    private MockMvc mockMvc;

	    @MockBean
	    private RateService service;

	    @Test
	    public void testGetRates() throws Exception {
	        
	        given(service.findAll()).willReturn(List.of());
	        mockMvc.perform(get("/all"))
	                .andExpect(status().isOk());
	    }
}
