package co.com.ceiba.airport.domain.models.entities;

import static co.com.ceiba.airport.domain.ArgumentsValidater.mandatoryValidate;

import lombok.Getter;



@Getter
public class Flight {

    private static final String IT_IS_NECESSARY_TO_ENTER_THE_TIME = "it is necessary to enter the time";

    private String id;
    private long time_departure;
    private String arrival;
    private float cost;
    private boolean isReprogrammed;

    public Flight(String id, long time_departure, String arrival, float cost, boolean isReprogrammed){
        mandatoryValidate(time_departure, IT_IS_NECESSARY_TO_ENTER_THE_TIME);
        this.id = id;
        this.time_departure = time_departure;
        this.arrival = arrival;
        this.cost = cost;
        this.isReprogrammed = isReprogrammed;
    }
}
