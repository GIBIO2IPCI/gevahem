package com.ipci.gevahem.service;

import com.ipci.gevahem.entity.Client;

import java.util.List;

public interface ClientService {

    List<Client> getAllClient();
    void saveClient(Client client);

    Client getClientByContact(String contact);

    Client getClientById(long id);

    void deleteClientById(Long id);
}
