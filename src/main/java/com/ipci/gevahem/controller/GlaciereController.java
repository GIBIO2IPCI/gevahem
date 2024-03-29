package com.ipci.gevahem.controller;

import com.ipci.gevahem.entity.*;
import com.ipci.gevahem.service.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Controller
@AllArgsConstructor
@RequestMapping("/glaciere")
public class GlaciereController {

    private final GlaciereService glaciereService;
    private final AmbulancierService ambulancierService;
    private final ConformiteService conformiteService;
    private final ClientService clientService;
    private final EtudeService etudeService;


    @GetMapping("")
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

        Date temps = new Date();
        glaciere.setCode("GL" + temps.getTime());
        glaciereService.saveGlaciere(glaciere);

        return "redirect:/glaciere";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute Glaciere glaciere, BindingResult result, RedirectAttributes redirectAttributes){
        if (result.hasErrors()){
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.glaciere", result);
            redirectAttributes.addFlashAttribute("glaciere", glaciere);
            return "redirect:/glaciere/edit-form?id=" + glaciere.getId();
        }

        glaciereService.saveGlaciere(glaciere);

        return "redirect:/glaciere";
    }

    @GetMapping("/add-form")
    public String add_form(Model model){
        if (!model.containsAttribute("glaciere")){
            model.addAttribute("glaciere", new Glaciere());
        }

        List<Ambulancier> ambulancier = ambulancierService.getAllAmbulancier();
        List<Conformite> conformite = conformiteService.getAllConformite();
        List<Client> client = clientService.getAllClient();
        List<Etude> etude = etudeService.getAllEtude();
        model.addAttribute("ambulanciers", ambulancier);
        model.addAttribute("conformites", conformite);
        model.addAttribute("clients", client);
        model.addAttribute("etudes", etude);
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
        List<Etude> etude = etudeService.getAllEtude();
        model.addAttribute("ambulanciers", ambulancier);
        model.addAttribute("conformites", conformite);
        model.addAttribute("clients", client);
        model.addAttribute("etudes", etude);
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
        return "redirect:/glaciere";
    }
}
