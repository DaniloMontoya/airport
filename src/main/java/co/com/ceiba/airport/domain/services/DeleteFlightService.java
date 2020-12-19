package co.com.ceiba.airport.domain.services;

import co.com.ceiba.airport.domain.ports.repositories.FlightRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public class DeleteFlightService {

    private final FlightRepository flightRepository;

    public DeleteFlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public void run(Long id){
        this.flightRepository.deleteFlight(id);
    }
}
