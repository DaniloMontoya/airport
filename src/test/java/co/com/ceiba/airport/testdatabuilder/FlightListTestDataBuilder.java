package co.com.ceiba.airport.testdatabuilder;

import co.com.ceiba.airport.domain.models.entities.Flight;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class FlightListTestDataBuilder {

    public List<Flight> generateFlightList(){
        LocalDateTime localDateTime = LocalDateTime.of(2020, Month.DECEMBER, 14, 13,30);
        List<Flight> flightList = new ArrayList<>();
        FlightTestDataBuilder flightTestDataBuilder = new FlightTestDataBuilder();
        flightTestDataBuilder.conId("London-123456789");
        Flight flight1 = flightTestDataBuilder.build();
        Flight flight2 = new Flight("Madrid-987654321", localDateTime, "Madrid", 181.03f, false);
        flightList.add(flight1);
        flightList.add(flight2);
        return flightList;
    }
}
