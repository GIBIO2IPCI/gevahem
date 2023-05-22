package com.ipci.gevahem.repository;

import com.ipci.gevahem.entity.TypeClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeClientRepository extends JpaRepository<TypeClient, Long> {
    TypeClient findByLibelle(String libelle);
}