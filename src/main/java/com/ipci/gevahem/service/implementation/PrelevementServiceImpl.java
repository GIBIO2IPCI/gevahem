package com.ipci.gevahem.service.implementation;

import com.ipci.gevahem.entity.Glaciere;
import com.ipci.gevahem.entity.Prelevement;
import com.ipci.gevahem.repository.GlaciereRepository;
import com.ipci.gevahem.repository.PrelevementRepository;
import com.ipci.gevahem.service.GlaciereService;
import com.ipci.gevahem.service.PrelevementService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PrelevementServiceImpl implements PrelevementService {
    private PrelevementRepository prelevementRepository;

    @Override
    public List<Prelevement> getAllPrelevement() {
        return prelevementRepository.findAll();
    }

    @Override
    public void savePrelevement(Prelevement prelevement) {
        prelevementRepository.save(prelevement);
    }

    @Override
    public Prelevement getPrelevementByLibelle(String libelle) {
        return prelevementRepository.findByLibelle(libelle);
    }

    @Override
    public Prelevement getPrelevementById(long id) {
        return prelevementRepository.findById(id).orElse(null);
    }

    @Override
    public void deletePrelevementById(Long id) {
        prelevementRepository.deleteById(id);
    }
}
