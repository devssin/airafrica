package org.youcode.airafrika.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "extra")
public class Extra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Double price;


    @ManyToMany(mappedBy = "extras")
    private List<VolReservation> volReservations;
}
