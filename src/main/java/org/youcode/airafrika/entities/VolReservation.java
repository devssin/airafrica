package org.youcode.airafrika.entities;

import jakarta.persistence.*;
import org.youcode.airafrika.enums.ClassType;
import org.youcode.airafrika.enums.Status;

import java.util.List;

@Entity
@Table(name = "vol_reservation")
public class VolReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Status status;
    private ClassType class_type;
    private int sit_number;
    private Double price;

    @ManyToOne()
    @JoinColumn(name = "passager_id")
    private Passager passager;

    @ManyToOne()
    @JoinColumn(name = "vol_id")
    private Vol vol;

    @ManyToMany
    @JoinTable(
            name = "vol_reservation_extra",
            joinColumns = @JoinColumn(name = "vol_reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "extra_id")
    )
    private List<Extra> extras;
}
