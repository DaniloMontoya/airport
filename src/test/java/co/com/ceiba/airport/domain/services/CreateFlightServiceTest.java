package co.com.ceiba.airport.domain.services;

import co.com.ceiba.airport.domain.BasePrueba;
import co.com.ceiba.airport.domain.exceptions.DuplicityValueException;
import co.com.ceiba.airport.domain.exceptions.InvalidTimeException;
import co.com.ceiba.airport.domain.models.entities.Flight;
import co.com.ceiba.airport.domain.ports.repositories.FlightRepository;
import co.com.ceiba.airport.domain.validators.ValidateCalendar;
import co.com.ceiba.airport.domain.validators.ValidateExistence;
import co.com.ceiba.airport.testdatabuilder.FlightTestDataBuilder;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class CreateFlightServiceTest {

    private static final String THE_FLIGHT_ALREADY_EXIST = "The flight already exist";
    private static final String THE_FLIGHT_TIME_IS_INVALID_IN_THE_CALENDAR = "The flight time is invalid in the calendar";

    @Test
    void createFlightTest(){
        //arrange
        FlightTestDataBuilder flightTestDataBuilder = new FlightTestDataBuilder();
        flightTestDataBuilder.conId("London-123456789");
        Flight flight = flightTestDataBuilder.build();
        FlightRepository flightRepository = mock(FlightRepository.class);
        ValidateExistence validateExistence = mock(ValidateExistence.class);
        ValidateCalendar validateCalendar = mock(ValidateCalendar.class);
        when(validateExistence.isExist(flight.getId())).thenReturn(false);
        when(validateCalendar.isValidDateDepartures(flight.getTimeDeparture())).thenReturn(true);
        when(flightRepository.createFlight(flight)).thenReturn(flight.getId());
        CreateFlightService createFlightService = new CreateFlightService(flightRepository, validateExistence, validateCalendar);

        //act
        String id = createFlightService.run(flight);

        //asset
        Assert.assertEquals(id, flight.getId());
    }

    @Test
    void validatePreviousFlightExistTest() {
        //arrange
        FlightTestDataBuilder flightTestDataBuilder = new FlightTestDataBuilder();
        Flight flight = flightTestDataBuilder.build();
        FlightRepository flightRepository = mock(FlightRepository.class);
        ValidateExistence validateExistence = mock(ValidateExistence.class);
        ValidateCalendar validateCalendar = mock(ValidateCalendar.class);
        when(validateExistence.isExist(flight.getId())).thenReturn(true);
        CreateFlightService createFlightService = new CreateFlightService(flightRepository, validateExistence, validateCalendar);

        //act - assert
        BasePrueba.assertThrows(() -> createFlightService.run(flight), DuplicityValueException.class, THE_FLIGHT_ALREADY_EXIST);
    }

    @Test
    void validateTimeCalendar5MinTest(){
        //arrange
        FlightTestDataBuilder flightTestDataBuilder = new FlightTestDataBuilder();
        Flight flight = flightTestDataBuilder.build();
        FlightRepository flightRepository = mock(FlightRepository.class);
        ValidateExistence validateExistence = mock(ValidateExistence.class);
        ValidateCalendar validateCalendar = mock(ValidateCalendar.class);
        when(validateCalendar.isValidDateDepartures(flight.getTimeDeparture())).thenReturn(false);

        CreateFlightService createFlightService = new CreateFlightService(flightRepository, validateExistence, validateCalendar);

        //act - assert
        BasePrueba.assertThrows(() -> createFlightService.run(flight), InvalidTimeException.class, THE_FLIGHT_TIME_IS_INVALID_IN_THE_CALENDAR);
    }


}



