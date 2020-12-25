package co.com.ceiba.airport.domain.models.dao;

import java.util.List;
import co.com.ceiba.airport.domain.models.dto.FlightDTO;

public interface FlightDAO {
    List<FlightDTO> getAllFlight();
    FlightDTO getFlightBydId();
}
