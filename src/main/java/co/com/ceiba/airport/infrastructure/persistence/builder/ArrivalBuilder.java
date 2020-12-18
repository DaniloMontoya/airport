package co.com.ceiba.airport.infrastructure.persistence.builder;

import co.com.ceiba.airport.domain.models.entities.Arrival;
import co.com.ceiba.airport.infrastructure.persistence.entities.ArrivalEntity;

public class ArrivalBuilder {

    private ArrivalBuilder(){}

    public static Arrival convertToDomain(ArrivalEntity arrivalEntity){
        Arrival arrival = null;

        if(arrivalEntity != null){
            arrival = new Arrival(arrivalEntity.getId(), arrivalEntity.getName(), arrivalEntity.getLatitude(), arrivalEntity.getLenght());
        }

        return arrival;
    }

    public static ArrivalEntity convertToEntity(Arrival arrival){
        ArrivalEntity arrivalEntity = new ArrivalEntity();
        arrivalEntity.setId(arrival.getId());
        arrivalEntity.setName(arrival.getName());
        arrivalEntity.setLatitude(arrivalEntity.getLatitude());
        arrivalEntity.setLenght(arrivalEntity.getLenght());
        return arrivalEntity;
    }
}
