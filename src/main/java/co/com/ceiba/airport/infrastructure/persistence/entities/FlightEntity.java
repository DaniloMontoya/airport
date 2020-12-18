package co.com.ceiba.airport.infrastructure.persistence.entities;

import co.com.ceiba.airport.domain.models.dto.ArrivalDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "Flight")
@NamedQuery(name = "Flight.findById", query = "SELECT flight FROM Flight flight WHERE flight.id = :id")
@Getter
@Setter
public class FlightEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private long time;

    @Column(nullable = false)
    private float cost;

    @Column(nullable = false)
    private boolean isReprogrammed;

    @OneToOne
    @JoinColumn(name="ID_ARRIVAL", referencedColumnName = "id")
    private ArrivalEntity arrivalEntity;




}
