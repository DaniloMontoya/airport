package co.com.ceiba.airport.infrastructure.persistence.repositories;

import co.com.ceiba.airport.domain.models.entities.Flight;
import co.com.ceiba.airport.domain.ports.repositories.FlightRepository;
import co.com.ceiba.airport.infrastructure.persistence.builder.FlightBuilder;
import co.com.ceiba.airport.infrastructure.persistence.entities.FlightEntity;
import co.com.ceiba.airport.infrastructure.persistence.repositories.jpa.FlightJPARepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class FlightPersitenceRepository implements FlightRepository, FlightJPARepository {

    private static final String FLIGH_FIND_BY_ID = "Flight.findById";
    private static final String ID = "id";

    private EntityManager entityManager;

    public FlightPersitenceRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Flight getFlight(Long id) {
        FlightEntity flightEntity = getFlightEntityById(id);
        return FlightBuilder.convertToDomain(flightEntity);
    }

    @Override
    public List<Flight> getAllFlight() {
        return null;
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
        FlightEntity flightEntity = getFlightEntityById(idFlight);
        if(flightEntity == null){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public FlightEntity getFlightEntityById(Long id) {
        Query query = entityManager.createNamedQuery(FLIGH_FIND_BY_ID);
        query.setParameter(ID, id);
        return (FlightEntity) query.getSingleResult();
    }
}
