package com.ipci.gevahem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Preparation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private Integer nombre;

    private Integer nombreRestant;

    private Float volumeRestant;

    @Temporal(TemporalType.DATE)
    private Date datePreparation;

    @ManyToOne
    @NotNull
    private Prelevement prelevement;

    @NotBlank
    private String technique_preparation;

}