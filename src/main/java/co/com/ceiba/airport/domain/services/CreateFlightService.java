package co.com.ceiba.airport.domain.services;

import co.com.ceiba.airport.domain.exceptions.DuplicityValueException;
import co.com.ceiba.airport.domain.exceptions.InvalidTimeException;
import co.com.ceiba.airport.domain.models.entities.Flight;
import co.com.ceiba.airport.domain.ports.repositories.FlightRepository;

public class CreateFlightService {

    private static final String THE_FLIGHT_ALREADY_EXIST = "The flight already exist";
    private static final String THE_FLIGHT_TIME_IS_INVALID_IN_THE_CALENDAR = "The flight time is invalid in the calendar";

    private final FlightRepository flightRepository;

    public CreateFlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public String run(Flight flight) {
        validatePreviousExistence(flight.getId());
        validateTimeCalendar(flight.getTimeDeparture());
        return this.flightRepository.createFlight(flight);
    }

    public void validatePreviousExistence(String id){
        if(this.flightRepository.isExiste(id)){
            throw new DuplicityValueException(THE_FLIGHT_ALREADY_EXIST);
        }
    }

    public void validateTimeCalendar(long time){
        if(!flightRepository.isValidateTime(time)){
            throw new InvalidTimeException(THE_FLIGHT_TIME_IS_INVALID_IN_THE_CALENDAR);
        }
    }
}
