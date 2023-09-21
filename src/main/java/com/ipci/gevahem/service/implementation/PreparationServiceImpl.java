package com.ipci.gevahem.service.implementation;

import com.ipci.gevahem.entity.Preparation;
import com.ipci.gevahem.entity.Reception;
import com.ipci.gevahem.repository.PreparationRepository;
import com.ipci.gevahem.service.PreparationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class PreparationServiceImpl implements PreparationService {

    private final PreparationRepository preparationRepository;
    @Override
    public void addPreparation(Preparation preparation) {

        preparation.setCode("PREPA" + preparation.getPrelevement().getLibelle().toUpperCase());
        preparation.setDatePreparation(new Date());
        preparation.setNombreRestant(preparation.getNombre() - 1);
        preparationRepository.save(preparation);
    }

    @Override
    public void deletePreparation(Long id) {
        preparationRepository.deleteById(id);
    }

    @Override
    public Preparation getPreparationByID(Long id) {
        return preparationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Preparation> getAllPreparations() {
        return preparationRepository.findAll();
    }

    @Override
    public List<Preparation> getByDate(String format) {
        List<Preparation> preparations = preparationRepository.findAll();
        List<Preparation> prepa = new ArrayList<>();

        for (Preparation preparation : preparations) {

            SimpleDateFormat formater = new SimpleDateFormat(format);

            if (formater.format(preparation.getDatePreparation()).equals(formater.format(new Date()))) {
                prepa.add(preparation);
            }
        }

        return prepa;
    }
}
