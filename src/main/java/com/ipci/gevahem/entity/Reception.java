package com.ipci.gevahem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Reception {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date date_reception;
    @OneToOne
    private Glaciere glaciere;

}