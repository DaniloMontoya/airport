package co.com.ceiba.airport.domain.services;

import co.com.ceiba.airport.domain.exceptions.DuplicityValueException;
import co.com.ceiba.airport.domain.exceptions.InvalidTimeException;
import co.com.ceiba.airport.domain.models.entities.Flight;
import co.com.ceiba.airport.domain.ports.repositories.FlightRepository;

import java.util.Optional;

public class CreateFlightService {

    private static final String THE_FLIGHT_ALREADY_EXIST = "The flight already exist";
    private static final String THE_FLIGHT_TIME_IS_INVALID_IN_THE_CALENDAR = "The flight time is invalid in the calendar";

    private final FlightRepository flightRepository;

    public CreateFlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public String run(Flight flight) {
        validatePreviousExistence(flight);
        //validateTimeCalendar(flight);
        return this.flightRepository.createFlight(flight);
    }

    private void validatePreviousExistence(Flight flight){
        boolean exist = this.flightRepository.isExiste(flight.getId());
        if(exist){
            throw new DuplicityValueException(THE_FLIGHT_ALREADY_EXIST);
        }
    }


    private void validateTimeCalendar(Flight flight) {
        boolean isValid = this.flightRepository.isValidateCalendarTime(flight.getId());
        if(!isValid) {
            throw new InvalidTimeException(THE_FLIGHT_TIME_IS_INVALID_IN_THE_CALENDAR);
        }
    }
}
