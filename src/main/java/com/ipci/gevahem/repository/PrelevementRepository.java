package com.ipci.gevahem.repository;

import com.ipci.gevahem.entity.Conformite;
import com.ipci.gevahem.entity.Prelevement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrelevementRepository extends JpaRepository<Prelevement, Long> {
    Prelevement findByLibelle(String libelle);
    List<Prelevement> findByConformiteLibelle(String libelle);
    Prelevement findByCodeAndConformite(String code, Conformite conformite);
}