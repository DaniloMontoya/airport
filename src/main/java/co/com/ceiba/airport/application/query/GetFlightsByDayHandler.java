package co.com.ceiba.airport.application.query;

import co.com.ceiba.airport.domain.models.dto.FlightDTO;
import co.com.ceiba.airport.domain.ports.dao.FlightDAO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetFlightsByDayHandler {

    private final FlightDAO flightDAO;

    public GetFlightsByDayHandler(FlightDAO flightDAO) {
        this.flightDAO = flightDAO;
    }

    public List<FlightDTO> run(long time){
        return this.flightDAO.getFlightsByDay(time);
    }
}
