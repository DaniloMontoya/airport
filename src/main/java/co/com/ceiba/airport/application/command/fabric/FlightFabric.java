package co.com.ceiba.airport.application.command.fabric;

import co.com.ceiba.airport.application.command.FlightCommand;
import co.com.ceiba.airport.domain.models.entities.Flight;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Component
public class FlightFabric {

    public Flight create(FlightCommand flightCommand){
        return new Flight(
                generateFlightId(flightCommand.getTimeDeparture(), flightCommand.getArrival(), flightCommand.isReprogrammed(), flightCommand.getId()),
                flightCommand.getTimeDeparture(),
                flightCommand.getArrival(),
                recalculateCost(flightCommand.getCost(), flightCommand.getTimeDeparture(), flightCommand.isReprogrammed()),
                flightCommand.isReprogrammed()
        );
    }

    private String generateFlightId(LocalDateTime localDateTime, String arrival, boolean isReprogrammed, String id) {
        String newID;
        if (isReprogrammed) {
            newID = id;
        }else {
            newID = arrival + "-" + localDateTime.atZone(ZoneId.of("UTC")).toInstant().toEpochMilli()/1000;
        }
        return newID;
    }

    private float recalculateCost(float cost, LocalDateTime localDateTime, boolean isReprogramed){
        float costInWeekend = cost;
        if(!isReprogramed) {
            if (localDateTime.getDayOfWeek() == DayOfWeek.SATURDAY || localDateTime.getDayOfWeek() == DayOfWeek.SUNDAY) {
                costInWeekend = cost + cost * 0.1f;
            }
        }
        return costInWeekend;
    }

}
