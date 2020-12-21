package co.com.ceiba.airport.domain.services;

import co.com.ceiba.airport.domain.ports.repositories.FlightRepository;

public class DeleteFlightService {

    private final FlightRepository flightRepository;

    public DeleteFlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public void run(String id){
        this.flightRepository.deleteFlight(id);
    }
}
