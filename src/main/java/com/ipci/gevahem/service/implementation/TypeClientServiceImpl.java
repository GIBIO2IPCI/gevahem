package com.ipci.gevahem.service.implementation;

import com.ipci.gevahem.entity.TypeClient;
import com.ipci.gevahem.repository.TypeClientRepository;
import com.ipci.gevahem.service.TypeClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TypeClientServiceImpl implements TypeClientService {
    private final TypeClientRepository typeClientRepository;

    @Override
    public TypeClient getTypeClientByLibelle(String libelle) {
        return typeClientRepository.findByLibelle(libelle);
    }

    @Override
    public List<TypeClient> getAllTypeClient() {
        return typeClientRepository.findAll();
    }

    @Override
    public void saveTypeClient(TypeClient typeClient) {
        typeClientRepository.save(typeClient);
    }

    @Override
    public TypeClient getTypeClientById(Long id) {
        return typeClientRepository.findById(id).orElse(null);
    }
}
