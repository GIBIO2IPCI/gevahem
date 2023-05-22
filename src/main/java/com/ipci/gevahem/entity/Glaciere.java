package com.ipci.gevahem.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Glaciere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    private Integer nombre;
    private Integer temperature_depart;
    private Integer temperature_arrivee;
    @ManyToOne
    private Conformite conformite;
    private String cause_non_conformite;
    @ManyToOne
    private Ambulancier ambulancier;
    @OneToOne(mappedBy = "glaciere")
    private Reception reception;

}