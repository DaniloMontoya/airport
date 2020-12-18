package co.com.ceiba.airport.infrastructure.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "Arrival")
@NamedQuery(name = "Arrival.findByName", query = "SELECT arrival FROM Arrival arrival WHERE arrival.name = :name")
@Getter
@Setter
public class ArrivalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private float latitude;

    @Column(nullable = false)
    private float lenght;


}
