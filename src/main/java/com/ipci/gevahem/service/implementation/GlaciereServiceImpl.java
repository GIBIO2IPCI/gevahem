package com.ipci.gevahem.service.implementation;

import com.ipci.gevahem.entity.Glaciere;
import com.ipci.gevahem.repository.GlaciereRepository;
import com.ipci.gevahem.service.GlaciereService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GlaciereServiceImpl implements GlaciereService {
    private GlaciereRepository glaciereRepository;

    @Override
    public List<Glaciere> getAllGlaciere() {
        return glaciereRepository.findAll();
    }

    @Override
    public void saveGlaciere(Glaciere glaciere) {
        glaciereRepository.save(glaciere);
    }

    @Override
    public Glaciere getGlaciereById(long id) {
        return glaciereRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteGlaciereById(Long id) {
        glaciereRepository.deleteById(id);
    }
}
