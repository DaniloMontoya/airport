package co.com.ceiba.airport.infrastructure.persistence.repositories.jpa;

import co.com.ceiba.airport.infrastructure.persistence.entities.FlightEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightJPARepository extends CrudRepository<FlightEntity, Long> {


}
