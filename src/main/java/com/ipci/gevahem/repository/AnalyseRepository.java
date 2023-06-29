package com.ipci.gevahem.repository;

import com.ipci.gevahem.entity.Analyse;
import com.ipci.gevahem.entity.Conformite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnalyseRepository extends JpaRepository<Analyse, Long> {
    Analyse findByLibelle(Integer libelle);
}