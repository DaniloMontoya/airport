package co.com.ceiba.airport.infrastructure.persistence.repositories.jpa;

import co.com.ceiba.airport.infrastructure.persistence.entities.FlightEntity;

public interface FlightJPARepository {
    FlightEntity getFlightEntityById(Long id);
}
