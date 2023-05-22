package com.ipci.gevahem.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Client {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code_client;
    private String raison_social;
    private String responsable;
    private String contact;
    private String email;
    private String adresse;
    @ManyToOne
    private TypeClient type;
}
