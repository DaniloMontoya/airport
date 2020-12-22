package co.com.ceiba.airport.domain.services;


import co.com.ceiba.airport.domain.BaseTest;
import co.com.ceiba.airport.domain.exceptions.NotExistException;
import co.com.ceiba.airport.domain.ports.repositories.FlightRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;

import java.util.Optional;

import static org.mockito.Mockito.*;

public class DeleteFlightServiceTest {

    @Test
    public void deleteFlightTest(){
        //arrange
        String id = "London-123456789";
        FlightRepository flightRepository = mock(FlightRepository.class);
        when(flightRepository.isExiste(id)).thenReturn(true);
        doNothing().when(flightRepository).deleteFlight(id);
        DeleteFlightService deleteFlightService = new DeleteFlightService(flightRepository);
        //act - assert
        deleteFlightService.run(id);
    }

    @Test
    public void validatePreviousFlightDoesnotExistTest(){
        //arrange
        String id = "London-123456789";
        FlightRepository flightRepository = mock(FlightRepository.class);
        when(flightRepository.isExiste(id)).thenReturn(false);
        DeleteFlightService deleteFlightService = new DeleteFlightService(flightRepository);
        //act - assert
        BaseTest.assertThrows(() -> deleteFlightService.run(id), NotExistException.class, "The flight does not exist");
    }





}