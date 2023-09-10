package com.ipci.gevahem.controller;

import com.ipci.gevahem.entity.*;
import com.ipci.gevahem.service.EchantillonDeriveService;
import com.ipci.gevahem.service.PreparationService;
import com.ipci.gevahem.service.TypePrelevementService;
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
@RequestMapping("/echantillons-derives")
public class EchantillonDeriveController {
    private PreparationService preparationService;
    private EchantillonDeriveService echantillonDeriveService;
    private TypePrelevementService typePrelevementService;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("echantillonDerives", echantillonDeriveService.getAllEchantillonDerive());
        return "echantillonDerive/index";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute EchantillonDerive echantillonDerive,
                      BindingResult result,
                      RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("echantillonDerive", echantillonDerive);
            redirectAttributes.addFlashAttribute("errors", result.getAllErrors());
            return "redirect:/echantillons-derives/add-form?nombre=2";
        }

        echantillonDeriveService.addEchantillonDerive(echantillonDerive);

        return "redirect:/echantillons-derives";

    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute EchantillonDerive echantillonDerive, BindingResult result, RedirectAttributes redirectAttributes){
        if (result.hasErrors()){
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.echantillonDerive", result);
            redirectAttributes.addFlashAttribute("echantillonDerive", echantillonDerive);
            return "redirect:/echantillons-derives/edit-form?id=" + echantillonDerive.getId();
        }

        echantillonDeriveService.addEchantillonDerive(echantillonDerive);

        return "redirect:/echantillons-derives";
    }

    @GetMapping("/add-form")
    public String add_form(Model model, HttpSession httpSession, @RequestParam int nombre){
        if (!model.containsAttribute("echantillonDerive")){
            model.addAttribute("echantillonDerive", new EchantillonDerive());
        }


        List<Preparation> preparation = (List<Preparation>) preparationService.getAllPreparations();
        List<TypePrelevement> typePrelevement = typePrelevementService.getAllTypePrelevement();
        model.addAttribute("preparations", preparation);
        model.addAttribute("typePrelevements", typePrelevement);
        model.addAttribute("nb", nombre);
        model.addAttribute("id", httpSession.getAttribute("id"));
        return "echantillonDerive/new";
    }

    @GetMapping("/nb_select")
    public String select_nb(Model model, @RequestParam int prelevement, HttpSession httpSession){
        String id_pre = String.valueOf(prelevement);
        httpSession.setAttribute("id", id_pre);
        model.addAttribute("id_pre", prelevement);
        return "echantillonDerive/nb_echantillon";
    }

    @GetMapping("/edit-form")
    public String edit_form(@RequestParam(name = "id") long id, Model model){
        if (!model.containsAttribute("echantillonDerive")){
            model.addAttribute("echantillonDerive", echantillonDeriveService.getEchantillonDeriveById(id));
        }
        List<Preparation> preparation = (List<Preparation>) preparationService.getAllPreparations();
        List<TypePrelevement> typePrelevement = typePrelevementService.getAllTypePrelevement();
        model.addAttribute("preparations", preparation);
        model.addAttribute("typePrelevements", typePrelevement);
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
        return "redirect:/echantillons-derives";
    }
}
