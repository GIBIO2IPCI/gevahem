package com.ipci.gevahem.service.implementation;

import com.ipci.gevahem.entity.ContenuBoite;
import com.ipci.gevahem.repository.ContenuBoiteRepository;
import com.ipci.gevahem.service.ContenuBoiteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ContenuBoiteServiceImpl implements ContenuBoiteService {
        private final ContenuBoiteRepository contenuBoiteRepository;
        @Override
        public List<ContenuBoite> getAllContenuBoite() {
                return contenuBoiteRepository.findAll();
        }

        @Override
        public ContenuBoite getContenuBoiteByCouleur(String couleur) {
                return contenuBoiteRepository.findByCouleur(couleur);
        }

        @Override
        public ContenuBoite getContenuBoiteById(long id) {
                return contenuBoiteRepository.findById(id).orElse(null);
        }
}
