package org.youcode.airafrika.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "company")
public class Company {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "company" , cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Plan> Plans ;

}