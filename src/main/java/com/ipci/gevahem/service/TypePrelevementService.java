package com.ipci.gevahem.service;

import com.ipci.gevahem.entity.TypePrelevement;

import java.util.List;

public interface TypePrelevementService {
    TypePrelevement getTypePrelevementByLibelle(Integer libelle);
    List<TypePrelevement> getAllTypePrelevement();
    void savePrelevement(TypePrelevement typePrelevement);

    TypePrelevement getTypePrelevementById(long id);

    void deleteTypePrelevementById(Long id);
}
