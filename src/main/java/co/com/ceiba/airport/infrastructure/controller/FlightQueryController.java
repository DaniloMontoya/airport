package co.com.ceiba.airport.infrastructure.controller;

import co.com.ceiba.airport.application.query.GetAllFlightHandler;
import co.com.ceiba.airport.domain.models.entities.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/flight")
public class FlightQueryController {

    private final GetAllFlightHandler getAllFlightHandler;

    public FlightQueryController(GetAllFlightHandler getAllFlightHandler) {
        this.getAllFlightHandler = getAllFlightHandler;
    }

    @GetMapping("getAll")
    public List<Flight> getAll(){
        return this.getAllFlightHandler.run();
    }


}
