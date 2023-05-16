package com.ipci.gevahem.service.implementation;

import com.ipci.gevahem.entity.Glaciere;
import com.ipci.gevahem.repository.GlaciereRepository;
import com.ipci.gevahem.service.GlaciereService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GlaciereServiceImpl implements GlaciereService {
    private GlaciereRepository glaciereRepository;
    @Override
    public void saveGlaciere(Glaciere glaciere) {
        glaciereRepository.save(glaciere);
    }
}
