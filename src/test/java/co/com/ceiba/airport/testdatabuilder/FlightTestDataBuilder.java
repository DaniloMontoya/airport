package co.com.ceiba.airport.testdatabuilder;

import co.com.ceiba.airport.application.command.FlightCommand;
import co.com.ceiba.airport.domain.models.entities.Flight;

import java.time.LocalDateTime;
import java.time.Month;

public class FlightTestDataBuilder {

    private static final String ID = "London-1608404400";
    private static final LocalDateTime FECHA_HORA_SALIDA = LocalDateTime.of(2020, Month.DECEMBER, 14, 14,0);
    private static final String CIUDAD_DE_LLEGADA = "London";
    private static final float COSTO_DEL_VUELO = 181.03f;
    private static final boolean ES_REPOGRAMADO = false;

    private String id;
    private LocalDateTime time_departures;
    private String arrival;
    private float cost;
    private boolean isReprogrammed;

    public FlightTestDataBuilder(){
        this.id = ID;
        this.time_departures = FECHA_HORA_SALIDA;
        this.arrival = CIUDAD_DE_LLEGADA;
        this.cost = COSTO_DEL_VUELO;
        this.isReprogrammed = ES_REPOGRAMADO;
    }

    public FlightTestDataBuilder conId(String id){
        this.id = id;
        return this;
    }

    public FlightTestDataBuilder conHoraDeSalida(LocalDateTime localDateTime) {
        this.time_departures = localDateTime;
        return this;
    }

    public FlightTestDataBuilder conCiudadDeLlegada(String arrival){
        this.arrival = arrival;
        return this;
    }

    public FlightTestDataBuilder conCosto(float cost){
        this.cost = cost;
        return this;
    }

    public FlightTestDataBuilder conEsReprogramado(boolean isReprogrammed){
        this.isReprogrammed = isReprogrammed;
        return this;
    }

    public Flight build(){
        return new Flight(this.id, this.time_departures, this.arrival, this.cost, this.isReprogrammed);
    }

    public FlightCommand buildCommand(){
        return new FlightCommand(this.id, this.time_departures, this.arrival, this.cost, this.isReprogrammed);
    }
}
