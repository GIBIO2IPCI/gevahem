package com.ipci.gevahem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Collection;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class TypeClient {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotBlank
    private String libelle;
}