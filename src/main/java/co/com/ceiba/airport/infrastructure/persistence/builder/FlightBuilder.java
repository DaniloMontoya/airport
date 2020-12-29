package co.com.ceiba.airport.infrastructure.persistence.builder;

import co.com.ceiba.airport.domain.exceptions.MandatoryValueException;
import co.com.ceiba.airport.domain.models.dto.FlightDTO;
import co.com.ceiba.airport.domain.models.entities.Flight;
import co.com.ceiba.airport.infrastructure.persistence.entities.FlightEntity;

public final class FlightBuilder {

    private static final String FLIGHTENTITY_IS_NULL = "FlightEntity es null";
    private static final String FLIGHT_IS_NULL = "Flight es null";

    private FlightBuilder(){}

    public static Flight convertToDomain(FlightEntity flightEntity){
        Flight flight;
        if(flightEntity != null){
            flight = new Flight(
                    flightEntity.getId(),
                    flightEntity.getTimeDeparture(),
                    flightEntity.getArrival(),
                    flightEntity.getCost(),
                    flightEntity.isReprogrammed());
        }else{
            throw new MandatoryValueException(FLIGHTENTITY_IS_NULL);
        }
        return flight;

    }

    public static FlightEntity convertToEntity(Flight flight){
        FlightEntity flightEntity = new FlightEntity();
        if(flight != null) {
            flightEntity.setId(flight.getId());
            flightEntity.setTimeDeparture(flight.getTimeDeparture());
            flightEntity.setArrival(flight.getArrival());
            flightEntity.setCost(flight.getCost());
            flightEntity.setReprogrammed(flight.isReprogrammed());
        }else{
            throw new MandatoryValueException(FLIGHT_IS_NULL);
        }
        return flightEntity;
    }

    public static FlightDTO convertToDTO(Flight flight){
        FlightDTO flightDTO;
        if(flight != null){
            flightDTO = new FlightDTO(
                    flight.getId(),
                    flight.getTimeDeparture(),
                    flight.getArrival(),
                    flight.getCost(),
                    flight.isReprogrammed());
        }else{
            throw new MandatoryValueException(FLIGHT_IS_NULL);
        }
        return flightDTO;
    }
}
