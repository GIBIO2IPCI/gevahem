package com.ipci.gevahem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Reception {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    @Temporal(TemporalType.DATE)
    private Date date_reception;
    @OneToOne
    @JoinColumn
    @NotNull(message = "ce champ est obligatoire")
    private Glaciere glaciere;

}