package com.ipci.gevahem.controller;

import com.ipci.gevahem.entity.Ambulancier;
import com.ipci.gevahem.entity.Conformite;
import com.ipci.gevahem.entity.Glaciere;
import com.ipci.gevahem.service.AmbulancierService;
import com.ipci.gevahem.service.ConformiteService;
import com.ipci.gevahem.service.GlaciereService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/glaciere")
public class GlaciereController {

    private final GlaciereService glaciereService;
    private final AmbulancierService ambulancierService;
    private final ConformiteService conformiteService;

    public GlaciereController(GlaciereService glaciereService, AmbulancierService ambulancierService, ConformiteService conformiteService) {
        this.glaciereService = glaciereService;
        this.ambulancierService = ambulancierService;
        this.conformiteService = conformiteService;
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("glacieres", glaciereService.getAllGlaciere());
        return "glaciere/index";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Glaciere glaciere){
        glaciereService.saveGlaciere(glaciere);
        return "redirect:/glaciere/";
    }

    @GetMapping("/add-form")
    public String add_form(Model model){
        Glaciere glaciere = new Glaciere();
        List<Ambulancier> ambulancier = ambulancierService.getAllAmbulancier();
        List<Conformite> conformite = conformiteService.getAllConformite();
        model.addAttribute("ambulanciers", ambulancier);
        model.addAttribute("conformites", conformite);
        model.addAttribute("glaciere", glaciere);
        return "glaciere/new";
    }

    @GetMapping("/edit")
    public String edit_form(@RequestParam(name = "id") long id, Model model){
        Glaciere glaciere = glaciereService.getGlaciereById(id);
        List<Ambulancier> ambulancier = ambulancierService.getAllAmbulancier();
        List<Conformite> conformite = conformiteService.getAllConformite();
        model.addAttribute("ambulanciers", ambulancier);
        model.addAttribute("conformites", conformite);
        model.addAttribute("glaciere", glaciere);
        return "glaciere/update";
    }

    @GetMapping("/delete")
    public String delete(Long id){
        glaciereService.deleteGlaciereById(id);
        return "redirect:/glaciere/";
    }
}