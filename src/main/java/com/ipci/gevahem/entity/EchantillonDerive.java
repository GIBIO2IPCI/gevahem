package com.ipci.gevahem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class EchantillonDerive {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String unite;
    private Float volume;
    private Integer conformite;
    @ManyToOne
    private Prelevement prelevement;
    @ManyToOne
    private TypePrelevement typePrelevement;
    @OneToMany
    private List<Preparation> preparation = new ArrayList<>();
}