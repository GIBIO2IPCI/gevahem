package com.ipci.gevahem.service;

import com.ipci.gevahem.entity.Preparation;

import java.util.List;

public interface PreparationService {
    void addPreparation(Preparation preparation);
    void deletePreparation(Long id);
   Preparation getPreparationByID(Long id);
    List<Preparation> getAllPreparations();
}
