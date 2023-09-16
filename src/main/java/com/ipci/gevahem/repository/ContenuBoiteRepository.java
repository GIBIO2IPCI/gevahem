package com.ipci.gevahem.repository;

import com.ipci.gevahem.entity.ContenuBoite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContenuBoiteRepository extends JpaRepository<ContenuBoite, Long> {
    ContenuBoite findByCouleur(String couleur);
}
