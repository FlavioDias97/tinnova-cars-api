package br.com.tinnova.cars.tinnovatestcars.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import br.com.tinnova.cars.tinnovatestcars.dto.request.CarRequestDTO;

@RunWith(SpringRunner.class)
@WebMvcTest(CarController.class)
public class CarControllerTest {
	
	private final String API_PREFIX = "/api/v1";
	
	private final String INVALID_CREATE_JSON = "";
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void wheTryToCreateNewCarAndRequestIsInvalidShoudReturnBadRequest() throws Exception {
		
		CarRequestDTO invalidRequest = CarRequestDTO.builder().build();
		
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
				.post(API_PREFIX)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(INVALID_CREATE_JSON);
		
		mockMvc
		.perform(request)
		.andExpect(status().isBadRequest());
		
		
	}
	
	@Test
	public void wheTryToUpdateCarAndRequestIsInvalidShoudReturnBadRequest() throws Exception {
		
		CarRequestDTO invalidRequest = CarRequestDTO.builder().build();
		
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
				.put(API_PREFIX + "/0")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(INVALID_CREATE_JSON);
		
		mockMvc
		.perform(request)
		.andExpect(status().isBadRequest());
		
	}
	
	@Test
	public void wheTryToDeleteCarAndRequestIsInvalidShoudReturnBadRequest() throws Exception {
		
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
				.delete(API_PREFIX + "/0")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(INVALID_CREATE_JSON);
		
		mockMvc
		.perform(request)
		.andExpect(status().isBadRequest());
		
	}
	
	@Test
	public void wheTryToGetAnyCarByAndRequestIsInvalidShoudReturnBadRequest() throws Exception {
		
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
				.get(API_PREFIX + "/0")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(INVALID_CREATE_JSON);
		
		mockMvc
		.perform(request)
		.andExpect(status().isBadRequest());
		
	}

}
