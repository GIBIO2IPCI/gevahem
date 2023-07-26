package com.ipci.gevahem.controller;

import com.ipci.gevahem.security.Service.RoleService;
import com.ipci.gevahem.security.Service.AppUserService;
import com.ipci.gevahem.security.entity.Role;
import com.ipci.gevahem.security.entity.AppUser;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collection;

@Controller
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final AppUserService appUserService;
    private final RoleService roleService;

    @GetMapping("")
    public String index(Model model) {

        model.addAttribute("users", appUserService.getAllUsers());
        return "user/index";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute AppUser user, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.user", result);
            redirectAttributes.addFlashAttribute("user", user);
            return "redirect:/user/add-form";
        }

        try {
            appUserService.addUser(user);
        } catch (Exception e) {
            result.rejectValue("username", "error.user", "Ce username existe déjà");
            return "redirect:/user/add-form";
        }

        return "redirect:/user";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute AppUser user, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.user", result);
            redirectAttributes.addFlashAttribute("user", user);
            return "redirect:/user/edit-form?id=" + user.getId();
        }

        try {
            appUserService.addUser(user);
        } catch (Exception e) {
            result.rejectValue("username", "error.user", "Ce username existe déjà");
            return "redirect:/user/edit-form";
        }

        return "redirect:/user";
    }

    @GetMapping("/add-form")
    public String add_form(Model model) {
        if (!model.containsAttribute("user")){
            model.addAttribute("user", new AppUser());
        }

        Collection<Role> roles = roleService.getAllRoles();
        model.addAttribute("roles", roles);
        return "user/new";
    }

    @GetMapping("/edit-form")
    public String edit_form(@RequestParam(name = "id") long id, Model model){
        if (!model.containsAttribute("user")){
            model.addAttribute("user", appUserService.getUserById(id));
        }

        Collection<Role> roles = roleService.getAllRoles();
        model.addAttribute("roles", roles);
        return "user/update";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(name = "id") long id) {
        appUserService.deleteUser(id);
        return "redirect:/user";
    }
}
