package com.ipci.gevahem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cryoconservateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private Float volume;
    private String unite;
    private Integer temperature;
    @OneToMany
    private List<Canrack> canrack = new ArrayList<>();

}