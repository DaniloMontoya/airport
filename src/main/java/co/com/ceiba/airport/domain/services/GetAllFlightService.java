package co.com.ceiba.airport.domain.services;

import co.com.ceiba.airport.domain.models.dto.FlightDTO;
import co.com.ceiba.airport.domain.models.entities.Flight;
import co.com.ceiba.airport.domain.ports.repositories.FlightRepository;
import co.com.ceiba.airport.infrastructure.persistence.builder.FlightBuilder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetAllFlightService {
    private FlightRepository flightRepository;

    public GetAllFlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Transactional
    public List<FlightDTO> run(){
        List<FlightDTO> flightDTOList = new ArrayList<>();
        this.flightRepository.getAllFlight().forEach((final Flight flight) -> flightDTOList.add(FlightBuilder.convertToDTO(flight)));
        return flightDTOList;
    }
}
