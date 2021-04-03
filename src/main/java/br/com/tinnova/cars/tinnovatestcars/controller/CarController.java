package br.com.tinnova.cars.tinnovatestcars.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tinnova.cars.tinnovatestcars.dto.request.CarRequestDTO;
import br.com.tinnova.cars.tinnovatestcars.dto.response.BrandAmountResponseDTO;
import br.com.tinnova.cars.tinnovatestcars.dto.response.CarsByDecadeResponseDTO;
import br.com.tinnova.cars.tinnovatestcars.dto.response.LastCarRecordResponseDTO;
import br.com.tinnova.cars.tinnovatestcars.dto.response.NotSoldedResponseDTO;
import br.com.tinnova.cars.tinnovatestcars.model.Car;
import br.com.tinnova.cars.tinnovatestcars.service.ICarService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/v1")
@Api(value = "Cars api")
public class CarController implements Serializable{

    @Autowired
    ICarService service;

    /**
     *
     */
    private static final long serialVersionUID = 2247110006816565763L;

    @PostMapping
    @ApiOperation(value = "Creates a new car")
    public ResponseEntity<?> create(
        @RequestBody CarRequestDTO car
    ){

        try{
            service.createCar(car);
            return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>("Error while persist car" + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{id}")
    @ApiOperation(value = "Updates an existing car")
    public ResponseEntity<?> update(
        @PathVariable Long id,
        @RequestBody CarRequestDTO car
    ){
        try{
            return service.updateCar(car, id);
        }catch(Exception e){
            return new ResponseEntity<>("Error while update a car" + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    // update using query/PATH

    
    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Delete any car by ID")
    public ResponseEntity<?> delete(
        @PathVariable Long id
    ){
        try{
            return service.deleteCar(id);
        }catch(Exception e){
            return new ResponseEntity<>("Error while delete a car" + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
	@GetMapping(value = "/{id}")
    @ApiOperation(value = "Returns any car information by ID")
    public ResponseEntity<?> getCarById(
        @PathVariable Long id
    ){
        try{
            return service.getCarById(id);
        }catch(Exception e){
            return new ResponseEntity<>("Error while get a car by Id" + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    
	@GetMapping
    @ApiOperation(value = "Returns all cars from database")
    public ResponseEntity<List<Car>> getAllCars(){

        try{
            return new ResponseEntity<>(service.getAllCars(), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    
	@GetMapping(value = "/notSoldedCars")
    @ApiOperation(value = "Returns all cars not solded from database")
    public ResponseEntity<NotSoldedResponseDTO> getNotSoldedCars(){

       
        return new ResponseEntity<>(service.notSoldedAmount(), HttpStatus.OK);
           

    }

    @GetMapping(value = "/carsFilteredByDecade")
    @ApiOperation(value = "Returns the amount of cars filtered by date")
    public ResponseEntity<CarsByDecadeResponseDTO> getCarsFilteredByDate(){

        return new ResponseEntity<>(service.filteredByDecade(), HttpStatus.OK);
    }

    @GetMapping(value = "/carsRegisteredLastWeek")
    @ApiOperation(value = "Returns the amount of cars registered in last week")
    public ResponseEntity<LastCarRecordResponseDTO> getCarsFilteredByLastWeek(){

        return new ResponseEntity<>(service.getLastRecord(), HttpStatus.OK);
    }
    

    @GetMapping(value = "/carsFilteredByBrand")
    @ApiOperation(value = "Returns the amount of cars filtered by brand")
    public ResponseEntity<BrandAmountResponseDTO> getCarsFilteredByBrand(){

        return new ResponseEntity<>(service.filteredByBrandAmount(), HttpStatus.OK);
    }
}
