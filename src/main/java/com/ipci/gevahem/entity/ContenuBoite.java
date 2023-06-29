package com.ipci.gevahem.entity;

import jakarta.persistence.*;
import lombok.*;

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
    @ManyToOne
    private TypeContenuBoite typeContenuBoite;

}