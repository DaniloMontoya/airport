package co.com.ceiba.airport.infrastructure.persistence.repositories.jpa;

import co.com.ceiba.airport.infrastructure.persistence.entities.ArrivalEntity;

public interface ArrivalJPARepository {
    ArrivalEntity getArrivalByName(String name);
}
