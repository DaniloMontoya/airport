package co.com.ceiba.airport.domain.services;

import co.com.ceiba.airport.domain.exceptions.NotExistException;
import co.com.ceiba.airport.domain.models.entities.Flight;
import co.com.ceiba.airport.domain.exceptions.InvalidTimeException;
import co.com.ceiba.airport.domain.ports.repositories.FlightRepository;

public class UpdateFlightService {

    private static final String THE_FLIGHT_DOESNOT_EXIST = "The flight does not exist";
    private static final String THE_FLIGHT_TIME_IS_INVALID_IN_THE_CALENDAR = "The flight time is invalid in the calendar";
    private final FlightRepository flightRepository;

    public UpdateFlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public void run(Flight flight){
        validatePreviousExist(flight);
        validateTimeCalendar(flight.getTimeDeparture());
        this.flightRepository.updateFlight(flight);
    }

    private void validatePreviousExist(Flight flight) {
        if(!this.flightRepository.isExiste(flight.getId())){
            throw new NotExistException(THE_FLIGHT_DOESNOT_EXIST);
        }
    }

    private void validateTimeCalendar(long time) {
        if(!flightRepository.isValidateTime(time)){
            throw new InvalidTimeException(THE_FLIGHT_TIME_IS_INVALID_IN_THE_CALENDAR);
        }
    }
}
