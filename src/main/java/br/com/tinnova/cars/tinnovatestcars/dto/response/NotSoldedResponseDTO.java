package br.com.tinnova.cars.tinnovatestcars.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NotSoldedResponseDTO {

    private int amountNotSolded;
    
}
