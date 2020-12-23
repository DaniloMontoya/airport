package co.com.ceiba.airport.domain.services;

import co.com.ceiba.airport.domain.BasePrueba;
import co.com.ceiba.airport.domain.exceptions.InvalidTimeException;
import co.com.ceiba.airport.domain.exceptions.NotExistException;
import co.com.ceiba.airport.domain.models.entities.Flight;
import co.com.ceiba.airport.domain.ports.repositories.FlightRepository;
import co.com.ceiba.airport.testdatabuilder.FlightTestDataBuilder;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class UpdateFlightServiceTest {

    public static final String ID_TEST = "London-123456789";

    @Test
    void UpdateFlightTest(){
        //arrange
        FlightTestDataBuilder flightTestDataBuilder = new FlightTestDataBuilder();
        flightTestDataBuilder.conId(ID_TEST);
        Flight flight = flightTestDataBuilder.build();
        FlightRepository flightRepository = mock(FlightRepository.class);
        when(flightRepository.isExiste(flight.getId())).thenReturn(true);
        when(flightRepository.isValidateTime(flight.getTimeDeparture())).thenReturn(true);
        doNothing().when(flightRepository).updateFlight(flight);
        UpdateFlightService updateFlightService = new UpdateFlightService(flightRepository);
        //act - assert
        updateFlightService.run(flight);
    }

    @Test
    void validatePreviousFlightDoesnotExistTest() {
        //arrange
        FlightTestDataBuilder flightTestDataBuilder = new FlightTestDataBuilder();
        flightTestDataBuilder.conId(ID_TEST);
        Flight flight = flightTestDataBuilder.build();
        FlightRepository flightRepository = mock(FlightRepository.class);
        when(flightRepository.isExiste(flight.getId())).thenReturn(false);
        UpdateFlightService updateFlightService = new UpdateFlightService(flightRepository);

        //act - assert
        BasePrueba.assertThrows(() -> updateFlightService.run(flight), NotExistException.class, "The flight does not exist");
    }

    @Test
    void validateTimeCalendar5MinTest(){
        //arrange
        FlightTestDataBuilder flightTestDataBuilder = new FlightTestDataBuilder();
        Flight flight = flightTestDataBuilder.build();
        FlightRepository flightRepository = mock(FlightRepository.class);
        when(flightRepository.isExiste(flight.getId())).thenReturn(true);
        when(flightRepository.isValidateTime(flight.getTimeDeparture())).thenReturn(false);
        UpdateFlightService updateFlightService = new UpdateFlightService(flightRepository);
        //act - assert
        BasePrueba.assertThrows(() -> updateFlightService.run(flight), InvalidTimeException.class, "The flight time is invalid in the calendar");
    }

}