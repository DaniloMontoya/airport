package co.com.ceiba.airport.domain.services;

import co.com.ceiba.airport.domain.exceptions.NotExistException;
import co.com.ceiba.airport.domain.ports.repositories.FlightRepository;

public class DeleteFlightService {

    private static final String THE_FLIGHT_DOESNOT_EXIST = "The flight does not exist";

    private final FlightRepository flightRepository;

    public DeleteFlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public void run(String id){
        validateExist(id);
        this.flightRepository.deleteFlight(id);
    }

    private void validateExist(String id) {
        if(!this.flightRepository.isExiste(id))
            throw new NotExistException(THE_FLIGHT_DOESNOT_EXIST);
    }
}
