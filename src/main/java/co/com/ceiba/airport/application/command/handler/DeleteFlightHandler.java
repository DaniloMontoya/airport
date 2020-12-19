package co.com.ceiba.airport.application.command.handler;

import co.com.ceiba.airport.application.command.CommandHandler;
import co.com.ceiba.airport.domain.services.DeleteFlightService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DeleteFlightHandler {

    private final DeleteFlightService deleteFlightService;

    public DeleteFlightHandler(DeleteFlightService deleteFlightService) {
        this.deleteFlightService = deleteFlightService;
    }

    @Transactional
    public void run(Long idFlight) {
        this.deleteFlightService.run(idFlight);
    }
}
