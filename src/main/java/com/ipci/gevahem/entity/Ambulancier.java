package com.ipci.gevahem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Ambulancier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String contact;
    @OneToMany(mappedBy = "ambulancier", fetch = FetchType.EAGER)
    private Collection<Glaciere> glaciere;
    @OneToMany(mappedBy = "ambulancier")
    private Collection<Reception> reception;

}