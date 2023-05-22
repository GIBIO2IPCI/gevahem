package com.ipci.gevahem.controller;

import com.ipci.gevahem.entity.Client;
import com.ipci.gevahem.entity.TypeClient;
import com.ipci.gevahem.service.ClientService;
import com.ipci.gevahem.service.TypeClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/client")
public class ClientController{
    private final ClientService clientService;
    private final TypeClientService typeClientService;
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("clients", clientService.getAllClient());
        return "client/index";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Client client){
        client.setCode_client("CL" + client.getContact());
        clientService.saveClient(client);
        return "redirect:/client/";
    }

    @GetMapping("/add-form")
    public String add_form(Model model){
        Client client =new Client();
        List<TypeClient> typeClient = typeClientService.getAllTypeClient();
        model.addAttribute("client",client);
        model.addAttribute("types",typeClient);
        return "client/new";
    }

    @GetMapping("/edit")
    public String edit_form(@RequestParam(name="id") long id, Model model){
        Client client = clientService.getClientById(id);
        List<TypeClient> typeClient = typeClientService.getAllTypeClient();
        model.addAttribute("types", typeClient);
        model.addAttribute("client", client);
        return "client/update";
    }

    @GetMapping("/delete")
    public String delete(Long id){
        clientService.deleteClientById(id);
        return "redirect:/client/";
    }

}
