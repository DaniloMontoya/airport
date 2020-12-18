package co.com.ceiba.airport.domain.models.entities;

import static co.com.ceiba.airport.domain.ArgumentsValidater.mandatoryValidate;

import lombok.Getter;



@Getter
public class Flight {

    private static final String IT_IS_NECESSARY_TO_ENTER_THE_TIME = "it is necessary to enter the time";

    private Long id;
    private long time;
    private String arrival;
    private float cost;
    private boolean isReprogrammed;

    public Flight(Long id, long time, String arrival, float cost, boolean isReprogrammed){
        mandatoryValidate(time, IT_IS_NECESSARY_TO_ENTER_THE_TIME);
        this.id = id;
        this.time = time;
        this.arrival = arrival;
        this.cost = cost;
        this.isReprogrammed = isReprogrammed;
    }
}
