package com.ipci.gevahem.entity;

import jakarta.persistence.*;
import lombok.*;

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

    @ManyToOne
    private Prelevement prelevement;

    @ManyToMany
    @JoinTable(name = "preparation_technique_preparations",
            joinColumns = @JoinColumn(name = "preparation_id"),
            inverseJoinColumns = @JoinColumn(name = "technique_preparations_id"))
    private Set<TechniquePreparation> techniquePreparations = new LinkedHashSet<>();

}