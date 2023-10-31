package org.youcode.airafrika.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "vol")
@Getter
@Setter
public class Vol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date starts_at;
    private Date arrives_at;
    private String start_city;
    private String arrive_city;
    private double price;

    @ManyToOne()
    @JoinColumn(name = "plan_id")
    Plan plan;

    @OneToMany(mappedBy = "vol", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Escale> escales;

    @OneToMany(mappedBy = "vol", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<VolReservation> volReservations;



}

