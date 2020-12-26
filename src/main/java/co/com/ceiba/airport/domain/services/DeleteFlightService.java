package co.com.ceiba.airport.domain.services;

import co.com.ceiba.airport.domain.exceptions.NotExistException;
import co.com.ceiba.airport.domain.ports.repositories.FlightRepository;
import co.com.ceiba.airport.domain.validators.ValidateExistence;

public class DeleteFlightService {

    private static final String THE_FLIGHT_DOESNOT_EXIST = "The flight does not exist";

    private final FlightRepository flightRepository;
    private final ValidateExistence validateExistence;

    public DeleteFlightService(FlightRepository flightRepository, ValidateExistence validateExistence) {
        this.flightRepository = flightRepository;
        this.validateExistence = validateExistence;
    }

    public void run(String id){
        validateExist(id);
        this.flightRepository.deleteFlight(id);
    }

    private void validateExist(String id) {
        if(!this.validateExistence.isExist(id))
            throw new NotExistException(THE_FLIGHT_DOESNOT_EXIST);
    }
}
