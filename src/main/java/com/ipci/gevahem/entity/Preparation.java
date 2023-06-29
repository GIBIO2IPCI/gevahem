package com.ipci.gevahem.entity;

import jakarta.persistence.*;
import lombok.*;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Preparation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer nombre;
    @ManyToOne
    private TechniquePreparation techniquePreparation;
    @ManyToOne
    private Prelevement prelevement;

}