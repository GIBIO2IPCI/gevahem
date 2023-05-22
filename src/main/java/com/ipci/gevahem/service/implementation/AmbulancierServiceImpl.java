package com.ipci.gevahem.service.implementation;

import com.ipci.gevahem.entity.Ambulancier;
import com.ipci.gevahem.repository.AmbulancierRepository;
import com.ipci.gevahem.service.AmbulancierService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AmbulancierServiceImpl implements AmbulancierService {
    private AmbulancierRepository ambulancierRepository;

    @Override
    public List<Ambulancier> getAllAmbulancier() {
        return ambulancierRepository.findAll();
    }

    @Override
    public void saveAmbulancier(Ambulancier ambulancier) {
        ambulancierRepository.save(ambulancier);
    }

    @Override
    public Ambulancier getAmbulancierById(Long id) {
        return ambulancierRepository.findById(id).orElse(null);
    }

    @Override
    public Ambulancier updateAmbulancier(Ambulancier ambulancier) {
        Ambulancier existingAmbulancier = ambulancierRepository.findById(ambulancier.getId()).orElse(null);
        assert existingAmbulancier != null;
        existingAmbulancier.setNom(ambulancier.getNom());
        existingAmbulancier.setContact(ambulancier.getContact());
        return ambulancierRepository.save(existingAmbulancier);
    }

    @Override
    public void deleteAmbulancierById(Long id) {
        ambulancierRepository.deleteById(id);
    }

}
