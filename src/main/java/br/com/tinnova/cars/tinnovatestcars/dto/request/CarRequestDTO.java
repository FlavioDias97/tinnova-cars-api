package br.com.tinnova.cars.tinnovatestcars.dto.request;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarRequestDTO {

    private String model;
    private String brand;
    private int year;
    private String description;
    private Boolean solded;
    private Date createdAt;
    private Date updatedAt;
    
}
