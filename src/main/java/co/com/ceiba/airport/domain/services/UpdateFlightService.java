package co.com.ceiba.airport.domain.services;

import co.com.ceiba.airport.domain.exceptions.NotExistException;
import co.com.ceiba.airport.domain.models.entities.Flight;
import co.com.ceiba.airport.domain.exceptions.InvalidTimeException;
import co.com.ceiba.airport.domain.ports.repositories.FlightRepository;
import co.com.ceiba.airport.domain.validators.ValidateCalendar;
import co.com.ceiba.airport.domain.validators.ValidateExistence;

import java.time.LocalDateTime;

public class UpdateFlightService {

    private static final String THE_FLIGHT_DOESNOT_EXIST = "El vuelo ha actualizar no existe.";
    private static final String THE_FLIGHT_TIME_IS_INVALID_IN_THE_CALENDAR = "No es posible actualizar el vuelo con la fecha y hora programada.";
    private final FlightRepository flightRepository;
    private final ValidateExistence validateExistence;
    private final ValidateCalendar validateCalendar;

    public UpdateFlightService(FlightRepository flightRepository, ValidateExistence validateExistence, ValidateCalendar validateCalendar) {
        this.flightRepository = flightRepository;
        this.validateExistence = validateExistence;
        this.validateCalendar = validateCalendar;
    }

    public void run(Flight flight){
        validatePreviousExist(flight);
        validateTimeCalendar(flight.getTimeDeparture());
        this.flightRepository.updateFlight(flight);
    }

    private void validatePreviousExist(Flight flight) {
        if(!this.validateExistence.isExist(flight.getId())){
            throw new NotExistException(THE_FLIGHT_DOESNOT_EXIST);
        }
    }

    private void validateTimeCalendar(LocalDateTime localDateTime) {
        if(!this.validateCalendar.isValidDateDepartures(localDateTime)){
            throw new InvalidTimeException(THE_FLIGHT_TIME_IS_INVALID_IN_THE_CALENDAR);
        }
    }
}
