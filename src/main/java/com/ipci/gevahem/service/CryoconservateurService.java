package com.ipci.gevahem.service;

import com.ipci.gevahem.entity.Cryoconservateur;

import java.util.List;

public interface CryoconservateurService {
    Cryoconservateur getCryoconservateurByNom(String nom);
    List<Cryoconservateur> getAllCryoconservateur();
    Cryoconservateur getCryoconservateurById(long id);
    void saveCryoconservateur(Cryoconservateur cryoconservateur);
    void deleteCryoconservateurById(long id);
}
