package com.ipci.gevahem.service;

import com.ipci.gevahem.entity.Conformite;
import com.ipci.gevahem.entity.Prelevement;

import java.util.List;

public interface PrelevementService {

    List<Prelevement> getAllPrelevement();

    List<Prelevement> getByConformiteLibelle(String libelle);
    void savePrelevement(Prelevement glaciere);

    Prelevement getPrelevementByLibelle(String libelle);

    Prelevement getPrelevementByConformite(String conformite);
    Prelevement getPrelevementByCodeAndConformite(String code, Conformite conformite);

    Prelevement getPrelevementById(long id);

    void deletePrelevementById(Long id);
}
