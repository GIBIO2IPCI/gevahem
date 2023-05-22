package com.ipci.gevahem.service;

import com.ipci.gevahem.entity.TypeClient;

import java.util.List;

public interface TypeClientService {
    TypeClient getTypeClientByLibelle(String libelle);
    List<TypeClient> getAllTypeClient();
    void saveTypeClient(TypeClient typeClient);
    TypeClient getTypeClientById(Long id);
}
