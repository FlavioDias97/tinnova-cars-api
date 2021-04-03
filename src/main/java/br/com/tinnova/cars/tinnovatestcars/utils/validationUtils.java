package br.com.tinnova.cars.tinnovatestcars.utils;

import br.com.tinnova.cars.tinnovatestcars.dto.request.CarRequestDTO;

public class validationUtils {
	
	
	public boolean validateCreateRequest(CarRequestDTO car) {
		
		if(car.getSolded().toString().isEmpty() || car.getBrand().toString().isEmpty() || car.getDescription().toString().isEmpty() || car.getModel().toString().isEmpty() || car.getYear() == 0) {
			return true;
		}
		
		return false;
	}
	
	public boolean validadeUpdateRequest(Long Id,CarRequestDTO car) {
		if(Id <= 0) {
			return true; 
		}else if (validateCreateRequest(car)) {
			return true;
		}
		
		return false;
	}
	
	public boolean validadeIdRequest(Long Id) {
		if(Id <= 0) {
			return true; 
		}
		return false;
	}

}
