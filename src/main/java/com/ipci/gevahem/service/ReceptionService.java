package com.ipci.gevahem.service;

import com.ipci.gevahem.entity.Reception;

import java.util.List;

public interface ReceptionService {
    List<Reception> getAllReception();
    void saveReception(Reception reception);
    void deleteReceptionById(long id);
    Reception getReceptionById(long id);
}
