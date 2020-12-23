package co.com.ceiba.airport.infrastructure.persistence.builder;

import co.com.ceiba.airport.domain.models.entities.Flight;
import co.com.ceiba.airport.infrastructure.persistence.entities.FlightEntity;

public final class FlightBuilder {

    private FlightBuilder(){}

    public static Flight convertToDomain(FlightEntity flightEntity){

        Flight flight = null;

        if(flightEntity != null){
            flight = new Flight(
                    flightEntity.getId(),
                    flightEntity.getTimeDeparture(),
                    flightEntity.getArrival(),
                    flightEntity.getCost(),
                    flightEntity.isReprogrammed());
        }

        return flight;

    }

    public static FlightEntity convertToEntity(Flight flight){
        FlightEntity flightEntity = new FlightEntity();
        flightEntity.setId(flight.getId());
        flightEntity.setTimeDeparture(flight.getTimeDeparture());
        flightEntity.setArrival(flight.getArrival());
        flightEntity.setCost(flight.getCost());
        flightEntity.setReprogrammed(flight.isReprogrammed());
        return flightEntity;
    }
}
