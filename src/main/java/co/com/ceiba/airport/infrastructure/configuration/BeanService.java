package co.com.ceiba.airport.infrastructure.configuration;

import co.com.ceiba.airport.domain.ports.repositories.FlightRepository;
import co.com.ceiba.airport.domain.services.CreateFlightService;
import co.com.ceiba.airport.domain.services.DeleteFlightService;
import co.com.ceiba.airport.domain.services.SetDelayService;
import co.com.ceiba.airport.domain.services.UpdateFlightService;
import co.com.ceiba.airport.domain.services.currentDate.GetCurrentDate;
import co.com.ceiba.airport.domain.validators.ValidateCalendar;
import co.com.ceiba.airport.domain.validators.ValidateExistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanService {

    @Bean
    public CreateFlightService createFlightService(FlightRepository flightRepository, ValidateExistence validateExistence, ValidateCalendar validateCalendar){
        return new CreateFlightService(flightRepository, validateExistence, validateCalendar);
    }

    @Bean
    public UpdateFlightService updateFlightService(FlightRepository flightRepository, ValidateExistence validateExistence, ValidateCalendar validateCalendar){
        return new UpdateFlightService(flightRepository, validateExistence, validateCalendar);
    }

    @Bean
    public SetDelayService setDelayService(FlightRepository flightRepository, GetCurrentDate getCurrentDate){
        return new SetDelayService(flightRepository, getCurrentDate);
    }

    @Bean
    public DeleteFlightService deleteFlightService(FlightRepository flightRepository, ValidateExistence validateExistence){
        return new DeleteFlightService(flightRepository, validateExistence);
    }
}
