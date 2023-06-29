package com.ipci.gevahem.service;

import com.ipci.gevahem.entity.Analyse;

import java.util.List;

public interface AnalyseService {
    Analyse getAnalyseByLibelle(Integer libelle);
    List<Analyse> getAllAnalyse();
    void savePrelevement(Analyse analyse);

    Analyse getAnalyseById(long id);

    void deleteAnalyseById(Long id);
}
