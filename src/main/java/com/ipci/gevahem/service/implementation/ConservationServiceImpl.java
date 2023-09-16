package com.ipci.gevahem.service.implementation;

import com.ipci.gevahem.entity.Conservation;
import com.ipci.gevahem.service.ConservationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ConservationServiceImpl implements ConservationService {

    @Override
    public List<Conservation> getAllConservation() {
        return null;
    }

    @Override
    public void saveConservation(Conservation conservation) {

    }

    @Override
    public void deleteConservationById(long id) {

    }

    @Override
    public Conservation getConservationById(long id) {
        return null;
    }
}
