package com.ipci.gevahem.controller;

import com.ipci.gevahem.entity.Client;
import com.ipci.gevahem.service.ClientService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@AllArgsConstructor
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("clients", clientService.getAllClient());
        return "client/index";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute Client client, BindingResult result, RedirectAttributes redirectAttributes){
        if (result.hasErrors()){
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.client", result);
            redirectAttributes.addFlashAttribute("client", client);
            return "redirect:/client/add-form";
        }

        try {
            clientService.saveClient(client);
        }catch (Exception e){
            result.rejectValue("contact", "error.client", "Ce contact existe déjà");
            return "redirect:/client/add-form";
        }

        return "redirect:/client/";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute Client client, BindingResult result, RedirectAttributes redirectAttributes){
        if (result.hasErrors()){
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.client", result);
            redirectAttributes.addFlashAttribute("client", client);
            return "redirect:/client/edit-form";
        }

        try {
            clientService.saveClient(client);
        }catch (Exception e){
            result.rejectValue("contact", "error.client", "Ce contact existe déjà");
            return "redirect:/client/edit-form";
        }

        return "redirect:/client/";
    }

    @GetMapping("/add-form")
    public String add_form(Model model){
        if (!model.containsAttribute("client")){
            model.addAttribute("client", new Client());
        }

        return "client/new";
    }

    @GetMapping("/edit-form")
    public String edit_form(@RequestParam(name = "id") long id, Model model){
        if (!model.containsAttribute("client")){
            model.addAttribute("client", clientService.getCLientById(id));
        }

        return "client/update";
    }

    @GetMapping("/delete")
    public String delete(Long id){
        clientService.deleteClientById(id);
        return "redirect:/client/";
    }
}
