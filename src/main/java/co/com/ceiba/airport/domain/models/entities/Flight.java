package co.com.ceiba.airport.domain.models.entities;

import static co.com.ceiba.airport.domain.ArgumentsValidater.mandatoryValidate;

import lombok.Getter;

@Getter
public class Flight {

    private static final String IT_IS_NECESSARY_TO_ENTER_THE_TIME = "It is necessary to enter the time";
    private static final String IT_IS_NECESSARY_TO_ENTER_THE_ARRIVAL = "It is necessary to enter the arrival";
    private static final String MINIMUM_LENGTH = "El costo debe tener un valor mayor a cero";

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
