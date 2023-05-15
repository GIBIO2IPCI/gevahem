package com.ipci.gevahem.service;

import com.ipci.gevahem.entity.Ambulancier;

import java.util.List;

public interface AmbulancierService {
    List<Ambulancier> getAllAmbulancier();
    void saveAmbulancier(Ambulancier ambulancier);

    Ambulancier getAmbulancierById(long id);
    void deleteAmbulancierById(long id);
}
