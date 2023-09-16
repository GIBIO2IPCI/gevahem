package com.ipci.gevahem.controller;
import com.ipci.gevahem.entity.Cryoconservateur;
import com.ipci.gevahem.service.CryoconservateurService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@AllArgsConstructor
@RequestMapping("/cryoconservateur")
public class CryoconservateurController {
    private final CryoconservateurService cryoconservateurService;
    @GetMapping("")
    public String index(Model model){
        model.addAttribute("cryoconservateurs", cryoconservateurService.getAllCryoconservateur());
        return "cryoconservateur/index";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute Cryoconservateur cryoconservateur,BindingResult result, RedirectAttributes redirectAttributes){
        if (result.hasErrors()){
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.cryoconservateur", result);
            redirectAttributes.addFlashAttribute("cryoconservateur", cryoconservateur);
            return "redirect:/cryoconservateur/add-form";
        }
        try {
            cryoconservateurService.saveCryoconservateur(cryoconservateur);
        }catch (Exception e){
            result.rejectValue("nom", "error.cryoconservateur", "Ce nom existe déjà");
            return "redirect:/cryoconservateur/add-form";
        }

        return "redirect:/cryoconservateur";
    }

    @GetMapping("/add-form")
    public String add_form(Model model){
        if (!model.containsAttribute("cryoconservateur")){
            model.addAttribute("cryoconservateur", new Cryoconservateur());
        }
        return "cryoconservateur/new";
    }

    @GetMapping("/delete")
    public String delete(Long id){
        cryoconservateurService.deleteCryoconservateurById(id);
        return "redirect:/cryoconservateur";
    }
}
