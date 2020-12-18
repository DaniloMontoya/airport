package co.com.ceiba.airport.application.command.handler;

import co.com.ceiba.airport.application.command.CommandHandler;
import co.com.ceiba.airport.domain.services.DeleteFlightService;
import org.springframework.stereotype.Component;

@Component
public class DeleteFlightHandler implements CommandHandler<Long> {

    private final DeleteFlightService deleteFlightService;

    public DeleteFlightHandler(DeleteFlightService deleteFlightService) {
        this.deleteFlightService = deleteFlightService;
    }

    @Override
    public void run(Long idFlight) {
        this.deleteFlightService.run(idFlight);
    }
}
