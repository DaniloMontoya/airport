package co.com.ceiba.airport.domain.services;


import co.com.ceiba.airport.domain.BasePrueba;
import co.com.ceiba.airport.domain.exceptions.NotExistException;
import co.com.ceiba.airport.domain.ports.repositories.FlightRepository;
import co.com.ceiba.airport.domain.validators.ValidateExistence;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class DeleteFlightServiceTest {

    @Test
    void deleteFlightTest(){
        //arrange
        String id = "London-123456789";
        FlightRepository flightRepository = mock(FlightRepository.class);
        ValidateExistence validateExistence = mock(ValidateExistence.class);
        when(validateExistence.isExist(id)).thenReturn(true);
        doNothing().when(flightRepository).deleteFlight(id);
        DeleteFlightService deleteFlightService = new DeleteFlightService(flightRepository, validateExistence);
        //act - assert
        deleteFlightService.run(id);
    }

    @Test
    void validatePreviousFlightDoesnotExistTest(){
        //arrange
        String id = "London-123456789";
        FlightRepository flightRepository = mock(FlightRepository.class);
        ValidateExistence validateExistence = mock(ValidateExistence.class);
        when(validateExistence.isExist(id)).thenReturn(false);
        DeleteFlightService deleteFlightService = new DeleteFlightService(flightRepository, validateExistence);
        //act - assert
        BasePrueba.assertThrows(() -> deleteFlightService.run(id), NotExistException.class, "The flight does not exist");
    }
}