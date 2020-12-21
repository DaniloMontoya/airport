package co.com.ceiba.airport.domain.services;

import co.com.ceiba.airport.domain.BaseTest;
import co.com.ceiba.airport.domain.exceptions.DuplicityValueException;
import co.com.ceiba.airport.domain.models.entities.Flight;
import co.com.ceiba.airport.domain.ports.repositories.FlightRepository;
import co.com.ceiba.airport.domain.testdatabuilder.FlightTestDataBuilder;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CreateFlightServiceTest {

    @Test
    public void validatePreviousFlightExistTest() {
        //arrange
        FlightTestDataBuilder flightTestDataBuilder = new FlightTestDataBuilder();
        Flight flight = flightTestDataBuilder.build();
        FlightRepository flightRepository = mock(FlightRepository.class);
        when(flightRepository.isExiste(flight.getId())).thenReturn(true);
        CreateFlightService createFlightService = new CreateFlightService(flightRepository);

        //act - assert
        BaseTest.assertThrows(() -> createFlightService.run(flight), DuplicityValueException.class, "The flight already exist");
    }




}