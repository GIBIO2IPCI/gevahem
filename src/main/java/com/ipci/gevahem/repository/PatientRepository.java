package com.ipci.gevahem.repository;

import com.ipci.gevahem.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByContact(String contact);
}