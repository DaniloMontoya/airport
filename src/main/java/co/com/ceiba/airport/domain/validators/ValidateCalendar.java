package co.com.ceiba.airport.domain.validators;


import co.com.ceiba.airport.domain.models.entities.Flight;
import co.com.ceiba.airport.domain.ports.repositories.FlightRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class ValidateCalendar {

    private static final int LIMIT_VALIDATE_DATE_IN_MINUTES = 5;

    private final FlightRepository flightRepository;

    public ValidateCalendar(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public boolean isValidDateDepartures(LocalDateTime timeDeparture) {
        boolean isValid = true;
        LocalDateTime fiveMinutesBefore = timeDeparture.minusMinutes(LIMIT_VALIDATE_DATE_IN_MINUTES);
        LocalDateTime fiveMinutesAfter = timeDeparture.plusMinutes(LIMIT_VALIDATE_DATE_IN_MINUTES);
        List<Flight> flightList = this.flightRepository.getAllFlight();
        for(Flight flight : flightList){
            if (flight.getTimeDeparture().isAfter(fiveMinutesBefore) && flight.getTimeDeparture().isBefore(fiveMinutesAfter)){
                isValid = false;
                break;
            }
        }
        return isValid;
    }
}
