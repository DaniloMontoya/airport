package co.com.ceiba.airport.domain.services;

import co.com.ceiba.airport.domain.models.dto.FlightDTO;
import co.com.ceiba.airport.domain.models.entities.Flight;
import co.com.ceiba.airport.domain.ports.repositories.FlightRepository;
import co.com.ceiba.airport.testdatabuilder.FlightListTestDataBuilder;
import co.com.ceiba.airport.testdatabuilder.FlightTestDataBuilder;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.List;

class GetAllFlightServiceTest {

    @Test
    void getAllFlightTest(){
        //arrange
        FlightListTestDataBuilder flightListTestDataBuilder = new FlightListTestDataBuilder();
        FlightTestDataBuilder flightTestDataBuilder = new FlightTestDataBuilder();
        flightTestDataBuilder.conId("London-123456789");
        Flight flight = flightTestDataBuilder.build();
        FlightRepository flightRepository = mock(FlightRepository.class);
        when(flightRepository.getAllFlight()).thenReturn(flightListTestDataBuilder.generateFlightList());
        GetAllFlightService getAllFlightService = new GetAllFlightService(flightRepository);
        //act
        List<FlightDTO> flightList = getAllFlightService.run();
        //assert
        Assert.assertEquals(flightList.get(0).getId(), flight.getId());
    }

}