package com.ipci.gevahem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Boite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer capacite;
    private String libelle;
    @ManyToOne
    private TypeBoite typeBoite;
    @OneToMany
    private List<ContenuBoite> contenuBoite = new ArrayList<>();


}