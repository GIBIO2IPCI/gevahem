package com.ipci.gevahem.repository;

import com.ipci.gevahem.entity.Reception;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceptionRepository extends JpaRepository<Reception, Long> {
    Reception findByCodeAndGlaciere_Libelle(String code, String libelle);
}