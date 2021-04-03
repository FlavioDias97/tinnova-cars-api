package br.com.tinnova.cars.tinnovatestcars.dto.response;

import java.util.List;

import br.com.tinnova.cars.tinnovatestcars.model.Car;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LastCarRecordResponseDTO {
 
    private List<Car> cars;
}
