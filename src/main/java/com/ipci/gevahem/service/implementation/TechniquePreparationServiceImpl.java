package com.ipci.gevahem.service.implementation;

import com.ipci.gevahem.entity.TechniquePreparation;
import com.ipci.gevahem.repository.TechniquePreparationRepository;
import com.ipci.gevahem.service.TechniquePreparationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TechniquePreparationServiceImpl implements TechniquePreparationService {

    private final TechniquePreparationRepository techniquePreparationRepository;
    @Override
    public TechniquePreparation getTechniquePreparationByPreparationId(long id) {
        return techniquePreparationRepository.findById(id).orElse(null);
    }

    @Override
    public TechniquePreparation getTechniquePreparationByLibelle(String libelle) {
        return techniquePreparationRepository.findByLibelle(libelle);
    }

    @Override
    public List<TechniquePreparation> getAllTechniquePreparation() {
        return techniquePreparationRepository.findAll();
    }

    @Override
    public void saveTechniquePreparation(TechniquePreparation techniquePreparation) {
        techniquePreparationRepository.save(techniquePreparation);
    }

    @Override
    public void deleteTechniquePreparationById(long id) {
        techniquePreparationRepository.deleteById(id);
    }
}
