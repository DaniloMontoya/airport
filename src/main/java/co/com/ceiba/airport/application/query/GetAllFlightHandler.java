package co.com.ceiba.airport.application.query;

import co.com.ceiba.airport.domain.models.dto.FlightDTO;
import co.com.ceiba.airport.domain.services.GetAllFlightService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class GetAllFlightHandler  {

    private final GetAllFlightService getAllFlightService;

    public GetAllFlightHandler(GetAllFlightService getAllFlightService) {
        this.getAllFlightService = getAllFlightService;
    }

    @Transactional
    public List<FlightDTO> run(){
        return this.getAllFlightService.run();
    }
}
