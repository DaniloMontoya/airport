package co.com.ceiba.airport.domain.services;

import co.com.ceiba.airport.domain.models.entities.Flight;
import co.com.ceiba.airport.domain.ports.repositories.FlightRepository;
import co.com.ceiba.airport.testdatabuilder.FlightTestDataBuilder;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

public class GetAllFlightServiceTest {

    @Test
    public void getAllFlightTest(){
        //arrange
        FlightTestDataBuilder flightTestDataBuilder = new FlightTestDataBuilder();
        flightTestDataBuilder.conId("London-123456789");
        Flight flight = flightTestDataBuilder.build();
        FlightRepository flightRepository = mock(FlightRepository.class);
        when(flightRepository.getAllFlight()).thenReturn(generateFlightList());
        GetAllFlightService getAllFlightService = new GetAllFlightService(flightRepository);
        //act
        List<Flight> flightList = getAllFlightService.run();
        //assert
        Assert.assertEquals(flightList.get(0).getId(), flight.getId());


    }

    private List<Flight> generateFlightList(){
        List<Flight> flightList = new ArrayList<>();
        FlightTestDataBuilder flightTestDataBuilder = new FlightTestDataBuilder();
        flightTestDataBuilder.conId("London-123456789");
        Flight flight1 = flightTestDataBuilder.build();
        Flight flight2 = new Flight("Madrid-987654321", 987654321, "Madrid", 181.03f, false);
        flightList.add(flight1);
        flightList.add(flight2);
        return flightList;
    }

}