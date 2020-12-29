package co.com.ceiba.airport.infrastructure.persistence.repositories;

import co.com.ceiba.airport.domain.models.entities.Flight;
import co.com.ceiba.airport.domain.ports.repositories.FlightRepository;
import co.com.ceiba.airport.infrastructure.persistence.builder.FlightBuilder;
import co.com.ceiba.airport.infrastructure.persistence.entities.FlightEntity;
import co.com.ceiba.airport.infrastructure.persistence.repositories.jpa.FlightJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class FlightPersitenceRepository implements FlightRepository {

    @Autowired
    FlightJPARepository flightJPARepository;

    @Override
    public Flight getFlight(String id) {
        FlightEntity flightEntity;
        Optional flightquery = flightJPARepository.findById(id);
        flightEntity = (FlightEntity) flightquery.get();
        return FlightBuilder.convertToDomain(flightEntity);
    }

    @Override
    public List<Flight> getAllFlight() {
        List<Flight> flightList = new ArrayList<>();
        List<FlightEntity> flightEntityList = new ArrayList<>();
        Iterable<FlightEntity> flightListSource = flightJPARepository.findAll();
        flightListSource.forEach(flightEntityList::add);
        flightEntityList.forEach((final FlightEntity flightEntity) -> flightList.add(FlightBuilder.convertToDomain(flightEntity)));
        return flightList;
    }

    @Override
    public String createFlight(Flight flight) {
        return flightJPARepository.save(FlightBuilder.convertToEntity(flight)).getId();
    }

    @Override
    public void updateFlight(Flight flight) {
        flightJPARepository.save(FlightBuilder.convertToEntity(flight));
    }

    @Override
    public void deleteFlight(String id) {
        flightJPARepository.deleteById(id);
    }

    @Override
    public boolean isExiste(String idFlight) {
        return flightJPARepository.existsById(idFlight);
    }
}
