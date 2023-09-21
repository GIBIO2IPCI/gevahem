package com.ipci.gevahem.service;

import com.ipci.gevahem.entity.EchantillonDerive;

import java.util.List;

public interface EchantillonDeriveService {
    List<EchantillonDerive> getAllEchantillonDerive();
    void addEchantillonDerive(EchantillonDerive echantillonDerive);

    EchantillonDerive getEchantillonDeriveById(long id);

    void deleteEchantillonDeriveById(Long id);
}
