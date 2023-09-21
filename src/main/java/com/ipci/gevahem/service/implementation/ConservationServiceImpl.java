package com.ipci.gevahem.service.implementation;

import com.ipci.gevahem.entity.Conservation;
import com.ipci.gevahem.entity.Preparation;
import com.ipci.gevahem.repository.ConservationRepository;
import com.ipci.gevahem.service.ConservationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ConservationServiceImpl implements ConservationService {
    private ConservationRepository conservationRepository;

    @Override
    public List<Conservation> getAllConservation() {
        return conservationRepository.findAll();
    }

    @Override
    public void saveConservation(Conservation conservation) {
        Date temps = new Date();
        conservation.setDate_conservation(temps);
        conservation.setCode("CONS" + temps.getTime());
        conservationRepository.save(conservation);
    }

    @Override
    public void deleteConservationById(long id) {
        conservationRepository.deleteById(id);
    }

    @Override
    public Conservation getConservationById(long id) {
        return conservationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Conservation> getByDate(String format) {
        List<Conservation> conservations = conservationRepository.findAll();
        List<Conservation> conserv = new ArrayList<>();

        for (Conservation conservation : conservations) {

            SimpleDateFormat formater = new SimpleDateFormat(format);

            if (formater.format(conservation.getDate_conservation()).equals(formater.format(new Date()))) {
                conserv.add(conservation);
            }
        }

        return conserv;
    }
}
