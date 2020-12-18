package co.com.ceiba.airport.domain.ports.dao;

import co.com.ceiba.airport.domain.models.dto.ArrivalDTO;

import java.util.List;

public interface ArrivalDAO {

    List<ArrivalDTO> getAllArrivals();
    ArrivalDTO getArrivalByName();
}
