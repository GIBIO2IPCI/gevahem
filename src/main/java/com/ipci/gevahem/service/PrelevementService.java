package com.ipci.gevahem.service;

import com.ipci.gevahem.entity.Prelevement;

import java.util.List;

public interface PrelevementService {

    List<Prelevement> getAllPrelevement();
    void savePrelevement(Prelevement glaciere);

    Prelevement getPrelevementByLibelle(String libelle);

    Prelevement getPrelevementById(long id);

    void deletePrelevementById(Long id);
}
