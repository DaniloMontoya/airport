package co.com.ceiba.airport.infrastructure.persistence.repositories;

import co.com.ceiba.airport.domain.models.entities.Flight;
import co.com.ceiba.airport.domain.ports.repositories.FlightRepository;
import co.com.ceiba.airport.infrastructure.persistence.builder.FlightBuilder;
import co.com.ceiba.airport.infrastructure.persistence.entities.FlightEntity;
import co.com.ceiba.airport.infrastructure.persistence.repositories.jpa.FlightJPARepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class FlightPersitenceRepository implements FlightRepository, FlightJPARepository {

    private static final String FLIGH_FIND_BY_ID = "Flight.findById";

    private EntityManager entityManager;

    public FlightPersitenceRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Long createFlight(Flight flight) {
        entityManager.persist(FlightBuilder.convertToEntity(flight));
        return flight.getId();
    }

    @Override
    public void updateFlight(Flight flight) {


    }

    @Override
    public void deleteFlight(Long id) {

    }

    @Override
    public boolean isValidateCalendarTime(Long idFlight) {
        return false;
    }

    @Override
    public boolean isExiste(Long idFlight) {
        return false;
    }

    @Override
    public FlightEntity getFlightEntityById(Long id) {
        return null;
    }
}
