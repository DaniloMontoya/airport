package co.com.ceiba.airport.infrastructure.persistence.repositories;

import co.com.ceiba.airport.domain.models.dto.ArrivalDTO;
import co.com.ceiba.airport.domain.models.entities.Arrival;
import co.com.ceiba.airport.domain.ports.dao.ArrivalDAO;
import co.com.ceiba.airport.domain.ports.repositories.ArrivalRepository;
import co.com.ceiba.airport.domain.ports.repositories.FlightRepository;
import co.com.ceiba.airport.infrastructure.persistence.builder.ArrivalBuilder;
import co.com.ceiba.airport.infrastructure.persistence.entities.ArrivalEntity;
import co.com.ceiba.airport.infrastructure.persistence.repositories.jpa.FlightJPARepository;

import javax.persistence.EntityManager;
import java.util.List;

public class ArrivalPersistanceRepository implements ArrivalRepository, ArrivalDAO {

    private static final String NAME = "name";
    private static final String ARRIVAL_FIND_BY_NAME = "Arrival.findByName";

    private EntityManager entityManager;
    private FlightJPARepository flightJPARepository;

    public ArrivalPersistanceRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void createArrival(Arrival arrival) {
        entityManager.persist(ArrivalBuilder.convertToEntity(arrival));
    }

    @Override
    public void deleteArrival(String name) {

    }

    @Override
    public List<ArrivalDTO> getAllArrivals() {
        return null;
    }

    @Override
    public ArrivalDTO getArrivalByName() {
        return null;
    }
}
