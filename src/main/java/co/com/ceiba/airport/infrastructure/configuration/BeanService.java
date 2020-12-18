package co.com.ceiba.airport.infrastructure.configuration;

import co.com.ceiba.airport.domain.ports.repositories.FlightRepository;
import co.com.ceiba.airport.domain.services.CreateFlightService;
import co.com.ceiba.airport.domain.services.DeleteFlightService;
import co.com.ceiba.airport.domain.services.UpdateFlightService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanService {

    @Bean
    public CreateFlightService createFlightService(FlightRepository flightRepository){
        return new CreateFlightService(flightRepository);
    }

    @Bean
    public UpdateFlightService updateFlightService(FlightRepository flightRepository){
        return new UpdateFlightService(flightRepository);
    }

    @Bean
    public DeleteFlightService deleteFlightService(FlightRepository flightRepository){
        return new DeleteFlightService(flightRepository);
    }
}
