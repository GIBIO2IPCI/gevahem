package com.ipci.gevahem.service.implementation;

import com.ipci.gevahem.entity.Reception;
import com.ipci.gevahem.repository.ReceptionRepository;
import com.ipci.gevahem.service.ReceptionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ReceptionServiceImpl implements ReceptionService {
    private ReceptionRepository receptionRepository;

    @Override
    public List<Reception> getAllReception() {
        return receptionRepository.findAll();
    }

    @Override
    public void saveReception(Reception reception) {
        Date temps = new Date();
        reception.setDate_reception(temps);
        reception.setCode("REC" + temps.getTime());
        receptionRepository.save(reception);

    }

    @Override
    public void deleteReceptionById(long id) {
        receptionRepository.deleteById(id);
    }

    @Override
    public Reception getReceptionById(long id) {
        return receptionRepository.findById(id).orElse(null);
    }

}
