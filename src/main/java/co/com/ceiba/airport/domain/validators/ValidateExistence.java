package co.com.ceiba.airport.domain.validators;

import co.com.ceiba.airport.domain.ports.repositories.FlightRepository;
import org.springframework.stereotype.Component;

@Component
public class ValidateExistence {

    private final FlightRepository flightRepository;

    public ValidateExistence(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public boolean isExist(String id) {
        return this.flightRepository.isExiste(id);
    }
}
