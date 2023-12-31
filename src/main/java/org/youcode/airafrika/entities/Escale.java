package org.youcode.airafrika.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "escale")
public class Escale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String escale_city;
    private int duration;
    @ManyToOne()
    @JoinColumn(name = "vol_id")
    private Vol vol;
}
