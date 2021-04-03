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
public class CarsByDecadeResponseDTO {
    
    private List<String> carsByDecade;
}
