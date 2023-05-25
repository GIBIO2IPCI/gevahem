package com.ipci.gevahem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"code_client", "contact", "email"}))
public class Client {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String code_client;

    @NotBlank
    private String raison_social;

    @NotBlank
    private String responsable;

    @NotBlank
    @Column(unique = true)
    private String contact;

    @Email
    @NotBlank
    @Column(unique = true)
    private String email;

    @NotBlank
    private String adresse;

    @ManyToOne
    @JoinColumn(name = "type_client_id")
    @NotNull
    private TypeClient typeClient;

}
