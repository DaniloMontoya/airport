package co.com.ceiba.airport.infrastructure.persistence.builder;

import co.com.ceiba.airport.domain.BasePrueba;
import co.com.ceiba.airport.domain.exceptions.MandatoryValueException;
import co.com.ceiba.airport.domain.models.dto.FlightDTO;
import co.com.ceiba.airport.domain.models.entities.Flight;
import co.com.ceiba.airport.infrastructure.persistence.entities.FlightEntity;
import co.com.ceiba.airport.testdatabuilder.FlightTestDataBuilder;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class FlightBuilderTest {

    private static final String FLIGHTENTITY_IS_NULL = "FlightEntity es null";
    private static final String FLIGHT_IS_NULL = "Flight es null";

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
    void validateEntityIsNullTest(){
        //arrange
        FlightEntity flightEntity = null;
        //act - assert
        BasePrueba.assertThrows(()-> FlightBuilder.convertToDomain(flightEntity), MandatoryValueException.class, FLIGHTENTITY_IS_NULL);

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
    void validateFlighIsNullConvertEntityTest(){
        //arrenge
        Flight flight = null;
        //act - assert
        BasePrueba.assertThrows(() -> FlightBuilder.convertToEntity(flight), MandatoryValueException.class, FLIGHT_IS_NULL);
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

    @Test
    void validateFlightIsNullConvertDTOTest(){
        //arrenge
        Flight flight = null;
        //act - assert
        BasePrueba.assertThrows(() -> FlightBuilder.convertToDTO(flight), MandatoryValueException.class, FLIGHT_IS_NULL);
    }

}