package com.ipci.gevahem.repository;

import com.ipci.gevahem.entity.Conformite;
import com.ipci.gevahem.entity.Prelevement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrelevementRepository extends JpaRepository<Prelevement, Long> {
    Prelevement findByLibelle(String libelle);

    Prelevement findByConformite(String conformite);
    Prelevement findByCodeAndConformite(String code, Conformite conformite);
}