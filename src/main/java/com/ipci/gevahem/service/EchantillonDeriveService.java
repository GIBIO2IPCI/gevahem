package com.ipci.gevahem.service;

import com.ipci.gevahem.entity.EchantillonDerive;
import com.ipci.gevahem.entity.Preparation;

import java.util.List;
import java.util.Optional;

public interface EchantillonDeriveService {
    List<EchantillonDerive> getAllEchantillonDerive();
    void addEchantillonDerive(EchantillonDerive echantillonDerive);

    Optional<EchantillonDerive> getEchantillonDeriveById(long id);

    void deleteEchantillonDeriveById(Long id);
}
