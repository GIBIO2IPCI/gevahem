package com.ipci.gevahem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Prelevement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    private String unite;
    private String cause_conformite;
    private Float volume;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Conformite conformite;
    @ManyToOne
    private TypePrelevement typePrelevement;
    @OneToMany
    private List<Analyse> analyse = new ArrayList<>();
    @ManyToOne
    private Glaciere glaciere;

}