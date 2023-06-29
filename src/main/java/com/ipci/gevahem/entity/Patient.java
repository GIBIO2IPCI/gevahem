package com.ipci.gevahem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "contact"))
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "ce champ est obligatoire")
    private String nom;
    @NotBlank(message = "ce champ est obligatoire")
    private String prenom;
    @NotBlank(message = "ce champ est obligatoire")
    private String contact;
    @Email
    @NotBlank(message = "ce champ est obligatoire")
    private String email;
    @NotBlank(message = "ce champ est obligatoire")
    private String adresse;
    @Column(nullable = true)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_naissance;

}