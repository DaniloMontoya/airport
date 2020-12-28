package co.com.ceiba.airport.domain.services;

import co.com.ceiba.airport.domain.exceptions.InvalidTimeException;
import co.com.ceiba.airport.domain.exceptions.NotExistException;
import co.com.ceiba.airport.domain.models.entities.Flight;
import co.com.ceiba.airport.domain.ports.repositories.FlightRepository;
import co.com.ceiba.airport.domain.services.currentdate.GetCurrentDate;
import co.com.ceiba.airport.domain.validators.ValidateExistence;

import java.time.LocalDateTime;

public class DeleteFlightService {

    private static final String THE_FLIGHT_DOESNOT_EXIST = "El vuelo a eliminar no existe.";
    private static final String NOT_POSSIBLE_DELETE_FLIGHT_FOR_LIMIT_DATE = "No es posible eliminar este vuelo porque está programado dentro del rango de un año.";
    private static final int LIMIT_IN_YEAR_FOR_DELETE = 1;

    private final FlightRepository flightRepository;
    private final ValidateExistence validateExistence;
    private final GetCurrentDate getCurrentDate;

    public DeleteFlightService(FlightRepository flightRepository, ValidateExistence validateExistence, GetCurrentDate getCurrentDate) {
        this.flightRepository = flightRepository;
        this.validateExistence = validateExistence;
        this.getCurrentDate = getCurrentDate;
    }

    public void run(String id){
        validateExist(id);
        validateMinOneYear(id);
        this.flightRepository.deleteFlight(id);
    }

    private void validateMinOneYear(String id) {
        LocalDateTime currentDate = this.getCurrentDate.getCurrentDate();
        Flight flight = this.flightRepository.getFlight(id);
        if(flight.getTimeDeparture().isBefore(currentDate.plusYears(LIMIT_IN_YEAR_FOR_DELETE))){
            throw new InvalidTimeException(NOT_POSSIBLE_DELETE_FLIGHT_FOR_LIMIT_DATE);
        }

    }

    private void validateExist(String id) {
        if(!this.validateExistence.isExist(id))
            throw new NotExistException(THE_FLIGHT_DOESNOT_EXIST);
    }
}
