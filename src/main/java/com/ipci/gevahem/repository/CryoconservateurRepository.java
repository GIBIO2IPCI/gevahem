package com.ipci.gevahem.repository;


import com.ipci.gevahem.entity.Cryoconservateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CryoconservateurRepository extends JpaRepository<Cryoconservateur, Long> {

    Cryoconservateur findByNom(String nom);
}
