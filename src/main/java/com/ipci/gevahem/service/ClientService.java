package com.ipci.gevahem.service;

import com.ipci.gevahem.entity.Client;

import java.util.List;

public interface ClientService {
    List<Client> getAllClient();
    void saveClient(Client client);
    Client getCLientById(Long id);
    Client getClientByContact(String contact);
    void deleteClientById(Long id);
}
