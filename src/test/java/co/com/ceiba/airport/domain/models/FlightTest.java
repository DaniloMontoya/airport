package co.com.ceiba.airport.domain.models;

import co.com.ceiba.airport.domain.BasePrueba;
import co.com.ceiba.airport.domain.exceptions.DuplicityValueException;
import co.com.ceiba.airport.domain.exceptions.InvalidTimeException;
import co.com.ceiba.airport.domain.exceptions.InvalidValueException;
import co.com.ceiba.airport.domain.exceptions.MandatoryValueException;
import co.com.ceiba.airport.domain.models.entities.Flight;
import co.com.ceiba.airport.testdatabuilder.FlightTestDataBuilder;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

class FlightTest {

    private static final String IT_IS_NECESSARY_TO_ENTER_THE_TIME = "It is necessary to enter the time";
    private static final String IT_IS_NECESSARY_TO_ENTER_THE_ARRIVAL = "It is necessary to enter the arrival";
    private static final String THE_COST_MUST_BE_GREATER_THAN_ZERO = "The cost must be greater than zero";

    private static final LocalDateTime FECHA_HORA_SALIDA = LocalDateTime.of(2020, Month.DECEMBER, 14, 14,0);
    private static final String CIUDAD_DE_LLEGADA = "Madrid";
    private static final float COSTO_DEL_VUELO = 151.03f;
    private static final boolean ES_REPOGRAMADO = false;

    @Test
    void createFlight(){
        //arrange
        FlightTestDataBuilder flightTestDataBuilder = new FlightTestDataBuilder()
                .conHoraDeSalida(FECHA_HORA_SALIDA)
                .conCiudadDeLlegada(CIUDAD_DE_LLEGADA)
                .conCosto(COSTO_DEL_VUELO)
                .conEsReprogramado(ES_REPOGRAMADO);
        //act
        Flight flight = flightTestDataBuilder.build();
        //asset
        Assert.assertEquals(FECHA_HORA_SALIDA, flight.getTimeDeparture());
        Assert.assertEquals(CIUDAD_DE_LLEGADA, flight.getArrival());
        Assert.assertEquals(COSTO_DEL_VUELO, flight.getCost(), 0);
        Assert.assertEquals(ES_REPOGRAMADO, flight.isReprogrammed());
    }

    @Test
    void validateCreateFlightWithoutDateDepartureTest(){
        //arrange
        FlightTestDataBuilder flightTestDataBuilder = new FlightTestDataBuilder()
                .conHoraDeSalida(null);
        //act - assert
        BasePrueba.assertThrows(() -> flightTestDataBuilder.build(), MandatoryValueException.class, IT_IS_NECESSARY_TO_ENTER_THE_TIME);
    }

    @Test
    void validateCreateFlightWithoutArrivalTest(){
        //arrange
        FlightTestDataBuilder flightTestDataBuilder = new FlightTestDataBuilder()
                .conCiudadDeLlegada(null);
        //act - assert
        BasePrueba.assertThrows(() -> flightTestDataBuilder.build(), MandatoryValueException.class, IT_IS_NECESSARY_TO_ENTER_THE_ARRIVAL);
    }

    @Test
    void validateCreateFlightWithNegativeCost(){
        //arrange
        FlightTestDataBuilder flightTestDataBuilder = new FlightTestDataBuilder()
                .conCosto(-181.3f);
        //act - assert
        BasePrueba.assertThrows(() -> flightTestDataBuilder.build(), InvalidValueException.class, THE_COST_MUST_BE_GREATER_THAN_ZERO);

    }

}