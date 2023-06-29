package com.ipci.gevahem.service.implementation;

import com.ipci.gevahem.entity.Analyse;
import com.ipci.gevahem.entity.Conformite;
import com.ipci.gevahem.repository.AnalyseRepository;
import com.ipci.gevahem.repository.ConformiteRepository;
import com.ipci.gevahem.service.AnalyseService;
import com.ipci.gevahem.service.ConformiteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AnalyseServiceImpl implements AnalyseService {
    private final AnalyseRepository analyseRepository;

    @Override
    public Analyse getAnalyseByLibelle(Integer libelle) {
        return analyseRepository.findByLibelle(libelle) ;
    }

    @Override
    public List<Analyse> getAllAnalyse() {
        return analyseRepository.findAll();
    }

    @Override
    public void savePrelevement(Analyse analyse) {
        analyseRepository.save(analyse);
    }

    @Override
    public Analyse getAnalyseById(long id) {
        return analyseRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteAnalyseById(Long id) {
        analyseRepository.deleteById(id);
    }
}
