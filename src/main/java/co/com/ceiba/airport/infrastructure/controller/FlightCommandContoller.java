package co.com.ceiba.airport.infrastructure.controller;

import co.com.ceiba.airport.application.command.CommandResponse;
import co.com.ceiba.airport.application.command.FlightCommand;
import co.com.ceiba.airport.application.command.handler.CreateFlighHandler;
import co.com.ceiba.airport.application.command.handler.DeleteFlightHandler;
import co.com.ceiba.airport.application.command.handler.UpdateFlightHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/flight")
public class FlightCommandContoller {

    private final UpdateFlightHandler updateFlightHandler;
    private final CreateFlighHandler createFlighHandler;
    private final DeleteFlightHandler deleteFlightHandler;

    @Autowired
    public FlightCommandContoller(UpdateFlightHandler updateFlightHandler, CreateFlighHandler createFlighHandler, DeleteFlightHandler deleteFlightHandler) {
        this.updateFlightHandler = updateFlightHandler;
        this.createFlighHandler = createFlighHandler;
        this.deleteFlightHandler = deleteFlightHandler;
    }

    @PostMapping("/create")
    public CommandResponse<Long> create(@RequestBody FlightCommand flightCommand){
        return createFlighHandler.run(flightCommand);
    }


}
