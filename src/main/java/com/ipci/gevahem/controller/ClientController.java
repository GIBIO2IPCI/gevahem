package com.ipci.gevahem.controller;

import com.ipci.gevahem.entity.Client;
import com.ipci.gevahem.entity.TypeClient;
import com.ipci.gevahem.service.ClientService;
import com.ipci.gevahem.service.TypeClientService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String add(@Valid @ModelAttribute Client client, BindingResult result, RedirectAttributes redirectAttributes){
        if (result.hasErrors()){
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.glaciere", result);
            redirectAttributes.addFlashAttribute("client", client);
            return "redirect:/client/add-form";
        }

        try {
            client.setCode_client("CL" + client.getContact());
            clientService.saveClient(client);
        }catch (Exception e){
            result.rejectValue("contact", "error.client", "Ce contact existe déjà");
            result.rejectValue("email", "error.client", "L'email existe déjà");
            result.rejectValue("code_client", "error.client", "Le code client existe déjà");
            return "redirect:/client/add-form";
        }

        return "redirect:/client/";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute Client client, BindingResult result, RedirectAttributes redirectAttributes){
        if (result.hasErrors()){
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.glaciere", result);
            redirectAttributes.addFlashAttribute("client", client);
            return "redirect:/client/edit-form";
        }

        try {
            client.setCode_client("CL" + client.getContact());
            clientService.saveClient(client);
        }catch (Exception e){
            result.rejectValue("contact", "error.client", "Ce contact existe déjà");
            result.rejectValue("email", "error.client", "L'email existe déjà");
            result.rejectValue("code_client", "error.client", "Le code client existe déjà");
            return "redirect:/client/edit-form";
        }

        return "redirect:/client/";
    }

    @GetMapping("/add-form")
    public String add_form(Model model){
        if (!model.containsAttribute("client")){
            model.addAttribute("client", new Client());
        }

        List<TypeClient> typeClient = typeClientService.getAllTypeClient();
        model.addAttribute("typeClients",typeClient);
        return "client/new";
    }

    @GetMapping("/edit-form")
    public String edit_form(@RequestParam(name="id") long id, Model model){
        if (!model.containsAttribute("client")){
            model.addAttribute("client", clientService.getClientById(id));
        }

        List<TypeClient> typeClient = typeClientService.getAllTypeClient();
        model.addAttribute("types", typeClient);
        return "client/update";
    }

    @GetMapping("/delete")
    public String delete(Long id){
        clientService.deleteClientById(id);
        return "redirect:/client/";
    }
}
