package com.ipci.gevahem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "reception")
public class Reception {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date date_reception;

    @OneToOne(orphanRemoval = true)
    private Glaciere glaciere;

}