package com.ipci.gevahem.service.implementation;

import com.ipci.gevahem.entity.Canrack;
import com.ipci.gevahem.repository.CanrackRepository;
import com.ipci.gevahem.service.CanrackService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CanrackServiceImpl implements CanrackService {
    private final CanrackRepository canrackRepository;
    @Override
    public List<Canrack> getAllCanrack() {
        return canrackRepository.findAll();
    }

    @Override
    public Canrack getCanrackByLibelle(String libelle) {
        return canrackRepository.findByLibelle(libelle);
    }

    @Override
    public Canrack getCanrackById(long id) {
        return canrackRepository.findById(id).orElse(null);
    }
}
