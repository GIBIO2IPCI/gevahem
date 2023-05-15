package com.ipci.gevahem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Client {
    @Id
    private Long id;
    private String code_client;
    private String raison_sociale;
    private String responsable_client;
    private String contact_client;
    private String email_client;
    private String adresse_client;
    @ManyToOne
    private TypeClient type_client;

}
