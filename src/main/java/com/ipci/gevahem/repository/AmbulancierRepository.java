package com.ipci.gevahem.repository;

import com.ipci.gevahem.entity.Ambulancier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AmbulancierRepository extends JpaRepository<Ambulancier, Long> {
    Ambulancier findByContact(String contact);
}