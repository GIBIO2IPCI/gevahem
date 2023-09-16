package com.ipci.gevahem.service;

import com.ipci.gevahem.entity.Boite;

import java.util.List;

public interface BoiteService {
    List<Boite> getAllBoite();
    Boite getBoiteByLibelle(String libelle);
    Boite getBoiteById(long id);
}
