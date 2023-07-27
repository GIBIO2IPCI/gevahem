package com.ipci.gevahem.service;

import com.ipci.gevahem.entity.Preparation;

public interface PreparationService {
    void addPreparation(Preparation preparation);
    void deletePreparation(Long id);
    Object getPreparationByID(Long id);
    Object getAllPreparations();
}
