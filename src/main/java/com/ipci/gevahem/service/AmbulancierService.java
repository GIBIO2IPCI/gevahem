package com.ipci.gevahem.service;

import com.ipci.gevahem.entity.Ambulancier;

import java.util.List;

public interface AmbulancierService {
    List<Ambulancier> getAllAmbulancier();

    void saveAmbulancier(Ambulancier ambulancier);

    Ambulancier getAmbulancierById(Long id);

    Ambulancier getAmbulancierByContact(String contact);

    void deleteAmbulancierById(Long id);
}
