package com.ipci.gevahem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class TypeClient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    @OneToMany(mappedBy = "type", fetch = FetchType.EAGER)
    private Collection<Client> client;
}