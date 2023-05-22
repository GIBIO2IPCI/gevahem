package com.ipci.gevahem.service;

import com.ipci.gevahem.entity.Conformite;

import java.util.List;

public interface ConformiteService {
    Conformite getConformiteByLibelle(String libelle);
    List<Conformite> getAllConformite();
    void saveGlaciere(Conformite conformite);

    Conformite getConformiteById(long id);

    void deleteConformiteById(Long id);
}
