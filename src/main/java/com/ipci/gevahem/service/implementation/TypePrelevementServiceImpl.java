package com.ipci.gevahem.service.implementation;

import com.ipci.gevahem.entity.TypeClient;
import com.ipci.gevahem.entity.TypePrelevement;
import com.ipci.gevahem.repository.TypeClientRepository;
import com.ipci.gevahem.repository.TypePrelevementRepository;
import com.ipci.gevahem.service.TypeClientService;
import com.ipci.gevahem.service.TypePrelevementService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TypePrelevementServiceImpl implements TypePrelevementService {
    private final TypePrelevementRepository typePrelevementRepository;
    @Override
    public TypePrelevement getTypePrelevementByLibelle(Integer libelle) {
        return typePrelevementRepository.findByLibelle(libelle);
    }

    @Override
    public List<TypePrelevement> getAllTypePrelevement() {
        return typePrelevementRepository.findAll();
    }

    @Override
    public void savePrelevement(TypePrelevement typeClient) {
        typePrelevementRepository.save(typeClient);
    }

    @Override
    public TypePrelevement getTypePrelevementById(long id) {
        return typePrelevementRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteTypePrelevementById(Long id) {
        typePrelevementRepository.deleteById(id);
    }
}
