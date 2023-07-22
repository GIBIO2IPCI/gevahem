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

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/prelevement")
public class PrelevementController {

    private final GlaciereService glaciereService;
    private final ConformiteService conformiteService;
    private final PrelevementService prelevementService;
    private final PatientService patientService;
    private final AnalyseService analyseService;
    private final TypePrelevementService typePrelevementService;

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("prelevements", prelevementService.getAllPrelevement());
        return "prelevement/index";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute Prelevement prelevement, BindingResult result, RedirectAttributes redirectAttributes){
        if (result.hasErrors()){
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.prelevement", result);
            redirectAttributes.addFlashAttribute("prelevement", prelevement);
            return "redirect:/prelevement/add-form";
        }

        try {
            prelevementService.savePrelevement(prelevement);
        }catch (Exception e){
            result.rejectValue("libelle", "error.prelevement", "Ce libellé existe déjà");
            return "redirect:/prelevement/add-form";
        }

        return "redirect:/prelevement";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute Prelevement prelevement, BindingResult result, RedirectAttributes redirectAttributes){
        if (result.hasErrors()){
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.prelevement", result);
            redirectAttributes.addFlashAttribute("prelevement", prelevement);
            return "redirect:/prelevement/edit-form";
        }

        try {
            prelevementService.savePrelevement(prelevement);
        }catch (Exception e){
            result.rejectValue("libelle", "error.prelevement", "Ce libellé existe déjà");
            return "redirect:/prelevement/edit-form";
        }

        return "redirect:/prelevement";
    }

    @GetMapping("/add-form")
    public String add_form(Model model){
        if (!model.containsAttribute("prelevement")){
            model.addAttribute("prelevement", new Prelevement());
        }

        List<Patient> patient = patientService.getAllPatient();
        List<Glaciere> glaciere = glaciereService.getAllGlaciere();
        List<Analyse> analyse = analyseService.getAllAnalyse();
        List<Conformite> conformite = conformiteService.getAllConformite();
        List<TypePrelevement> typePrelevement = typePrelevementService.getAllTypePrelevement();
        model.addAttribute("patients", patient);
        model.addAttribute("glacieres", glaciere);
        model.addAttribute("analyses", analyse);
        model.addAttribute("conformites", conformite);
        model.addAttribute("typePrelevements", typePrelevement);
        return "prelevement/new";
    }

    @GetMapping("/edit-form")
    public String edit_form(@RequestParam(name = "id") long id, Model model){
        if (!model.containsAttribute("prelevement")){
            model.addAttribute("prelevement", prelevementService.getPrelevementById(id));
        }
        List<Patient> patient = patientService.getAllPatient();
        List<Glaciere> glaciere = glaciereService.getAllGlaciere();
        List<Analyse> analyse = analyseService.getAllAnalyse();
        List<Conformite> conformite = conformiteService.getAllConformite();
        List<TypePrelevement> typePrelevement = typePrelevementService.getAllTypePrelevement();
        model.addAttribute("patients", patient);
        model.addAttribute("glacieres", glaciere);
        model.addAttribute("analyses", analyse);
        model.addAttribute("conformites", conformite);
        model.addAttribute("typePrelevements", typePrelevement);
        return "prelevement/update";
    }

    @GetMapping("/show")
    public String show(@RequestParam(name = "id") long id, Model model){
        model.addAttribute("prelevement", prelevementService.getPrelevementById(id));
        return "/prelevement/show";
    }

    @GetMapping("/conforme")
    public String conforme(@RequestParam(name = "conformite") String conformite, Model model){
        model.addAttribute("prelevement", prelevementService.getPrelevementByConformite(conformite));
        return "/prelevement/conforme";
    }

    @GetMapping("/delete")
    public String delete(Long id){
        prelevementService.deletePrelevementById(id);
        return "redirect:/prelevement";
    }
}
