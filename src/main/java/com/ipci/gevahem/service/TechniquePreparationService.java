package com.ipci.gevahem.service;

import com.ipci.gevahem.entity.TechniquePreparation;

import java.util.List;

public interface TechniquePreparationService {

    TechniquePreparation getTechniquePreparationByPreparationId(long id);
    TechniquePreparation getTechniquePreparationByLibelle(String libelle);
    List<TechniquePreparation> getAllTechniquePreparation();
    void saveTechniquePreparation(TechniquePreparation techniquePreparation);
    void deleteTechniquePreparationById(long id);

}
