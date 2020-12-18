package co.com.ceiba.airport.domain.models.entities;

import static co.com.ceiba.airport.domain.ArgumentsValidater.mandatoryValidate;
import co.com.ceiba.airport.domain.models.dto.ArrivalDTO;
import lombok.Getter;



@Getter
public class Flight {

    private static final String IT_IS_NECESSARY_TO_ENTER_THE_TIME = "it is necessary to enter the time";

    private Long id;
    private long time;
    private ArrivalDTO arrivalDTO;
    private float cost;
    private boolean isReprogrammed;

    public Flight(long time){
        mandatoryValidate(time, IT_IS_NECESSARY_TO_ENTER_THE_TIME);
    }
}
