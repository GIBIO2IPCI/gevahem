package com.ipci.gevahem.controller;

import com.ipci.gevahem.entity.Ambulancier;
import com.ipci.gevahem.service.AmbulancierService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ambulancier")
public class AmbulancierController {

    private AmbulancierService ambulancierService;

    public AmbulancierController(AmbulancierService ambulancierService) {
        this.ambulancierService = ambulancierService;
    }

    @GetMapping("/liste")
    public String list_ambulancier(Model model){
        model.addAttribute("ambulanciers", ambulancierService.getAllAmbulancier());
        return "ambulancier/list";
    }

    @PostMapping("/add")
    public String add_ambulancier(Ambulancier ambulancier){
        ambulancierService.saveAmbulancier(ambulancier);
        return "redirect:/ambulancier/liste";
    }
}
