package co.com.ceiba.airport.domain.services;

import co.com.ceiba.airport.domain.BasePrueba;
import co.com.ceiba.airport.domain.exceptions.InvalidTimeException;
import co.com.ceiba.airport.domain.models.entities.Flight;
import co.com.ceiba.airport.domain.ports.repositories.FlightRepository;
import co.com.ceiba.airport.domain.services.currentdate.GetCurrentDate;
import co.com.ceiba.airport.testdatabuilder.FlightListTestDataBuilder;
import co.com.ceiba.airport.testdatabuilder.FlightTestDataBuilder;
import org.junit.jupiter.api.Test;


import java.time.*;

import static org.mockito.Mockito.*;

class SetDelayServiceTest {

    public static final int HOUR_DELAY = 2;
    public static final LocalDateTime CURRENT_DATE = LocalDateTime.of(2020, 12, 24, 19, 0, 0);

    @Test
    void setDelayTest(){
        //arrange
        FlightTestDataBuilder flightTestDataBuilder = new FlightTestDataBuilder();
        Flight flight = flightTestDataBuilder.build();
        FlightListTestDataBuilder flightListTestDataBuilder = new FlightListTestDataBuilder();
        FlightRepository flightRepository = mock(FlightRepository.class);
        GetCurrentDate getCurrentDate = mock(GetCurrentDate.class);
        when(getCurrentDate.getCurrentDate()).thenReturn(CURRENT_DATE);
        when(flightRepository.getAllFlight()).thenReturn(flightListTestDataBuilder.generateFlightList());
        doNothing().when(flightRepository).updateFlight(flight);
        SetDelayService setDelayService = new SetDelayService(flightRepository, getCurrentDate);
        //act
        setDelayService.run(HOUR_DELAY);
    }

    @Test
    void validateHourIsLessThatZeroTest(){
        //arrange
        int hour = -1;
        FlightTestDataBuilder flightTestDataBuilder = new FlightTestDataBuilder();
        Flight flight = flightTestDataBuilder.build();
        FlightListTestDataBuilder flightListTestDataBuilder = new FlightListTestDataBuilder();
        FlightRepository flightRepository = mock(FlightRepository.class);
        GetCurrentDate getCurrentDate = mock(GetCurrentDate.class);
        when(getCurrentDate.getCurrentDate()).thenReturn(CURRENT_DATE);
        when(flightRepository.getAllFlight()).thenReturn(flightListTestDataBuilder.generateFlightList());
        doNothing().when(flightRepository).updateFlight(flight);
        SetDelayService setDelayService = new SetDelayService(flightRepository, getCurrentDate);
        //act - assert
        BasePrueba.assertThrows(() -> setDelayService.run(hour), InvalidTimeException.class, "Las horas de cierre deben ser mayores que cero.");
    }

}