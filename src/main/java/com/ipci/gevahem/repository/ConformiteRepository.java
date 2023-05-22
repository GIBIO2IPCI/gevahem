package com.ipci.gevahem.repository;

import com.ipci.gevahem.entity.Conformite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConformiteRepository extends JpaRepository<Conformite, Long> {
    Conformite findByLibelle(String libelle);
}