package co.com.ceiba.airport.application.command.fabric;

import co.com.ceiba.airport.application.command.FlightCommand;
import co.com.ceiba.airport.domain.models.entities.Flight;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

@Component
public class FlightFabric {

    public Flight create(FlightCommand flightCommand){
        return new Flight(
                generateFlightId(flightCommand.getTime(), flightCommand.getArrival()),
                flightCommand.getTime(),
                flightCommand.getArrival(),
                recalculateCost(flightCommand.getCost(), flightCommand.getTime(), flightCommand.isReprogrammed()),
                flightCommand.isReprogrammed()
        );
    }

    private String generateFlightId(long time, String arrival) {
        return arrival + "-" + time;
    }

    private float recalculateCost(float cost, long time, boolean isReprogramed){
        float costInWeekend = cost;
        if(!isReprogramed) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(time * 1000);
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY) {
                costInWeekend = cost + cost * 0.1f;
            }
        }
        return costInWeekend;
    }

}
