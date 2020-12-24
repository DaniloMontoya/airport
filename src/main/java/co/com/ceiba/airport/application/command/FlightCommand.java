package co.com.ceiba.airport.application.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FlightCommand {

    private String id;

    @NotNull(message = "Time is mandatory")
    private LocalDateTime timeDeparture;

    @NotBlank(message = "Arrival is mandatory")
    private String arrival;

    @NotNull(message = "Cost is mandatory")
    @Min(0)
    private float cost;

    private boolean isReprogrammed;
}
