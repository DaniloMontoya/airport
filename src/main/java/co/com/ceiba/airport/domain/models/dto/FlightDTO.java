package co.com.ceiba.airport.domain.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FlightDTO {
    private Long id;
    private long time;
    private String arrival;
    private float cost;
    private boolean isReprogrammed;
}
