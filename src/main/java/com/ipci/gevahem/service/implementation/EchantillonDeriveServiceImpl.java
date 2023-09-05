package com.ipci.gevahem.service.implementation;

import com.ipci.gevahem.entity.EchantillonDerive;
import com.ipci.gevahem.entity.Preparation;
import com.ipci.gevahem.repository.EchantillonDeriveRepository;
import com.ipci.gevahem.repository.TypePrelevementRepository;
import com.ipci.gevahem.service.EchantillonDeriveService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EchantillonDeriveServiceImpl implements EchantillonDeriveService {
    private EchantillonDeriveRepository echantillonDeriveRepository;
    private TypePrelevementRepository typePrelevementRepository;
    @Override
    public List<EchantillonDerive> getAllEchantillonDerive() {
        return echantillonDeriveRepository.findAll();
    }

    @Override
    public void addEchantillonDerive(EchantillonDerive echantillonDerive) {
        echantillonDeriveRepository.save(echantillonDerive);
    }

    @Override
    public Optional<EchantillonDerive> getEchantillonDeriveById(long id) {
        return echantillonDeriveRepository.findById(id);
    }

    @Override
    public void deleteEchantillonDeriveById(Long id) {
        echantillonDeriveRepository.deleteById(id);
    }
}
