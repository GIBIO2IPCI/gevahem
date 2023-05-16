package com.ipci.gevahem.service.implementation;

import com.ipci.gevahem.entity.Client;
import com.ipci.gevahem.repository.ClientRepository;
import com.ipci.gevahem.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    @Override
    public List<Client> getAllClient() {
        return clientRepository.findAll();
    }

    @Override
    public void saveClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public Client getClientById(long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteClientById(long id) {
        clientRepository.deleteById(id);
    }
}
