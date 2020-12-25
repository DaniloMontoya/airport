package co.com.ceiba.airport.application.query;

import co.com.ceiba.airport.domain.models.dto.FlightDTO;
import co.com.ceiba.airport.domain.services.GetFlightService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class GetFlightByIdHandler {

    private final GetFlightService getFlightService;

    public GetFlightByIdHandler(GetFlightService getFlightService) {
        this.getFlightService = getFlightService;
    }

    @Transactional
    public FlightDTO run(String id){
        return this.getFlightService.run(id);
    }
}
