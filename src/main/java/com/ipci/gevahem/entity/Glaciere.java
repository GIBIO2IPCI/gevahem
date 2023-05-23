package com.ipci.gevahem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank
    private Integer nombre_prelevement;
    @NotBlank
    private Integer temperature_depart;
    @NotBlank
    private Integer temperature_arrivee;
    @ManyToOne
    @NotBlank
    private Conformite conformite;
    @NotBlank
    private String cause_conformite;
    @ManyToOne
    @NotBlank
    private Ambulancier ambulancier;
    @OneToOne(mappedBy = "glaciere")
    @NotBlank
    private Reception reception;

}