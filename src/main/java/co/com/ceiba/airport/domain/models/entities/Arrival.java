package co.com.ceiba.airport.domain.models.entities;

import static co.com.ceiba.airport.domain.ArgumentsValidater.mandatoryValidate;
import lombok.Getter;

@Getter
public class Arrival {

    private static final String IT_IS_NECESSARY_TO_ENTER_THE_NAME = "it is necessary to enter the name";
    private static final String IT_IS_NECESSARY_TO_ENTER_THE_LATITUDE = "it is necessary to enter the latitude";
    private static final String IT_IS_NECESSARY_TO_ENTER_THE_LENGHT = "it is necessary to enter the lenght";

    private String name;
    private float latitude;
    private float lenght;

    public Arrival(String name, float latitude, float lenght){
        mandatoryValidate(name, IT_IS_NECESSARY_TO_ENTER_THE_NAME);
        mandatoryValidate(latitude, IT_IS_NECESSARY_TO_ENTER_THE_LATITUDE);
        mandatoryValidate(latitude, IT_IS_NECESSARY_TO_ENTER_THE_LENGHT);

    }
}
