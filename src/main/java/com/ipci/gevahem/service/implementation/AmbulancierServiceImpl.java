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
    public Ambulancier getAmbulancierById(long id) {
        return ambulancierRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteAmbulancierById(long id) {
        ambulancierRepository.deleteById(id);
    }

}
