package com.ipci.gevahem.service;

import com.ipci.gevahem.entity.Ambulancier;
import com.ipci.gevahem.entity.Glaciere;

import java.util.List;

public interface GlaciereService {

    List<Glaciere> getAllGlaciere();
    void saveGlaciere(Glaciere glaciere);

    Glaciere getGlaciereByLibelle(String libelle);

    Glaciere getGlaciereById(long id);

    void deleteGlaciereById(Long id);
}
