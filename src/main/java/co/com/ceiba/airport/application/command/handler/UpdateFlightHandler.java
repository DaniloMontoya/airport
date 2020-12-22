package co.com.ceiba.airport.application.command.handler;

import co.com.ceiba.airport.application.command.FlightCommand;
import co.com.ceiba.airport.application.command.fabric.FlightFabric;
import co.com.ceiba.airport.domain.models.entities.Flight;
import co.com.ceiba.airport.domain.services.UpdateFlightService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UpdateFlightHandler {

    private final FlightFabric flightFabric;
    private final UpdateFlightService updateFlightService;

    public UpdateFlightHandler(FlightFabric flightFabric, UpdateFlightService updateFlightService) {
        this.flightFabric = flightFabric;
        this.updateFlightService = updateFlightService;
    }

    @Transactional
    public void run(FlightCommand flightCommand) {
        flightCommand.setReprogrammed(true);
        Flight flight = this.flightFabric.create(flightCommand);
        this.updateFlightService.run(flight);
    }
}
