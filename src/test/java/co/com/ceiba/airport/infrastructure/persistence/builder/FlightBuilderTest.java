package co.com.ceiba.airport.infrastructure.persistence.builder;

import co.com.ceiba.airport.domain.models.dto.FlightDTO;
import co.com.ceiba.airport.domain.models.entities.Flight;
import co.com.ceiba.airport.infrastructure.persistence.entities.FlightEntity;
import co.com.ceiba.airport.testdatabuilder.FlightTestDataBuilder;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class FlightBuilderTest {

    @Test
    void convertEntityToDomainTest(){
        //arrange
        FlightTestDataBuilder flightTestDataBuilder = new FlightTestDataBuilder();
        Flight flightTest = flightTestDataBuilder.build();
        FlightEntity flightEntity = new FlightEntity();
        flightEntity.setId(flightTest.getId());
        flightEntity.setTimeDeparture(flightTest.getTimeDeparture());
        flightEntity.setArrival(flightTest.getArrival());
        flightEntity.setCost(flightTest.getCost());
        flightEntity.setReprogrammed(flightTest.isReprogrammed());
        //act
        Flight flight = FlightBuilder.convertToDomain(flightEntity);
        //assert
        Assert.assertEquals(flight.getId(), flightTest.getId());
    }

    @Test
    void convertDomainToEntityTest(){
        //arrange
        FlightTestDataBuilder flightTestDataBuilder = new FlightTestDataBuilder();
        Flight flight = flightTestDataBuilder.build();
        //act
        FlightEntity flightEntity = FlightBuilder.convertToEntity(flight);
        //assert
        Assert.assertEquals(flight.getId(), flightEntity.getId());
    }

    @Test
    void convertToDTOTest(){
        //arrange
        FlightTestDataBuilder flightTestDataBuilder = new FlightTestDataBuilder();
        Flight flight = flightTestDataBuilder.build();
        //act
        FlightDTO flightDTO = FlightBuilder.convertToDTO(flight);
        //assert
        Assert.assertEquals(flight.getId(), flightDTO.getId());
    }

}