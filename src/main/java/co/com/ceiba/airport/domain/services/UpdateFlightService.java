package co.com.ceiba.airport.domain.services;

import co.com.ceiba.airport.domain.exceptions.DuplicityValueException;
import co.com.ceiba.airport.domain.models.entities.Flight;
import co.com.ceiba.airport.domain.exceptions.InvalidTimeException;
import co.com.ceiba.airport.domain.ports.repositories.FlightRepository;

import java.util.List;

public class UpdateFlightService {

    private static final String THE_FLIGHT_DOESNOT_EXIST = "The flight does not exist";
    private static final String THE_FLIGHT_TIME_IS_INVALID_IN_THE_CALENDAR = "The flight time is invalid in the calendar";
    private static final long FIVE_MINUTE_UNIXTIMESTAMP = 300;
    private final FlightRepository flightRepository;

    public UpdateFlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public void run(Flight flight){
        validatePreviousExist(flight);
        validateTimeCalendar(flight.getTime());
        this.flightRepository.updateFlight(flight);
    }

    private void validatePreviousExist(Flight flight) {
        if(!this.flightRepository.isExiste(flight.getId())){
            throw new DuplicityValueException(THE_FLIGHT_DOESNOT_EXIST);
        }
    }

    private void validateTimeCalendar(long time) {
        boolean isValid = true;
        long low = time - FIVE_MINUTE_UNIXTIMESTAMP;
        long high = time + FIVE_MINUTE_UNIXTIMESTAMP;
        List<Flight> flightList = flightRepository.getAllFlight();
        for(Flight flight : flightList){
            if (flight.getTime() > low && flight.getTime() < high){
                isValid = false;
                break;
            }
        }
        if(!isValid){
            throw new InvalidTimeException(THE_FLIGHT_TIME_IS_INVALID_IN_THE_CALENDAR);
        }
    }
}
