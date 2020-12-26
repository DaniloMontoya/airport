package co.com.ceiba.airport.domain.services;


import co.com.ceiba.airport.domain.BasePrueba;
import co.com.ceiba.airport.domain.exceptions.InvalidTimeException;
import co.com.ceiba.airport.domain.exceptions.NotExistException;
import co.com.ceiba.airport.domain.models.entities.Flight;
import co.com.ceiba.airport.domain.ports.repositories.FlightRepository;
import co.com.ceiba.airport.domain.services.currentdate.GetCurrentDate;
import co.com.ceiba.airport.domain.validators.ValidateExistence;
import co.com.ceiba.airport.testdatabuilder.FlightTestDataBuilder;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.mockito.Mockito.*;

class DeleteFlightServiceTest {

    private static final LocalDateTime CURRENT_DATE = LocalDateTime.of(2020,12,24,19,0);

    @Test
    void deleteFlightTest(){
        //arrange
        FlightTestDataBuilder flightTestDataBuilder = new FlightTestDataBuilder();
        flightTestDataBuilder.conId("London-123456789");
        flightTestDataBuilder.conHoraDeSalida(LocalDateTime.of(2021, 12, 31, 19, 0));
        Flight flight = flightTestDataBuilder.build();
        FlightRepository flightRepository = mock(FlightRepository.class);
        ValidateExistence validateExistence = mock(ValidateExistence.class);
        GetCurrentDate getCurrentDate = mock(GetCurrentDate.class);
        when(getCurrentDate.getCurrentDate()).thenReturn(CURRENT_DATE);
        when(validateExistence.isExist(flight.getId())).thenReturn(true);
        when(flightRepository.getFlight(flight.getId())).thenReturn(flight);
        doNothing().when(flightRepository).deleteFlight(flight.getId());
        DeleteFlightService deleteFlightService = new DeleteFlightService(flightRepository, validateExistence, getCurrentDate);
        //act - assert
        deleteFlightService.run(flight.getId());
    }

    @Test
    void validatePreviousFlightDoesnotExistTest(){
        //arrange
        String id = "London-123456789";
        FlightRepository flightRepository = mock(FlightRepository.class);
        ValidateExistence validateExistence = mock(ValidateExistence.class);
        GetCurrentDate getCurrentDate = mock(GetCurrentDate.class);
        when(validateExistence.isExist(id)).thenReturn(false);
        DeleteFlightService deleteFlightService = new DeleteFlightService(flightRepository, validateExistence, getCurrentDate);
        //act - assert
        BasePrueba.assertThrows(() -> deleteFlightService.run(id), NotExistException.class, "The flight does not exist");
    }

    @Test
    void validateFlightNotPossibleDeleteForLimitTimeTest(){
        //arrange
        FlightTestDataBuilder flightTestDataBuilder = new FlightTestDataBuilder();
        flightTestDataBuilder.conId("London-123456789");
        flightTestDataBuilder.conHoraDeSalida(LocalDateTime.of(2020, 12, 31, 19, 0));
        Flight flight = flightTestDataBuilder.build();
        FlightRepository flightRepository = mock(FlightRepository.class);
        ValidateExistence validateExistence = mock(ValidateExistence.class);
        GetCurrentDate getCurrentDate = mock(GetCurrentDate.class);
        when(getCurrentDate.getCurrentDate()).thenReturn(CURRENT_DATE);
        when(validateExistence.isExist(flight.getId())).thenReturn(true);
        when(flightRepository.getFlight(flight.getId())).thenReturn(flight);
        DeleteFlightService deleteFlightService = new DeleteFlightService(flightRepository, validateExistence, getCurrentDate);
        //act - assert
        BasePrueba.assertThrows(() -> deleteFlightService.run(flight.getId()), InvalidTimeException.class, "It's not possible delete flight for limit date");
    }
}