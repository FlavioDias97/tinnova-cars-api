package br.com.tinnova.cars.tinnovatestcars.service;

import java.util.List;

import com.google.common.base.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.tinnova.cars.tinnovatestcars.dto.request.CarRequestDTO;
import br.com.tinnova.cars.tinnovatestcars.dto.response.BrandAmountResponseDTO;
import br.com.tinnova.cars.tinnovatestcars.dto.response.CarsByDecadeResponseDTO;
import br.com.tinnova.cars.tinnovatestcars.dto.response.LastCarRecordResponseDTO;
import br.com.tinnova.cars.tinnovatestcars.dto.response.NotSoldedResponseDTO;
import br.com.tinnova.cars.tinnovatestcars.model.Car;


public interface ICarService {

    public String createCar(CarRequestDTO car);
    public ResponseEntity deleteCar(Long id);
    public ResponseEntity updateCar(CarRequestDTO car, Long id);
    public String updateCarQuery(CarRequestDTO car, Long id);

    public ResponseEntity getCarById(Long id);
    public List<Car> getAllCars();

    public NotSoldedResponseDTO notSoldedAmount();
    public BrandAmountResponseDTO filteredByBrandAmount();
    public CarsByDecadeResponseDTO filteredByDecade();
    public LastCarRecordResponseDTO getLastRecord();
            
}
