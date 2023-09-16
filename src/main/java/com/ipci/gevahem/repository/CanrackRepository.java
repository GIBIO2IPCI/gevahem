package com.ipci.gevahem.repository;

import com.ipci.gevahem.entity.Canrack;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CanrackRepository extends JpaRepository<Canrack, Long> {
    Canrack findByLibelle(String libelle);
}
