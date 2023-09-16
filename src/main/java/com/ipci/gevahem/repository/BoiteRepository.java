package com.ipci.gevahem.repository;

import com.ipci.gevahem.entity.Boite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoiteRepository extends JpaRepository<Boite, Long> {
   Boite findByLibelle(String libelle);

}
