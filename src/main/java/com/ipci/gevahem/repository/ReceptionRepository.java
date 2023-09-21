package com.ipci.gevahem.repository;

import com.ipci.gevahem.entity.Reception;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ReceptionRepository extends JpaRepository<Reception, Long> {

}