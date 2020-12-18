package co.com.ceiba.airport.infrastructure.configuration.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConectionJPA {

    private static final String FLIGHT = "flight";

    private static EntityManagerFactory entityManagerFactory;

    public ConectionJPA(){
        entityManagerFactory = Persistence.createEntityManagerFactory(FLIGHT);
    }

    public EntityManager createEntityManager(){
        return entityManagerFactory.createEntityManager();
    }


}
