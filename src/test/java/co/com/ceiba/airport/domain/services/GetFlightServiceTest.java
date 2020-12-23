package co.com.ceiba.airport.domain.services;

import co.com.ceiba.airport.domain.BasePrueba;
import co.com.ceiba.airport.domain.exceptions.NotExistException;
import co.com.ceiba.airport.domain.models.entities.Flight;
import co.com.ceiba.airport.domain.ports.repositories.FlightRepository;
import co.com.ceiba.airport.testdatabuilder.FlightTestDataBuilder;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GetFlightServiceTest {

    @Test
    void getFlightByIdTest(){
        //arrange
        FlightTestDataBuilder flightTestDataBuilder = new FlightTestDataBuilder();
        flightTestDataBuilder.conId("London-123456789");
        Flight flight = flightTestDataBuilder.build();
        FlightRepository flightRepository = mock(FlightRepository.class);
        when(flightRepository.isExiste(flight.getId())).thenReturn(true);
        when(flightRepository.getFlight(flight.getId())).thenReturn(flight);
        GetFlightService getFlightService = new GetFlightService(flightRepository);
        //act
        Flight flightReturn = getFlightService.run(flight.getId());
        //assert
        Assert.assertEquals(flight.getId(), flightReturn.getId());
    }

    @Test
    void validateFlightDoesnotExistTest(){
        //arrange
        FlightTestDataBuilder flightTestDataBuilder = new FlightTestDataBuilder();
        flightTestDataBuilder.conId("London-123456789");
        Flight flight = flightTestDataBuilder.build();
        FlightRepository flightRepository = mock(FlightRepository.class);
        when(flightRepository.isExiste(flight.getId())).thenReturn(false);
        GetFlightService getFlightService = new GetFlightService(flightRepository);
        //act - assert
        BasePrueba.assertThrows(() -> getFlightService.run(flight.getId()), NotExistException.class, "The flight does not exist");
    }

}