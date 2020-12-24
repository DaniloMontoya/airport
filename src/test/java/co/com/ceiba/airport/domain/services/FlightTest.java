package co.com.ceiba.airport.domain.services;

import co.com.ceiba.airport.domain.models.entities.Flight;
import co.com.ceiba.airport.testdatabuilder.FlightTestDataBuilder;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

class FlightTest {

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

}