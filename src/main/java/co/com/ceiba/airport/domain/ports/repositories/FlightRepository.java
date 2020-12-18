package co.com.ceiba.airport.domain.ports.repositories;

import co.com.ceiba.airport.domain.models.entities.Flight;

public interface FlightRepository {
    Long createFlight(Flight flight);
    void updateFlight(Flight flight);
    void deleteFlight(Long id);
    boolean isValidateCalendarTime(Long idFlight);
    boolean isExiste(Long idFlight);
}
