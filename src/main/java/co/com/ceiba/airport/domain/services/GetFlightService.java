package co.com.ceiba.airport.domain.services;

import co.com.ceiba.airport.domain.exceptions.NotExistException;
import co.com.ceiba.airport.domain.models.entities.Flight;
import co.com.ceiba.airport.domain.ports.repositories.FlightRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class GetFlightService {

    private static final String THE_FLIGHT_DOESNOT_EXIST = "The flight does not exist";

    private FlightRepository flightRepository;

    public GetFlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Transactional
    public Flight run(String id){
        validateExist(id);
        return this.flightRepository.getFlight(id);
    }

    private void validateExist(String id) {
        if(!this.flightRepository.isExiste(id))
            throw new NotExistException(THE_FLIGHT_DOESNOT_EXIST);
    }
}
