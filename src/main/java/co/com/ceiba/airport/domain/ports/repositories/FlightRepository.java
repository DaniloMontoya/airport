package co.com.ceiba.airport.domain.ports.repositories;

import co.com.ceiba.airport.domain.models.entities.Flight;

import java.util.List;

public interface FlightRepository {
    Flight getFlight(Long id);
    List<Flight> getAllFlight();
    Long createFlight(Flight flight);
    void updateFlight(Flight flight);
    void deleteFlight(Long id);
    boolean isValidateCalendarTime(Long idFlight);
    boolean isExiste(Long idFlight);
}
