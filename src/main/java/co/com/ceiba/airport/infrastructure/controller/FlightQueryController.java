package co.com.ceiba.airport.infrastructure.controller;

import co.com.ceiba.airport.application.query.GetAllFlightHandler;
import co.com.ceiba.airport.application.query.GetFlightByIdHandler;
import co.com.ceiba.airport.domain.models.entities.Flight;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/flight")
public class FlightQueryController {

    private final GetAllFlightHandler getAllFlightHandler;
    private final GetFlightByIdHandler getFlightByIdHandler;

    public FlightQueryController(GetAllFlightHandler getAllFlightHandler, GetFlightByIdHandler getFlightByIdHandler) {
        this.getAllFlightHandler = getAllFlightHandler;
        this.getFlightByIdHandler = getFlightByIdHandler;
    }

    @GetMapping("getAll")
    public List<Flight> getAll(){
        return this.getAllFlightHandler.run();
    }

    @GetMapping("getFlightById/{id}")
    public Flight getFlightById(@PathVariable(name = "id") String id){
        return this.getFlightByIdHandler.run(id);
    }


}
