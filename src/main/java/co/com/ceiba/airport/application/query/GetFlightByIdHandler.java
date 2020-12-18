package co.com.ceiba.airport.application.query;

import co.com.ceiba.airport.domain.models.dto.FlightDTO;
import co.com.ceiba.airport.domain.ports.dao.FlightDAO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetFlightByIdHandler {

    private final FlightDAO flightDAO;

    public GetFlightByIdHandler(FlightDAO flightDAO) {
        this.flightDAO = flightDAO;
    }

    public FlightDTO run(Long id){
        return this.flightDAO.getFlightById(id);
    }
}
