package co.com.ceiba.airport.application.command.handler;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Component
public class SetDelayHandler {


    @Transactional
    public void run(LocalDateTime localDateTime) {

    }
}
