package co.com.ceiba.airport.domain.services;

import co.com.ceiba.airport.domain.BaseTest;
import co.com.ceiba.airport.domain.exceptions.DuplicityValueException;
import co.com.ceiba.airport.domain.exceptions.InvalidTimeException;
import co.com.ceiba.airport.domain.exceptions.NotExistException;
import co.com.ceiba.airport.domain.models.entities.Flight;
import co.com.ceiba.airport.domain.ports.repositories.FlightRepository;
import co.com.ceiba.airport.testdatabuilder.FlightTestDataBuilder;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class UpdateFlightServiceTest {

    public static final String ID_TEST = "London-123456789";

    @Test
    public void UpdateFlightTest(){
        //arrange
        FlightTestDataBuilder flightTestDataBuilder = new FlightTestDataBuilder();
        flightTestDataBuilder.conId(ID_TEST);
        Flight flight = flightTestDataBuilder.build();
        FlightRepository flightRepository = mock(FlightRepository.class);
        when(flightRepository.isExiste(flight.getId())).thenReturn(true);
        when(flightRepository.isValidateTime(flight.getTime())).thenReturn(true);
        doNothing().when(flightRepository).updateFlight(flight);
        UpdateFlightService updateFlightService = new UpdateFlightService(flightRepository);
        //act - assert
        updateFlightService.run(flight);
    }

    @Test
    public void validatePreviousFlightDoesnotExistTest() {
        //arrange
        FlightTestDataBuilder flightTestDataBuilder = new FlightTestDataBuilder();
        flightTestDataBuilder.conId(ID_TEST);
        Flight flight = flightTestDataBuilder.build();
        FlightRepository flightRepository = mock(FlightRepository.class);
        when(flightRepository.isExiste(flight.getId())).thenReturn(false);
        UpdateFlightService updateFlightService = new UpdateFlightService(flightRepository);

        //act - assert
        BaseTest.assertThrows(() -> updateFlightService.run(flight), NotExistException.class, "The flight does not exist");
    }

    @Test
    public void validateTimeCalendar5MinTest(){
        //arrange
        FlightTestDataBuilder flightTestDataBuilder = new FlightTestDataBuilder();
        Flight flight = flightTestDataBuilder.build();
        FlightRepository flightRepository = mock(FlightRepository.class);
        when(flightRepository.isExiste(flight.getId())).thenReturn(true);
        when(flightRepository.isValidateTime(flight.getTime())).thenReturn(false);
        UpdateFlightService updateFlightService = new UpdateFlightService(flightRepository);
        //act - assert
        BaseTest.assertThrows(() -> updateFlightService.run(flight), InvalidTimeException.class, "The flight time is invalid in the calendar");
    }

}