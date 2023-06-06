package com.ipci.gevahem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    public Long id;
    @NotBlank
    private String raison_sociale;
    @NotBlank
    private String responsable_client;
    @NotBlank
    private String contact;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String adresse;
    @ManyToOne
    @JoinColumn(name = "type_client_id")
    private TypeClient typeClient;

}
