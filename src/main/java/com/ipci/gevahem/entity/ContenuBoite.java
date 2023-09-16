package com.ipci.gevahem.entity;

import jakarta.persistence.*;
import lombok.*;


import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ContenuBoite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String couleur;
    private Integer capacite;
    @OneToMany
    private List<EchantillonDerive> echantillonDerives;
    @ManyToOne
    private TypeContenuBoite typeContenuBoite;

}