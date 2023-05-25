package com.ipci.gevahem.controller;

import com.ipci.gevahem.entity.Glaciere;
import com.ipci.gevahem.entity.Reception;
import com.ipci.gevahem.service.GlaciereService;
import com.ipci.gevahem.service.ReceptionService;
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
@RequestMapping("/reception")
public class ReceptionController {

    private final ReceptionService receptionService;
    private final GlaciereService glaciereService;

    @GetMapping("/")
    public String index(Model model){

        model.addAttribute("receptions", receptionService.getAllReception());
        return "reception/index";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute Reception reception, BindingResult result, RedirectAttributes redirectAttributes){

        if (result.hasErrors()){
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.reception", result);
            redirectAttributes.addFlashAttribute("reception", reception);
            return "redirect:/reception/add-form";
        }

        reception.setDate_reception(new Date());
        receptionService.saveReception(reception);
        return "redirect:/reception/";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute Reception reception, BindingResult result, RedirectAttributes redirectAttributes){

        if (result.hasErrors()){
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.reception", result);
            redirectAttributes.addFlashAttribute("reception", reception);
            return "redirect:/reception/add-form";
        }

        reception.setDate_reception(new Date());
        receptionService.saveReception(reception);
        return "redirect:/reception/";
    }

    @GetMapping("/add-form")
    public String add_form(Model model){
        if (!model.containsAttribute("reception")){
            model.addAttribute("reception", new Reception());
        }

        List<Glaciere> glacieres = glaciereService.getAllGlaciere();
        model.addAttribute("glacieres",glacieres);
        return "reception/new";
    }

    @GetMapping("/edit-form")
    public String edit_form(@RequestParam(name="id") long id, Model model){
        if (!model.containsAttribute("reception")){
            model.addAttribute("reception", receptionService.getReceptionById(id));
        }

        List<Glaciere> glacieres = glaciereService.getAllGlaciere();
        model.addAttribute("glacieres",glacieres);
        return "reception/update";
    }

    @GetMapping("/delete")
    public String delete(Long id){
        receptionService.deleteReceptionById(id);
        return "redirect:/reception/";
    }
}
