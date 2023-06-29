package com.ipci.gevahem.repository;

import com.ipci.gevahem.entity.TypePrelevement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypePrelevementRepository extends JpaRepository<TypePrelevement, Long> {
    TypePrelevement findByLibelle(Integer libelle);
}