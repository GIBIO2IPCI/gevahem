package com.ipci.gevahem.controller;

import com.ipci.gevahem.entity.EchantillonDerive;
import com.ipci.gevahem.entity.Prelevement;
import com.ipci.gevahem.entity.Preparation;
import com.ipci.gevahem.service.PrelevementService;
import com.ipci.gevahem.service.PreparationService;
import jakarta.servlet.http.HttpSession;
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
@RequestMapping("/preparation")
public class PreparationController {

    private final PreparationService preparationService;
    private final PrelevementService prelevementService;
    private final HttpSession httpSession;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("preparations", preparationService.getAllPreparations());
        return "preparation/index";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute Preparation preparation, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("preparation", preparation);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.preparation", result);
            return "redirect:/preparation/add-form";
        }

        preparationService.addPreparation(preparation);

        httpSession.setAttribute("preparation", preparation.getId());
        httpSession.setAttribute("prelevement", preparation.getPrelevement().getId());

        return "redirect:/echantillons-derives/nb_select";

    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute Preparation preparation, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("preparation", preparation);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.preparation", result);
            return "redirect:/preparation/edit-form?id=" + preparation.getId();
        }

        return "redirect:/preparation";

    }

    @GetMapping("/edit-form")
    public String edit_form(@RequestParam(name = "id") long id, Model model) {
        if (!model.containsAttribute("preparation")) {
            model.addAttribute("preparation", preparationService.getPreparationByID(id));
        }
        return "preparation/update";
    }

    @GetMapping("/add-form")
    public String add_form(Model model) {
        if (!model.containsAttribute("preparation")) {
            model.addAttribute("preparation", new Preparation());
            model.addAttribute("echantillonDerive", new EchantillonDerive());
        }

        String conforme = "CONFORME";
        model.addAttribute("prelevements", prelevementService.getByConformiteLibelle(conforme));
        return "preparation/new";
    }

    @GetMapping("/delete")
    public String delete(Long id) {
        preparationService.deletePreparation(id);
        return "redirect:/preparation";
    }

}
