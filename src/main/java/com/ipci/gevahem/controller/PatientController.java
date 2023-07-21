package com.ipci.gevahem.controller;

import com.ipci.gevahem.entity.Patient;
import com.ipci.gevahem.service.PatientService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;

@Controller
@AllArgsConstructor
@RequestMapping("/patient")
public class PatientController {

    private final PatientService patientService;

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("patients", patientService.getAllPatient());
        return "patient/index";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute Patient patient, BindingResult result, RedirectAttributes redirectAttributes){
        if (result.hasErrors()){
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.patient", result);
            redirectAttributes.addFlashAttribute("patient", patient);
            return "redirect:/patient/add-form";
        }

        try {
            patientService.savePatient(patient);
        }catch (Exception e){
            result.rejectValue("contact", "error.patient", "Ce contact existe déjà");
            return "redirect:/patient/add-form";
        }
        Date temps = new Date();
        patient.setCode("PAT" + temps.getTime());
        patientService.savePatient(patient);

        return "redirect:/patient";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute Patient patient, BindingResult result, RedirectAttributes redirectAttributes){
        if (result.hasErrors()){
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.ambulancier", result);
            redirectAttributes.addFlashAttribute("patient", patient);
            return "redirect:/patient/edit-form?id=" + patient.getId();
        }

        try {
            patientService.savePatient(patient);
        }catch (Exception e){
            result.rejectValue("contact", "error.patient", "Ce contact existe déjà");
            return "redirect:/patient/edit-form?id=" + patient.getId();
        }

        return "redirect:/patient";
    }

    @GetMapping("/add-form")
    public String add_form(Model model){
        if (!model.containsAttribute("patient")){
            model.addAttribute("patient", new Patient());
        }

        return "patient/new";
    }

    @GetMapping("/edit-form")
    public String edit_form(@RequestParam(name = "id") long id, Model model){
        if (!model.containsAttribute("patient")){
            model.addAttribute("patient", patientService.getPatientById(id));
        }

        return "patient/update";
    }

    @GetMapping("/delete")
    public String delete(Long id){
        patientService.deletePatientById(id);
        return "redirect:/patient";
    }
}
