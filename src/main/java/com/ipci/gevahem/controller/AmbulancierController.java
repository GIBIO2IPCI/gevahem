package com.ipci.gevahem.controller;

import com.ipci.gevahem.entity.Ambulancier;
import com.ipci.gevahem.service.AmbulancierService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ambulancier")
public class AmbulancierController {

    private final AmbulancierService ambulancierService;

    public AmbulancierController(AmbulancierService ambulancierService) {
        this.ambulancierService = ambulancierService;
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("ambulanciers", ambulancierService.getAllAmbulancier());
        return "ambulancier/index";
    }
    
    @PostMapping("/add")
    public String add(@Valid @ModelAttribute Ambulancier ambulancier, BindingResult result){
        if (result.hasErrors()){
            return "ambulancier/new";
        }
        ambulancierService.saveAmbulancier(ambulancier);
        return "redirect:/ambulancier/";
    }

    @GetMapping("/add-form")
    public String add_form(Model model){
        Ambulancier ambulancier = new Ambulancier();
        model.addAttribute("ambulancier", ambulancier);
        return "ambulancier/new";
    }

    @GetMapping("/edit")
    public String edit_form(@RequestParam(name = "id") long id, Model model){
        Ambulancier ambulancier = ambulancierService.getAmbulancierById(id);
        model.addAttribute("ambulancier", ambulancier);
        return "ambulancier/update";
    }

    @GetMapping("/delete")
    public String delete(Long id){
        ambulancierService.deleteAmbulancierById(id);
        return "redirect:/ambulancier/";
    }
}
