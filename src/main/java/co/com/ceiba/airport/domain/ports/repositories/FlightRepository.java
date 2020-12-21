package co.com.ceiba.airport.domain.ports.repositories;

import co.com.ceiba.airport.domain.models.entities.Flight;

import java.util.List;

public interface FlightRepository {
    Flight getFlight(String id);
    List<Flight> getAllFlight();
    String createFlight(Flight flight);
    void updateFlight(Flight flight);
    void deleteFlight(String id);
    boolean isValidateCalendarTime(String idFlight);
    boolean isExiste(String idFlight);
}
