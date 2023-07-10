package com.ipci.gevahem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "libelle"))
@Entity
public class Prelevement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    @NotBlank(message = "ce champ est obligatoire")
    @Column(unique = true)
    private String libelle;
    @NotBlank(message = "ce champ est obligatoire")
    private String unite;
    private String cause_conformite;
    @NotNull(message = "ce champ est obligatoire")
    private float volume;
    @NotNull(message = "ce champ est obligatoire")
    @ManyToOne
    private Patient patient;
    @NotNull(message = "ce champ est obligatoire")
    @ManyToOne
    private Conformite conformite;
    @NotNull(message = "ce champ est obligatoire")
    @ManyToOne
    private TypePrelevement typePrelevement;
    @NotNull(message = "ce champ est obligatoire")
    @OneToMany
    private List<Analyse> analyse = new ArrayList<>();
    @ManyToOne
    @NotNull(message = "ce champ est obligatoire")
    private Glaciere glaciere;

}