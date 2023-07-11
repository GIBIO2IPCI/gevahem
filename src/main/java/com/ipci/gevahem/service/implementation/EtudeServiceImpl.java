package com.ipci.gevahem.service.implementation;

import com.ipci.gevahem.entity.Etude;
import com.ipci.gevahem.repository.EtudeRepository;
import com.ipci.gevahem.service.EtudeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EtudeServiceImpl implements EtudeService {
    private EtudeRepository etudeRepository;

    @Override
    public List<Etude> getAllEtude() {
        return etudeRepository.findAll();
    }
}
