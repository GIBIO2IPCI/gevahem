package com.ipci.gevahem.service;

import com.ipci.gevahem.entity.ContenuBoite;
import java.util.List;

public interface ContenuBoiteService {
    List<ContenuBoite> getAllContenuBoite();
    ContenuBoite getContenuBoiteByCouleur(String couleur);
    ContenuBoite getContenuBoiteById(long id);
}
