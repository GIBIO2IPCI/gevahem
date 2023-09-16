package com.ipci.gevahem.repository;

import com.ipci.gevahem.entity.Conservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConservationRepository extends JpaRepository<Conservation, Long> {
}
