package com.ipci.gevahem.controller;

import com.ipci.gevahem.entity.TypeClient;
import com.ipci.gevahem.repository.TypeClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@AllArgsConstructor
@RequestMapping("/typeclient")
public class TypeClientController {
    private TypeClientRepository typeClientRepository;

    @GetMapping("/")
    public String home() {
        return "type_client/index";
    }
    @PostMapping("/new")
    public String save(@ModelAttribute TypeClient typeClient) {
        typeClientRepository.save(typeClient);
        return new RedirectView("redirect:/typeclient/new-form").getUrl();
    }

    @GetMapping("/new-form")
    public String formTypeClient(Model model) {
        TypeClient typeClient = new TypeClient();
        model.addAttribute("typeClient", typeClient);
        return "type_client/new";
    }
}
