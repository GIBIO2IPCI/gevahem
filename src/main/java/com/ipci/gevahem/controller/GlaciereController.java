package com.ipci.gevahem.controller;

import com.ipci.gevahem.entity.Ambulancier;
import com.ipci.gevahem.entity.Client;
import com.ipci.gevahem.entity.Conformite;
import com.ipci.gevahem.entity.Glaciere;
import com.ipci.gevahem.service.AmbulancierService;
import com.ipci.gevahem.service.ClientService;
import com.ipci.gevahem.service.ConformiteService;
import com.ipci.gevahem.service.GlaciereService;
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
@RequestMapping("/glaciere")
public class GlaciereController {

    private final GlaciereService glaciereService;
    private final AmbulancierService ambulancierService;
    private final ConformiteService conformiteService;
    private final ClientService clientService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("glacieres", glaciereService.getAllGlaciere());
        return "glaciere/index";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute Glaciere glaciere, BindingResult result, RedirectAttributes redirectAttributes){
        if (result.hasErrors()){
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.glaciere", result);
            redirectAttributes.addFlashAttribute("glaciere", glaciere);
            return "redirect:/glaciere/add-form";
        }

        try {
            glaciereService.saveGlaciere(glaciere);
        }catch (Exception e){
            result.rejectValue("libelle", "error.glaciere", "Ce libellé existe déjà");
            return "redirect:/glaciere/add-form";
        }

        return "redirect:/glaciere/";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute Glaciere glaciere, BindingResult result, RedirectAttributes redirectAttributes){
        if (result.hasErrors()){
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.glaciere", result);
            redirectAttributes.addFlashAttribute("glaciere", glaciere);
            return "redirect:/glaciere/edit-form";
        }

        try {
            glaciereService.saveGlaciere(glaciere);
        }catch (Exception e){
            result.rejectValue("libelle", "error.glaciere", "Ce libellé existe déjà");
            return "redirect:/glaciere/edit-form";
        }

        return "redirect:/glaciere/";
    }

    @GetMapping("/add-form")
    public String add_form(Model model){
        if (!model.containsAttribute("glaciere")){
            model.addAttribute("glaciere", new Glaciere());
        }

        List<Ambulancier> ambulancier = ambulancierService.getAllAmbulancier();
        List<Conformite> conformite = conformiteService.getAllConformite();
        List<Client> client = clientService.getAllClient();
        model.addAttribute("ambulanciers", ambulancier);
        model.addAttribute("conformites", conformite);
        model.addAttribute("clients", client);
        return "glaciere/new";
    }

    @GetMapping("/edit-form")
    public String edit_form(@RequestParam(name = "id") long id, Model model){
        if (!model.containsAttribute("glaciere")){
            model.addAttribute("glaciere", glaciereService.getGlaciereById(id));
        }
        List<Ambulancier> ambulancier = ambulancierService.getAllAmbulancier();
        List<Conformite> conformite = conformiteService.getAllConformite();
        List<Client> client = clientService.getAllClient();
        model.addAttribute("ambulanciers", ambulancier);
        model.addAttribute("conformites", conformite);
        model.addAttribute("clients", client);
        return "glaciere/update";
    }

    @GetMapping("/show")
    public String show(@RequestParam(name = "id") long id, Model model){
        model.addAttribute("glaciere", glaciereService.getGlaciereById(id));
        return "/glaciere/show";
    }

    @GetMapping("/delete")
    public String delete(Long id){
        glaciereService.deleteGlaciereById(id);
        return "redirect:/glaciere/";
    }
}
