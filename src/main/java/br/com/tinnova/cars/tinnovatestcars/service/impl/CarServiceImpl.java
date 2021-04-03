package br.com.tinnova.cars.tinnovatestcars.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.tinnova.cars.tinnovatestcars.dto.request.CarRequestDTO;
import br.com.tinnova.cars.tinnovatestcars.dto.response.BrandAmountResponseDTO;
import br.com.tinnova.cars.tinnovatestcars.dto.response.CarsByDecadeResponseDTO;
import br.com.tinnova.cars.tinnovatestcars.dto.response.LastCarRecordResponseDTO;
import br.com.tinnova.cars.tinnovatestcars.dto.response.NotSoldedResponseDTO;
import br.com.tinnova.cars.tinnovatestcars.model.Car;
import br.com.tinnova.cars.tinnovatestcars.repository.ICarRepository;
import br.com.tinnova.cars.tinnovatestcars.service.ICarService;

@Service
public class CarServiceImpl implements ICarService{

    @Autowired
    ICarRepository repository;
    
    public String createCar(CarRequestDTO car) {
        
        Car carModel = Car.builder()
        .model(car.getModel())
        .brand(car.getBrand())
        .description(car.getDescription())
        .isSolded(car.getSolded())
        .year(car.getYear())
        .createdAt(car.getCreatedAt())
        .updatedAt(car.getUpdatedAt())
        .build();

        repository.save(carModel);

        return null;
    }
    
    public ResponseEntity deleteCar(Long id) {
        return repository.findById(id)
                .map(
                    record -> {
                        repository.deleteById(id);    
                        return ResponseEntity.ok().build();
                    }
                ).orElse(ResponseEntity.notFound().build());
    }
    
    public ResponseEntity updateCar(CarRequestDTO car, Long id) {
        return repository.findById(id)
                .map(record -> {
                    record.setModel(car.getModel());
                    record.setBrand(car.getBrand());
                    record.setDescription(car.getDescription());
                    record.setSolded(car.getSolded());
                    record.setYear(car.getYear());                   
                    record.setUpdatedAt(car.getUpdatedAt());
                    Car carUpdated = repository.save(record);
                    return ResponseEntity.ok().body(carUpdated);
                }).orElse(ResponseEntity.notFound().build());
        
    }
    
    public String updateCarQuery(CarRequestDTO car, Long id) {
        // TODO Auto-generated method stub
        return null;
    }
    
    public ResponseEntity getCarById(Long id) {
       return repository.findById(id)
                .map(
                    record -> ResponseEntity.ok().body(record))
                    .orElse(ResponseEntity.notFound().build());
                
    }
    
    public List<Car> getAllCars() {
        return repository.findAll();
    }
    
    public NotSoldedResponseDTO notSoldedAmount() {

        return NotSoldedResponseDTO.builder()
        .amountNotSolded(
            repository.findCountAllCarsNotSould()        		
        ).build();

    }
    
    public BrandAmountResponseDTO filteredByBrandAmount() {
        return BrandAmountResponseDTO.builder()
                .listCarByBrand(
                    repository.findCarsFilteredByBrand()
                ).build();
    }
    
    public CarsByDecadeResponseDTO filteredByDecade() {
        return CarsByDecadeResponseDTO.builder()
                .carsByDecade(
                    repository.findCarsFilteredByDecade()
                ).build();
    }
    
    public LastCarRecordResponseDTO getLastRecord() {
        return LastCarRecordResponseDTO.builder()
                .cars(
                    repository.findAllCarsRegisteredInWeek()
                ).build();
    }
    
}
