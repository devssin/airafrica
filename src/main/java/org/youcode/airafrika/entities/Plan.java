package org.youcode.airafrika.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "plan")
public class Plan {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy="plan", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Vol> Vols;

    @ManyToOne()
    @JoinColumn(name = "company_id")
    Company company;


}