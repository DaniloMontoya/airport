package co.com.ceiba.airport.infrastructure.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "flight")
@Getter
@Setter
public class FlightEntity {

    @Id
    @Column(nullable = false)
    private String id;

    @Column(nullable = false)
    private LocalDateTime timeDeparture;

    @Column(nullable = false)
    private String arrival;

    @Column(nullable = false)
    private float cost;

    @Column(nullable = false)
    private boolean isReprogrammed;

}
