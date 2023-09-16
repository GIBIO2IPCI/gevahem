package com.ipci.gevahem.service.implementation;

import com.ipci.gevahem.entity.Conformite;
import com.ipci.gevahem.repository.ConformiteRepository;
import com.ipci.gevahem.service.ConformiteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ConformiteServiceImpl implements ConformiteService {
    private final ConformiteRepository conformiteRepository;

    @Override
    public Conformite getConformiteByLibelle(String libelle) {

        return conformiteRepository.findByLibelle(libelle) ;
    }

    @Override
    public List<Conformite> getAllConformite() {

        return conformiteRepository.findAll();
    }

    @Override
    public void saveGlaciere(Conformite conformite) {

        conformiteRepository.save(conformite);
    }

    @Override
    public Conformite getConformiteById(long id) {

        return conformiteRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteConformiteById(Long id) {
        conformiteRepository.deleteById(id);
    }
}
