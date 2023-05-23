package com.ipci.gevahem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "libelle"))
public class Glaciere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(unique = true)
    private String libelle;
    @NotNull
    private Integer nombre_prelevement;
    @NotNull
    private Integer temperature_depart;
    @NotNull
    private Integer temperature_arrivee;
    @ManyToOne
    @NotNull
    private Conformite conformite;
    @NotBlank
    private String cause_conformite;
    @ManyToOne
    @NotNull
    private Ambulancier ambulancier;
    @OneToOne(mappedBy = "glaciere")
    private Reception reception;

}