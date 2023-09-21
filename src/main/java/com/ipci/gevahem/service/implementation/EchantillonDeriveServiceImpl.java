package com.ipci.gevahem.service.implementation;

import com.ipci.gevahem.entity.EchantillonDerive;
import com.ipci.gevahem.repository.EchantillonDeriveRepository;
import com.ipci.gevahem.service.EchantillonDeriveService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EchantillonDeriveServiceImpl implements EchantillonDeriveService {

    private EchantillonDeriveRepository echantillonDeriveRepository;
    private PrelevementServiceImpl prelevementService;

    @Override
    public List<EchantillonDerive> getAllEchantillonDerive() {

        return echantillonDeriveRepository.findAll();
    }

    @Override
    public void addEchantillonDerive(EchantillonDerive echantillonDerive) {

        echantillonDerive.setLibelle(echantillonDerive.getTypePrelevement().getLibelle() + echantillonDerive.getPrelevement().getLibelle());
        echantillonDeriveRepository.save(echantillonDerive);
    }

    @Override
    public EchantillonDerive getEchantillonDeriveById(long id) {

        return echantillonDeriveRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteEchantillonDeriveById(Long id) {

        echantillonDeriveRepository.deleteById(id);
    }
}
