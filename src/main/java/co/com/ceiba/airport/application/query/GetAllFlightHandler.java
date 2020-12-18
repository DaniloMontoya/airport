package co.com.ceiba.airport.application.query;

import co.com.ceiba.airport.domain.models.dto.FlightDTO;
import co.com.ceiba.airport.domain.ports.dao.FlightDAO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllFlightHandler {

    private final FlightDAO flightDAO;


    public GetAllFlightHandler(FlightDAO flightDAO) {
        this.flightDAO = flightDAO;
    }

    public List<FlightDTO> run(){
        return this.flightDAO.getAllFlight();
    }
}
