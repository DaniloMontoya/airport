package co.com.ceiba.airport.domain.services;

import co.com.ceiba.airport.domain.BaseTest;
import co.com.ceiba.airport.domain.exceptions.DuplicityValueException;
import co.com.ceiba.airport.domain.exceptions.InvalidTimeException;
import co.com.ceiba.airport.domain.models.entities.Flight;
import co.com.ceiba.airport.domain.ports.repositories.FlightRepository;
import co.com.ceiba.airport.domain.testdatabuilder.FlightTestDataBuilder;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CreateFlightServiceTest {

    @Test
    public void createFlightTest(){
        //arrange
        FlightTestDataBuilder flightTestDataBuilder = new FlightTestDataBuilder();
        flightTestDataBuilder.conId("London-123456789");
        Flight flight = flightTestDataBuilder.build();
        FlightRepository flightRepository = mock(FlightRepository.class);
        when(flightRepository.isExiste(flight.getId())).thenReturn(false);
        when(flightRepository.isValidateTime(flight.getTime())).thenReturn(true);
        when(flightRepository.createFlight(flight)).thenReturn(flight.getId());
        CreateFlightService createFlightService = new CreateFlightService(flightRepository);

        //act
        String id = createFlightService.run(flight);

        //asset
        Assert.assertEquals(id, flight.getId());
    }

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

    @Test
    public void validateTimeCalendar5MinTest(){
        //arrange
        FlightTestDataBuilder flightTestDataBuilder = new FlightTestDataBuilder();
        Flight flight = flightTestDataBuilder.build();
        FlightRepository flightRepository = mock(FlightRepository.class);
        when(flightRepository.isExiste(flight.getId())).thenReturn(false);
        when(flightRepository.isValidateTime(flight.getTime())).thenReturn(false);

        CreateFlightService createFlightService = new CreateFlightService(flightRepository);

        //act - assert
        BaseTest.assertThrows(() -> createFlightService.run(flight), InvalidTimeException.class, "The flight time is invalid in the calendar");
    }


}



