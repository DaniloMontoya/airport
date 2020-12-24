package co.com.ceiba.airport.domain.models.entities;

import static co.com.ceiba.airport.domain.ArgumentsValidater.mandatoryValidate;
import static co.com.ceiba.airport.domain.ArgumentsValidater.validatePositive;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Flight {

    private static final String IT_IS_NECESSARY_TO_ENTER_THE_TIME = "It is necessary to enter the time";
    private static final String IT_IS_NECESSARY_TO_ENTER_THE_ARRIVAL = "It is necessary to enter the arrival";
    private static final String THE_COST_MUST_BE_GREATER_THAN_ZERO = "The cost must be greater than zero";

    private String id;
    private LocalDateTime timeDeparture;
    private String arrival;
    private float cost;
    private boolean isReprogrammed;

    public Flight(String id, LocalDateTime timeDeparture, String arrival, float cost, boolean isReprogrammed){
        mandatoryValidate(timeDeparture, IT_IS_NECESSARY_TO_ENTER_THE_TIME);
        mandatoryValidate(arrival, IT_IS_NECESSARY_TO_ENTER_THE_ARRIVAL);
        validatePositive(cost, THE_COST_MUST_BE_GREATER_THAN_ZERO);
        this.id = id;
        this.timeDeparture = timeDeparture;
        this.arrival = arrival;
        this.cost = cost;
        this.isReprogrammed = isReprogrammed;
    }
}
