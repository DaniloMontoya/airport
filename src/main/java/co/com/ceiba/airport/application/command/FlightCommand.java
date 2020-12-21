package co.com.ceiba.airport.application.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FlightCommand {
    private String id;
    private long time;
    private String arrival;
    private float cost;
    private boolean isReprogrammed;
}
