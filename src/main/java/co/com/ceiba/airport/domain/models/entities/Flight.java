package co.com.ceiba.airport.domain.models.entities;

import static co.com.ceiba.airport.domain.ArgumentsValidater.mandatoryValidate;

import lombok.Getter;



@Getter
public class Flight {

    private static final String IT_IS_NECESSARY_TO_ENTER_THE_TIME = "it is necessary to enter the time";

    private String id;
    private long timeDeparture;
    private String arrival;
    private float cost;
    private boolean isReprogrammed;

    public Flight(String id, long timeDeparture, String arrival, float cost, boolean isReprogrammed){
        mandatoryValidate(timeDeparture, IT_IS_NECESSARY_TO_ENTER_THE_TIME);
        this.id = id;
        this.timeDeparture = timeDeparture;
        this.arrival = arrival;
        this.cost = cost;
        this.isReprogrammed = isReprogrammed;
    }
}
