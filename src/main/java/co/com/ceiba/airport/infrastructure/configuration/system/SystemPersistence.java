package co.com.ceiba.airport.infrastructure.configuration.system;

import co.com.ceiba.airport.domain.ports.repositories.FlightRepository;
import co.com.ceiba.airport.infrastructure.configuration.connection.ConectionJPA;
import co.com.ceiba.airport.infrastructure.persistence.repositories.FlightPersitenceRepository;

import javax.persistence.EntityManager;

public class SystemPersistence {
    private EntityManager entityManager;

    public SystemPersistence() {
        this.entityManager = new ConectionJPA().createEntityManager();
    }

    public FlightRepository getFlightRepository() {
        return new FlightPersitenceRepository(entityManager);
    }

    public ArrivalRepository getArrivalRepository() {
        return new ArrivalPersistanceRepository(entityManager);
    }

    public void start() {
        entityManager.getTransaction().begin();
    }

    public void finish() {
        entityManager.getTransaction().commit();
    }
}
