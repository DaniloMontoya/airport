package co.com.ceiba.airport.testdatabuilder;

import co.com.ceiba.airport.application.command.FlightCommand;
import co.com.ceiba.airport.domain.models.entities.Flight;

public class FlightTestDataBuilder {
    private static final long FECHA_HORA_SALIDA = 1608320500;
    private static final String CIUDAD_DE_LLEGADA = "London";
    private static final float COSTO_DEL_VUELO = 181.03f;
    private static final boolean ES_REPOGRAMADO = false;

    private String id;
    private long time;
    private String arrival;
    private float cost;
    private boolean isReprogrammed;

    public FlightTestDataBuilder(){
        this.time = FECHA_HORA_SALIDA;
        this.arrival = CIUDAD_DE_LLEGADA;
        this.cost = COSTO_DEL_VUELO;
        this.isReprogrammed = ES_REPOGRAMADO;
    }

    public FlightTestDataBuilder conId(String id){
        this.id = id;
        return this;
    }

    public FlightTestDataBuilder conHoraDeSalida(long time) {
        this.time = time;
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
        return new Flight(this.id, this.time, this.arrival, this.cost, this.isReprogrammed);
    }

    public FlightCommand buildCommand(){
        return new FlightCommand(this.id, this.time, this.arrival, this.cost, this.isReprogrammed);
    }
}
