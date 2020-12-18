package co.com.ceiba.airport.testdatabuilder;

import co.com.ceiba.airport.domain.models.entities.Arrival;

public class ArrivalTestDataBuilder {

    private static final String NAME = "LONDON";
    private static final float LATITUDE = 51.509865f;
    private static final float LENGHT = -0.118092f;

    private String name;
    private float latitude;
    private float lenght;

    public ArrivalTestDataBuilder(){
        this.name = NAME;
        this.latitude = LATITUDE;
        this.lenght = LENGHT;
    }

    public ArrivalTestDataBuilder withName(String name){
        this.name = name;
        return this;
    }

    public ArrivalTestDataBuilder withLatitud(float latitude){
        this.latitude = latitude;
        return this;
    }

    public ArrivalTestDataBuilder withLenght(float lenght){
        this.lenght = lenght;
        return this;
    }

    public Arrival build() {
        return new Arrival(null, this.name, this.latitude, this.lenght);
    }
}
