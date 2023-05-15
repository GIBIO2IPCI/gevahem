package com.ipci.gevahem.repository;

import com.ipci.gevahem.entity.Ambulancier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmbulancierRepository extends JpaRepository<Ambulancier, Long> {
}