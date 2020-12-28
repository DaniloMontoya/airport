package co.com.ceiba.airport.domain.services;

import co.com.ceiba.airport.domain.exceptions.DuplicityValueException;
import co.com.ceiba.airport.domain.exceptions.InvalidTimeException;
import co.com.ceiba.airport.domain.models.entities.Flight;
import co.com.ceiba.airport.domain.ports.repositories.FlightRepository;
import co.com.ceiba.airport.domain.validators.ValidateCalendar;
import co.com.ceiba.airport.domain.validators.ValidateExistence;

import java.time.LocalDateTime;


public class CreateFlightService {

    private static final String THE_FLIGHT_ALREADY_EXIST = "El vuelo ya existe";
    private static final String THE_FLIGHT_TIME_IS_INVALID_IN_THE_CALENDAR = "La hora a la que se programó el vuelo es inválida";

    private final FlightRepository flightRepository;
    private final ValidateExistence validateExistence;
    private final ValidateCalendar validateCalendar;

    public CreateFlightService(FlightRepository flightRepository, ValidateExistence validateExistence, ValidateCalendar validateCalendar) {
        this.flightRepository = flightRepository;
        this.validateExistence = validateExistence;
        this.validateCalendar = validateCalendar;
    }

    public String run(Flight flight) {
        validatePreviousExistence(flight.getId());
        validateTimeCalendar(flight.getTimeDeparture());
        return this.flightRepository.createFlight(flight);
    }

    public void validatePreviousExistence(String id){
        if(this.validateExistence.isExist(id)){
            throw new DuplicityValueException(THE_FLIGHT_ALREADY_EXIST);
        }
    }

    public void validateTimeCalendar(LocalDateTime localDateTime){
        if(!this.validateCalendar.isValidDateDepartures(localDateTime)){
            throw new InvalidTimeException(THE_FLIGHT_TIME_IS_INVALID_IN_THE_CALENDAR);
        }
    }
}
