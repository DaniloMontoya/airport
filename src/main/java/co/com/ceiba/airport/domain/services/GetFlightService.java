package co.com.ceiba.airport.domain.services;

import co.com.ceiba.airport.domain.exceptions.NotExistException;
import co.com.ceiba.airport.domain.models.dto.FlightDTO;
import co.com.ceiba.airport.domain.ports.repositories.FlightRepository;
import co.com.ceiba.airport.domain.validators.ValidateExistence;
import co.com.ceiba.airport.infrastructure.persistence.builder.FlightBuilder;
import org.springframework.stereotype.Component;

@Component
public class GetFlightService {

    private static final String THE_FLIGHT_DOESNOT_EXIST = "The flight does not exist";

    private final FlightRepository flightRepository;
    private final ValidateExistence validateExistence;

    public GetFlightService(FlightRepository flightRepository, ValidateExistence validateExistence) {
        this.flightRepository = flightRepository;
        this.validateExistence = validateExistence;
    }

    public FlightDTO run(String id){
        validateExist(id);
        return FlightBuilder.convertToDTO(this.flightRepository.getFlight(id));
    }

    private void validateExist(String id) {
        if(!this.validateExistence.isExist(id))
            throw new NotExistException(THE_FLIGHT_DOESNOT_EXIST);
    }
}
