package co.com.ceiba.airport.application.command.handler;

import co.com.ceiba.airport.application.command.CommandHandler;
import co.com.ceiba.airport.application.command.FlightCommand;
import co.com.ceiba.airport.application.command.fabric.FlightFabric;
import co.com.ceiba.airport.domain.models.entities.Flight;
import co.com.ceiba.airport.domain.services.UpdateFlightService;
import org.springframework.stereotype.Component;

@Component
public class UpdateFlightHandler implements CommandHandler<FlightCommand> {

    private final FlightFabric flightFabric;
    private final UpdateFlightService updateFlightService;

    public UpdateFlightHandler(FlightFabric flightFabric, UpdateFlightService updateFlightService) {
        this.flightFabric = flightFabric;
        this.updateFlightService = updateFlightService;
    }

    @Override
    public void run(FlightCommand flightCommand) {
        Flight flight = this.flightFabric.create(flightCommand);
        this.updateFlightService.run(flight);
    }
}
