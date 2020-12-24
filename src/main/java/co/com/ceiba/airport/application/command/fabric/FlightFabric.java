package co.com.ceiba.airport.application.command.fabric;

import co.com.ceiba.airport.application.command.FlightCommand;
import co.com.ceiba.airport.domain.models.entities.Flight;
import org.springframework.stereotype.Component;

@Component
public class FlightFabric {

    public Flight create(FlightCommand flightCommand){
        return new Flight(
                flightCommand.getId(),
                flightCommand.getTimeDeparture(),
                flightCommand.getArrival(),
                flightCommand.getCost(),
                flightCommand.isReprogrammed()
        );
    }
}
