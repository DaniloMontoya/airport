package co.com.ceiba.airport.application.command;

import org.springframework.transaction.annotation.Transactional;

public interface CommandResponseHandler<C, R> {
    @Transactional
    R run(C command);
}
