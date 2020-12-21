package co.com.ceiba.airport.application.command.fabric;

import co.com.ceiba.airport.application.command.FlightCommand;
import co.com.ceiba.airport.domain.models.entities.Flight;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class FlightFabric {

    public Flight create(FlightCommand flightCommand){
        return new Flight(
                generateFlightId(flightCommand.getTime(), flightCommand.getArrival()),
                flightCommand.getTime(),
                flightCommand.getArrival(),
                flightCommand.getCost(),
                flightCommand.isReprogrammed()
        );
    }

    private String generateFlightId(long time, String arrival) {
        return arrival + "-" + time;
    }

}
