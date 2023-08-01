package com.ipci.gevahem.service.implementation;

import com.ipci.gevahem.entity.Preparation;
import com.ipci.gevahem.repository.PreparationRepository;
import com.ipci.gevahem.service.PreparationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PreparationServiceImpl implements PreparationService {

    private final PreparationRepository preparationRepository;
    @Override
    public void addPreparation(Preparation preparation) {
        preparationRepository.save(preparation);
    }

    @Override
    public void deletePreparation(Long id) {
        preparationRepository.deleteById(id);
    }

    @Override
    public Object getPreparationByID(Long id) {
        return preparationRepository.findById(id);
    }

    @Override
    public Object getAllPreparations() {
        return preparationRepository.findAll();
    }
}
