package com.ipci.gevahem.controller;

import com.ipci.gevahem.entity.Ambulancier;
import com.ipci.gevahem.entity.Glaciere;
import com.ipci.gevahem.service.AmbulancierService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@AllArgsConstructor
@RequestMapping("/ambulancier")
public class AmbulancierController {

    private final AmbulancierService ambulancierService;

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("ambulanciers", ambulancierService.getAllAmbulancier());
        return "ambulancier/index";
    }
    
    @PostMapping("/add")
    public String add(@Valid @ModelAttribute Ambulancier ambulancier, BindingResult result, RedirectAttributes redirectAttributes){
        if (result.hasErrors()){
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.ambulancier", result);
            redirectAttributes.addFlashAttribute("ambulancier", ambulancier);
            return "redirect:/ambulancier/add-form";
        }

        try {
            ambulancierService.saveAmbulancier(ambulancier);
        }catch (Exception e){
            result.rejectValue("contact", "error.ambulancier", "Ce contact existe déjà");
            return "redirect:/ambulancier/add-form";
        }

        return "redirect:/ambulancier";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute Ambulancier ambulancier, BindingResult result, RedirectAttributes redirectAttributes){
        if (result.hasErrors()){
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.ambulancier", result);
            redirectAttributes.addFlashAttribute("ambulancier", ambulancier);
            return "redirect:/ambulancier/edit-form?id=" + ambulancier.getId();
        }

        try {
            ambulancierService.saveAmbulancier(ambulancier);
        }catch (Exception e){
            result.rejectValue("contact", "error.ambulancier", "Ce contact existe déjà");
            return "redirect:/ambulancier/edit-form?id=" + ambulancier.getId();
        }

        return "redirect:/ambulancier";
    }

    @GetMapping("/add-form")
    public String add_form(Model model){
        if (!model.containsAttribute("ambulancier")){
            model.addAttribute("ambulancier", new Ambulancier());
        }

        return "ambulancier/new";
    }

    @GetMapping("/edit-form")
    public String edit_form(@RequestParam(name = "id") long id, Model model){
        if (!model.containsAttribute("ambulancier")){
            model.addAttribute("ambulancier", ambulancierService.getAmbulancierById(id));
        }

        return "ambulancier/update";
    }

    @GetMapping("/delete")
    public String delete(Long id){
        ambulancierService.deleteAmbulancierById(id);
        return "redirect:/ambulancier/";
    }
}
