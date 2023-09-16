package com.ipci.gevahem.service;


import com.ipci.gevahem.entity.Canrack;
import java.util.List;

public interface CanrackService {
    List<Canrack> getAllCanrack();
    Canrack getCanrackByLibelle(String libelle);
    Canrack getCanrackById(long id);
}
