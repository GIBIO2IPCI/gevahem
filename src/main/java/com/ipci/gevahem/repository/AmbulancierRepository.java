package com.ipci.gevahem.repository;

import com.ipci.gevahem.entity.Ambulancier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AmbulancierRepository extends JpaRepository<Ambulancier, Long> {
}