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

    @NotNull
    private String unite;

    @NotNull
    private Float volume;

    @ManyToOne
    @JoinColumn(name = "prelevement_id")
    private Prelevement prelevement;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "type_prelevement_id")
    private TypePrelevement typePrelevement;

}