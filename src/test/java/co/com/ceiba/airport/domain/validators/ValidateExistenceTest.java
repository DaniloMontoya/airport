package co.com.ceiba.airport.domain.validators;

import co.com.ceiba.airport.domain.models.entities.Flight;
import co.com.ceiba.airport.domain.ports.repositories.FlightRepository;
import co.com.ceiba.airport.testdatabuilder.FlightTestDataBuilder;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ValidateExistenceTest {

    @Test
    void isExistTest(){
        //arrange
        FlightTestDataBuilder flightTestDataBuilder = new FlightTestDataBuilder();
        flightTestDataBuilder.conId("London-123456789");
        Flight flight = flightTestDataBuilder.build();
        FlightRepository flightRepository = mock(FlightRepository.class);
        when(flightRepository.isExiste(flight.getId())).thenReturn(true);
        ValidateExistence validateExistence = new ValidateExistence(flightRepository);
        //act
        boolean isExist = validateExistence.isExist(flight.getId());
        //assert
        Assert.assertTrue(isExist);
    }

    @Test
    void isNotExistTest(){
        //arrange
        FlightTestDataBuilder flightTestDataBuilder = new FlightTestDataBuilder();
        flightTestDataBuilder.conId("London-123456789");
        Flight flight = flightTestDataBuilder.build();
        FlightRepository flightRepository = mock(FlightRepository.class);
        when(flightRepository.isExiste(flight.getId())).thenReturn(false);
        ValidateExistence validateExistence = new ValidateExistence(flightRepository);
        //act
        boolean isExist = validateExistence.isExist(flight.getId());
        //assert
        Assert.assertFalse(isExist);
    }

}