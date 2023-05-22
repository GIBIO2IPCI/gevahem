package com.ipci.gevahem.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Conformite {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;

}