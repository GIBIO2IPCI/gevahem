package com.ipci.gevahem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class EchantillonDerive {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    @NotBlank
    private String unite;
    @NotNull
    private Float volume;
    @NotNull
    @ManyToOne
    private Prelevement prelevement;
    @NotNull
    @ManyToOne
    private TypePrelevement typePrelevement;
    @OneToMany
    private List<Preparation> preparation = new ArrayList<>();
}