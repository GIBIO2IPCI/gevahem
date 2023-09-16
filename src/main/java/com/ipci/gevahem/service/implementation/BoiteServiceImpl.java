package com.ipci.gevahem.service.implementation;

import com.ipci.gevahem.entity.Boite;
import com.ipci.gevahem.repository.BoiteRepository;
import com.ipci.gevahem.service.BoiteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BoiteServiceImpl implements BoiteService {
    private final BoiteRepository boiteRepository;
    @Override
    public List<Boite> getAllBoite() {
        return boiteRepository.findAll();
    }

    @Override
    public Boite getBoiteByLibelle(String libelle) {
        return boiteRepository.findByLibelle(libelle);
    }

    @Override
    public Boite getBoiteById(long id) {
        return boiteRepository.findById(id).orElse(null);
    }
}
