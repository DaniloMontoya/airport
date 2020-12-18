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

    public Flight(Long id, long time, ArrivalDTO arrivalDTO, float cost, boolean isReprogrammed){
        mandatoryValidate(time, IT_IS_NECESSARY_TO_ENTER_THE_TIME);
        this.id = id;
        this.time = time;
        this.arrivalDTO = arrivalDTO;
        this.cost = cost;
        this.isReprogrammed = isReprogrammed;
    }
}
