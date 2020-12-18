package co.com.ceiba.airport.domain.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ArrivalDTO {

    private Long id;
    private String name;
    private float latitude;
    private float lenght;
}
