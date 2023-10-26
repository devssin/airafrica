package org.youcode.airafrika.entities;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "passager")
public class Passager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private String phone_number;

    @OneToMany(mappedBy = "passager", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<VolReservation> volReservations;

}