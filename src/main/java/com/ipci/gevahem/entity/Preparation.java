package com.ipci.gevahem.entity;

import jakarta.persistence.*;
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
    private Prelevement prelevement;
    @ElementCollection
    private Set<String> technique_preparation;

}