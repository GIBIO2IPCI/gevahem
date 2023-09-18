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

@Controller
@AllArgsConstructor
@RequestMapping("/conservation")
public class ConservationController {
    private final EchantillonDeriveService echantillonDeriveService;
    private final ContenuBoiteService contenuBoiteService;
    private final BoiteService boiteService;
    private final CanrackService canrackService;
    private final CryoconservateurService cryoconservateurService;
    private final ConservationService conservationService;


    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("conservations",conservationService.getAllConservation() );
        return "conservation/index";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute Conservation conservation, BindingResult result, RedirectAttributes redirectAttributes){
        if (result.hasErrors()){
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.conservation", result);
            redirectAttributes.addFlashAttribute("conservation", conservation);
            return "redirect:/conservation/add-form";
        }


        conservationService.saveConservation(conservation);

        return "redirect:/conservation";
    }

    @GetMapping("/add-form")
    public String add_form(Model model){
        if (!model.containsAttribute("conservation")){
            model.addAttribute("conservation", new Conservation());
        }
        List<ContenuBoite> contenuBoite = contenuBoiteService.getAllContenuBoite();
        List<Boite> boite = boiteService.getAllBoite();
        List<Canrack> canrack = canrackService.getAllCanrack();
        List<Cryoconservateur> cryoconservateur = cryoconservateurService.getAllCryoconservateur();
        List<EchantillonDerive> echantillonDerive = echantillonDeriveService.getAllEchantillonDerive();
        model.addAttribute("contenuBoites", contenuBoite);
        model.addAttribute("boites", boite);
        model.addAttribute("canracks", canrack);
        model.addAttribute("cryoconservateurs", cryoconservateur);
        model.addAttribute("echantillonDerives", echantillonDerive);

        return "conservation/new";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute Conservation conservation, BindingResult result, RedirectAttributes redirectAttributes){
        if (result.hasErrors()){
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.conservation", result);
            redirectAttributes.addFlashAttribute("conservation", conservation);
            return "redirect:/conservation/edit-form?id=" + conservation.getId();
        }

        conservationService.saveConservation(conservation);

        return "redirect:/conservation";
    }

    @GetMapping("/edit-form")
    public String edit_form(@RequestParam(name = "id") long id, Model model){
        if (!model.containsAttribute("conservation")){
            model.addAttribute("conservation", conservationService.getConservationById(id));
        }
        List<ContenuBoite> contenuBoite = contenuBoiteService.getAllContenuBoite();
        List<Boite> boite = boiteService.getAllBoite();
        List<Canrack> canrack = canrackService.getAllCanrack();
        List<Cryoconservateur> cryoconservateur = cryoconservateurService.getAllCryoconservateur();
        List<EchantillonDerive> echantillonDerive = echantillonDeriveService.getAllEchantillonDerive();
        model.addAttribute("contenuBoites", contenuBoite);
        model.addAttribute("boites", boite);
        model.addAttribute("canracks", canrack);
        model.addAttribute("cryoconservateurs", cryoconservateur);
        model.addAttribute("echantillonDerives", echantillonDerive);
        return "conservation/update";
    }
    @GetMapping("/show")
    public String show(@RequestParam(name = "id") long id, Model model){
        model.addAttribute("conservation", conservationService.getConservationById(id));
        return "/conservation/show";
    }

    @GetMapping("/delete")
    public String delete(Long id){
        conservationService.deleteConservationById(id);
        return "redirect:/conservation";
    }
}
