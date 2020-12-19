package co.com.ceiba.airport.domain.services;

import co.com.ceiba.airport.domain.models.entities.Flight;
import co.com.ceiba.airport.domain.ports.repositories.FlightRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class GetAllFlightService {
    private FlightRepository flightRepository;

    public GetAllFlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Transactional
    public List<Flight> run(){
        return this.flightRepository.getAllFlight();
    }
}
