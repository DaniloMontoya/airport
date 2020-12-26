package co.com.ceiba.airport.domain.services.currentDate;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Component
public class GetCurrentDate {

    private static final String ZONE_ID = "UTC";

    public LocalDateTime getCurrentDate() {
        return LocalDateTime.now(ZoneId.of(ZONE_ID));
    }
}
