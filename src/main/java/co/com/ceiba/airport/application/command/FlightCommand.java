package co.com.ceiba.airport.application.command;

import co.com.ceiba.airport.domain.models.dto.ArrivalDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FlightCommand {
    private Long id;
    private long time;
    private ArrivalDTO arrivalDTO;
    private float cost;
    private boolean isReprogrammed;
}
