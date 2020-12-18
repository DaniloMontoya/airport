package co.com.ceiba.airport.application.command.handler;

import co.com.ceiba.airport.application.command.CommandResponse;
import co.com.ceiba.airport.application.command.CommandResponseHandler;
import co.com.ceiba.airport.application.command.FlightCommand;
import co.com.ceiba.airport.application.command.fabric.FlightFabric;
import co.com.ceiba.airport.domain.models.entities.Flight;
import co.com.ceiba.airport.domain.services.CreateFlightService;
import org.springframework.stereotype.Component;

@Component
public class CreateFlighHandler implements CommandResponseHandler<FlightCommand, CommandResponse<Long>> {

    private final FlightFabric flightFabric;
    private final CreateFlightService createFlightService;

    public CreateFlighHandler(FlightFabric flightFabric, CreateFlightService createFlightService) {
        this.flightFabric = flightFabric;
        this.createFlightService = createFlightService;
    }

    @Override
    public CommandResponse<Long> run(FlightCommand command) {
        Flight flight = this.flightFabric.create(command);
        return new CommandResponse<>(this.createFlightService.run(flight));
    }
}
