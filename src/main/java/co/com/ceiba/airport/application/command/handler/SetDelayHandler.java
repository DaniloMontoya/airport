package co.com.ceiba.airport.application.command.handler;

import co.com.ceiba.airport.domain.services.SetDelayService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class SetDelayHandler {

    private final SetDelayService setDelayService;

    public SetDelayHandler(SetDelayService setDelayService) {
        this.setDelayService = setDelayService;
    }

    @Transactional
    public void run(int hourDelay) {
        this.setDelayService.run(hourDelay);

    }
}
