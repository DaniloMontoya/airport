package co.com.ceiba.airport.domain.services;

import co.com.ceiba.airport.domain.models.entities.Flight;
import co.com.ceiba.airport.domain.ports.repositories.FlightRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class GetFlightService {
    private FlightRepository flightRepository;

    public GetFlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Transactional
    public Flight run(Long id){
        return this.flightRepository.getFlight(id);
    }
}
