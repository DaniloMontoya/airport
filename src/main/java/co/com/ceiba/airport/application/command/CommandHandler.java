package co.com.ceiba.airport.application.command;

import org.springframework.transaction.annotation.Transactional;

public interface CommandHandler<C> {
    @Transactional
    void run(C command);
}
