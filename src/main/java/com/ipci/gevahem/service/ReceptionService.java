package com.ipci.gevahem.service;

import com.ipci.gevahem.entity.Reception;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ReceptionService {
    List<Reception> getAllReception();
    void saveReception(Reception reception);
    void deleteReceptionById(long id);
    Reception getReceptionById(long id);

    List<Reception> getByDate(String format);
}
