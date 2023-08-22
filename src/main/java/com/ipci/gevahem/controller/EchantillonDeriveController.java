package com.ipci.gevahem.controller;

import com.ipci.gevahem.entity.*;
import com.ipci.gevahem.service.EchantillonDeriveService;
import com.ipci.gevahem.service.PreparationService;
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
@RequestMapping("/echantillons-derives")
public class EchantillonDeriveController {
    private PreparationService preparationService;
    private EchantillonDeriveService echantillonDeriveService;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("echantillonDerives", echantillonDeriveService.getAllEchantillonDerive());
        return "echantillonDerive/index";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute EchantillonDerive echantillonDerive, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("echantillonDerive", echantillonDerive);
            redirectAttributes.addFlashAttribute("errors", result.getAllErrors());
            return "redirect:/echantillonDerive/add-form";
        }

        echantillonDeriveService.addEchantillonDerive(echantillonDerive);

        return "redirect:/echantillonDerive";

    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute EchantillonDerive echantillonDerive, BindingResult result, RedirectAttributes redirectAttributes){
        if (result.hasErrors()){
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.echantillonDerive", result);
            redirectAttributes.addFlashAttribute("echantillonDerive", echantillonDerive);
            return "redirect:/echantillonDerive/edit-form?id=" + echantillonDerive.getId();
        }

        echantillonDeriveService.addEchantillonDerive(echantillonDerive);

        return "redirect:/echantillonDerive";
    }

    @GetMapping("/add-form")
    public String add_form(Model model){
        if (!model.containsAttribute("echantillonDerive")){
            model.addAttribute("echantillonDerive", new EchantillonDerive());
        }

        List<Preparation> preparation = (List<Preparation>) preparationService.getAllPreparations();
        model.addAttribute("preparations", preparation);
        return "echantillonDerive/new";
    }

    @GetMapping("/edit-form")
    public String edit_form(@RequestParam(name = "id") long id, Model model){
        if (!model.containsAttribute("echantillonDerive")){
            model.addAttribute("echantillonDerive", echantillonDeriveService.getEchantillonDeriveById(id));
        }
        List<Preparation> preparation = (List<Preparation>) preparationService.getAllPreparations();
        model.addAttribute("preparations", preparation);
        return "echantillonDerive/update";
    }

    @GetMapping("/show")
    public String show(@RequestParam(name = "id") long id, Model model){
        model.addAttribute("echantillonDerive", echantillonDeriveService.getEchantillonDeriveById(id));
        return "/echantillonDerive/show";
    }

    @GetMapping("/delete")
    public String delete(Long id){
        echantillonDeriveService.deleteEchantillonDeriveById(id);
        return "redirect:/echantillonDerive";
    }
}
