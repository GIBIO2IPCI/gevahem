package com.ipci.gevahem.controller;

import com.ipci.gevahem.service.ConservationService;
import com.ipci.gevahem.service.PreparationService;
import com.ipci.gevahem.service.ReceptionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.Date;

@Controller
@AllArgsConstructor
public class HomeController {

    private final ReceptionService receptionService;
    private final PreparationService preparationService;
    private final ConservationService conservationService;

    @GetMapping("/")
    public String home(Model model) {

        long total_reception = receptionService.getAllReception().size();
        long total_preparation = preparationService.getAllPreparations().size();
        long total_conservation = conservationService.getAllConservation().size();

        Date day = new Date();

        model.addAttribute("total_reception", total_reception);
        model.addAttribute("total_reception_jour", receptionService.getByDate("yyyy-MM-dd").size());
        model.addAttribute("total_reception_mois", receptionService.getByDate("yyyy-MM").size());

        model.addAttribute("total_preparation", total_preparation);
        model.addAttribute("total_preparation_jour", preparationService.getByDate("yyyy-MM-dd").size());
        model.addAttribute("total_preparation_mois", preparationService.getByDate("yyyy-MM").size());

        model.addAttribute("total_conservation", total_conservation);
        model.addAttribute("total_conservation_jour", conservationService.getByDate("yyyy-MM-dd").size());
        model.addAttribute("total_conservation_mois", conservationService.getByDate("yyyy-MM").size());

        System.out.println(day);

        return "home";
    }
}
