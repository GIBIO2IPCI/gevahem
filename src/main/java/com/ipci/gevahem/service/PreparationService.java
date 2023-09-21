package com.ipci.gevahem.service;

import com.ipci.gevahem.entity.Preparation;
import com.ipci.gevahem.entity.Reception;

import java.util.List;

public interface PreparationService {
    void addPreparation(Preparation preparation);
    void deletePreparation(Long id);
   Preparation getPreparationByID(Long id);
    List<Preparation> getAllPreparations();
    List<Preparation> getByDate(String format);
}
