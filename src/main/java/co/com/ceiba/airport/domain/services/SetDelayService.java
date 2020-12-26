package co.com.ceiba.airport.domain.services;

import co.com.ceiba.airport.domain.exceptions.InvalidTimeException;
import co.com.ceiba.airport.domain.models.entities.Flight;
import co.com.ceiba.airport.domain.ports.repositories.FlightRepository;
import co.com.ceiba.airport.domain.services.currentDate.GetCurrentDate;

import java.time.LocalDateTime;
import java.util.List;

public class SetDelayService {

    private static final String HOUR_DELAY_MUST_GREATER_THAN_ZERO = "Hour delay must greater than zero";

    private final FlightRepository flightRepository;
    private final GetCurrentDate getCurrentDate;

    public SetDelayService(FlightRepository flightRepository, GetCurrentDate getCurrentDate) {
        this.flightRepository = flightRepository;
        this.getCurrentDate = getCurrentDate;
    }

    public void run(int hourDelay) {
        LocalDateTime currentDate = this.getCurrentDate.getCurrentDate();
        validateHourDelay(hourDelay);
        List<Flight> flightList = this.flightRepository.getAllFlight();
        for (Flight flight: flightList) {
            if(flight.getTimeDeparture().isAfter(currentDate)){
                Flight flightWithDelay = new Flight(flight.getId(),
                        flight.getTimeDeparture().plusHours(hourDelay),
                        flight.getArrival(),
                        flight.getCost(),
                        true);
                this.flightRepository.updateFlight(flightWithDelay);
            }
        }
    }

    private void validateHourDelay(int hourDelay) {
        if(hourDelay < 1){
            throw new InvalidTimeException(HOUR_DELAY_MUST_GREATER_THAN_ZERO);
        }
    }
}
