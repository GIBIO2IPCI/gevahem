package com.ipci.gevahem.service;

import com.ipci.gevahem.entity.Conservation;
import com.ipci.gevahem.entity.Reception;

import java.util.List;

public interface ConservationService {
    List<Conservation> getAllConservation();
    void saveConservation(Conservation conservation);
    void deleteConservationById(long id);
    Conservation getConservationById(long id);
    List<Conservation> getByDate(String format);
}
