package com.ipci.gevahem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Glaciere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    @NotBlank
    private String libelle;
    @NotNull
    private Integer nombre_prelevement;
    private Integer temperature_depart;
    private Integer temperature_arrivee;
    @ManyToOne
    @NotNull
    private Conformite conformite;
    private String cause_conformite;
    @ManyToOne
    @NotNull

    private Ambulancier ambulancier;
    @OneToOne(mappedBy = "glaciere", cascade = CascadeType.ALL, orphanRemoval = true)
    private Reception reception;
    @ManyToOne
    @NotNull
    private Client client;
    @ManyToOne
    private Etude etude;
    @OneToMany(mappedBy = "glaciere", orphanRemoval = true)
    private List<Prelevement> prelevements = new ArrayList<>();
}

