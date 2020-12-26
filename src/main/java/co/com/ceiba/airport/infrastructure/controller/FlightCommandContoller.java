package co.com.ceiba.airport.infrastructure.controller;

import co.com.ceiba.airport.application.command.CommandResponse;
import co.com.ceiba.airport.application.command.FlightCommand;
import co.com.ceiba.airport.application.command.handler.CreateFlighHandler;
import co.com.ceiba.airport.application.command.handler.DeleteFlightHandler;
import co.com.ceiba.airport.application.command.handler.SetDelayHandler;
import co.com.ceiba.airport.application.command.handler.UpdateFlightHandler;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/flight")
public class FlightCommandContoller {

    private final UpdateFlightHandler updateFlightHandler;
    private final CreateFlighHandler createFlighHandler;
    private final DeleteFlightHandler deleteFlightHandler;
    private final SetDelayHandler setDelayHandler;

    public FlightCommandContoller(UpdateFlightHandler updateFlightHandler, CreateFlighHandler createFlighHandler, DeleteFlightHandler deleteFlightHandler, SetDelayHandler setDelayHandler) {
        this.updateFlightHandler = updateFlightHandler;
        this.createFlighHandler = createFlighHandler;
        this.deleteFlightHandler = deleteFlightHandler;
        this.setDelayHandler = setDelayHandler;
    }

    @PostMapping("/create")
    public CommandResponse<String> create(@Valid @RequestBody FlightCommand flightCommand){
        return createFlighHandler.run(flightCommand);
    }

    @PutMapping("/update")
    public void update(@Valid @RequestBody FlightCommand flightCommand){
        updateFlightHandler.run(flightCommand);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(name = "id") String id){
        deleteFlightHandler.run(id);
    }

    @PutMapping("/setDelay/{hourDelay}")
    public void setDelay(@PathVariable(name = "hourDelay") int hourDelay){
        setDelayHandler.run(hourDelay);
    }


}
