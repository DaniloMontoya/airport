package co.com.ceiba.airport.domain.ports.dao;

import co.com.ceiba.airport.domain.models.dto.FlightDTO;

import java.util.List;

public interface FlightDAO {

    List<FlightDTO> getAllFlight();
    List<FlightDTO> getFlightsByDay(long time);
}
