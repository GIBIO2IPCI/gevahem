package com.ipci.gevahem.service.implementation;

import com.ipci.gevahem.entity.Cryoconservateur;
import com.ipci.gevahem.repository.CryoconservateurRepository;
import com.ipci.gevahem.service.CryoconservateurService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CryoconservateurServiceImpl implements CryoconservateurService {
    private CryoconservateurRepository cryoconservateurRepository;
    @Override
    public Cryoconservateur getCryoconservateurByNom(String nom) {
        return cryoconservateurRepository.findByNom(nom) ;
    }

    @Override
    public List<Cryoconservateur> getAllCryoconservateur() {
        return cryoconservateurRepository.findAll();
    }

    @Override
    public Cryoconservateur getCryoconservateurById(long id) {
        return cryoconservateurRepository.findById(id).orElse(null);
    }

    @Override
    public void saveCryoconservateur(Cryoconservateur cryoconservateur) {
        cryoconservateurRepository.save(cryoconservateur);
    }

    @Override
    public void deleteCryoconservateurById(long id) {
        cryoconservateurRepository.deleteById(id);
    }
}
