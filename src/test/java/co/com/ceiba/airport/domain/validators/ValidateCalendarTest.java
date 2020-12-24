package co.com.ceiba.airport.domain.validators;

import co.com.ceiba.airport.domain.models.entities.Flight;
import co.com.ceiba.airport.domain.ports.repositories.FlightRepository;
import co.com.ceiba.airport.testdatabuilder.FlightListTestDataBuilder;
import co.com.ceiba.airport.testdatabuilder.FlightTestDataBuilder;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ValidateCalendarTest {

    @Test
    void isValidDateDeparture(){
        //arrange
        FlightListTestDataBuilder flightListTestDataBuilder = new FlightListTestDataBuilder();
        FlightTestDataBuilder flightTestDataBuilder = new FlightTestDataBuilder();
        flightTestDataBuilder.conHoraDeSalida(LocalDateTime.of(2020, Month.DECEMBER, 13, 13,56));
        Flight flight = flightTestDataBuilder.build();
        FlightRepository flightRepository = mock(FlightRepository.class);
        when(flightRepository.getAllFlight()).thenReturn(flightListTestDataBuilder.generateFlightList());
        ValidateCalendar validateCalendar = new ValidateCalendar(flightRepository);
        //act
        boolean isValid = validateCalendar.isValidDateDepartures(flight.getTimeDeparture());
        //assert
        Assert.assertTrue(isValid);
    }

    @Test
    void isNotValidDateDeparture(){
        //arrange
        FlightListTestDataBuilder flightListTestDataBuilder = new FlightListTestDataBuilder();
        FlightTestDataBuilder flightTestDataBuilder = new FlightTestDataBuilder();
        flightTestDataBuilder.conHoraDeSalida(LocalDateTime.of(2020, Month.DECEMBER, 14, 13,56));
        Flight flight = flightTestDataBuilder.build();
        FlightRepository flightRepository = mock(FlightRepository.class);
        when(flightRepository.getAllFlight()).thenReturn(flightListTestDataBuilder.generateFlightList());
        ValidateCalendar validateCalendar = new ValidateCalendar(flightRepository);
        //act
        boolean isValid = validateCalendar.isValidDateDepartures(flight.getTimeDeparture());
        //assert
        Assert.assertFalse(isValid);

    }

}