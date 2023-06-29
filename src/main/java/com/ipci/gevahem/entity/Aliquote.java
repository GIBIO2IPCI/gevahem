package com.ipci.gevahem.entity;

import jakarta.persistence.*;
import lombok.*;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Aliquote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Float volume;
    private Integer numero;
    @ManyToOne
    private EchantillonDerive echantillonDerive;

}