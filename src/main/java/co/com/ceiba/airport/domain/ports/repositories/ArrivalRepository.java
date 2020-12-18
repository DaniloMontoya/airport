package co.com.ceiba.airport.domain.ports.repositories;

import co.com.ceiba.airport.domain.models.entities.Arrival;

public interface ArrivalRepository {
    void createArrival(Arrival arrival);
    void deleteArrival(String name);
}
