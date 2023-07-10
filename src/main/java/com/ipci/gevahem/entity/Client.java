package com.ipci.gevahem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    public Long id;
    private String code;
    @NotBlank
    private String raison_sociale;
    @NotBlank
    private String responsable_client;
    @NotBlank
    private String contact;
    @NotBlank
    @Email
    @Column(unique = true)
    private String email;
    @NotBlank
    private String adresse;
    @ManyToOne
    @NotNull
    private TypeClient typeClient;

}
