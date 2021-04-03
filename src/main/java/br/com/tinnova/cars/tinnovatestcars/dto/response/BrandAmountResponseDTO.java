package br.com.tinnova.cars.tinnovatestcars.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BrandAmountResponseDTO {

    private List<String> listCarByBrand;
    
}
