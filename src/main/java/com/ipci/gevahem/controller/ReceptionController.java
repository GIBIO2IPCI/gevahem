package com.ipci.gevahem.controller;

import com.ipci.gevahem.entity.Client;
import com.ipci.gevahem.entity.Reception;
import com.ipci.gevahem.service.ReceptionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reception")
public class ReceptionController {

    private ReceptionService receptionService;

    public ReceptionController(ReceptionService receptionService) {
        this.receptionService = receptionService;
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("receptiions", receptionService.getAllReception());
        return "reception/index";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Reception reception){
        receptionService.saveReception(reception);
        return "redirect:/reception/";
    }

    @GetMapping("/add-form")
    public String add_form(Model model){
        Reception reception = new Reception();
        model.addAttribute("reception",reception);
        return "reception/new";
    }

    @GetMapping("/edit")
    public String edit_form(@RequestParam(name="id") long id, Model model){
        Reception reception = receptionService.getReceptionById(id);
        model.addAttribute("reception", reception);
        return "reception/update";
    }

    @GetMapping("/delete")
    public String delete(Long id){
        receptionService.deleteReceptionById(id);
        return "redirect:/reception/";
    }
}
