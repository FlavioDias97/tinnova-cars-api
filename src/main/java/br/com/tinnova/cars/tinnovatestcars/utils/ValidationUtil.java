package br.com.tinnova.cars.tinnovatestcars.utils;

import br.com.tinnova.cars.tinnovatestcars.dto.request.CarRequestDTO;

public class ValidationUtil {
	
	
	public boolean validateCreateRequest(CarRequestDTO car) {
		
		if(car.getBrand().isEmpty() || car.getDescription().isEmpty() || car.getModel().isEmpty() || car.getYear() == 0) {
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
