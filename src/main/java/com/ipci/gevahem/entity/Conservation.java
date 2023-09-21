package com.ipci.gevahem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Conservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String code;
    @Temporal(TemporalType.DATE)
    private Date date_conservation;

    @ManyToOne
    private ContenuBoite contenuBoite;

    @ManyToOne
    @NotNull
    private Boite boite;

    @ManyToOne
    @NotNull
    private Canrack canrack;

    @ManyToOne
    @NotNull
    private Cryoconservateur cryoconservateur;

    @OneToOne
    private EchantillonDerive echantillonDerive;
}
