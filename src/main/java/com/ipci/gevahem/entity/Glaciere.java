package com.ipci.gevahem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "glaciere")
public class Glaciere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String libelle_glaciere;
    private Integer nombre_prelevement;
    private Integer temperature_depart;
    private Integer temperature_arrivee;
    @ManyToOne
    private Conformite conformite;
    private String cause_non_conformite;

    @ManyToOne
    private Ambulancier ambulancier;

}