package com.openclassrooms.amisescalade.controller;


import com.openclassrooms.amisescalade.model.User;
import com.openclassrooms.amisescalade.service.UserService;
import com.openclassrooms.amisescalade.utils.MailUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("user", new User());
        return "/registration";
    }

    @PostMapping("/registration")
    public String addUser(Model model, @ModelAttribute("user") User user) {

        User existingUser = userService.findUserByEmail(user.getEmail());
        if (existingUser != null) {
            logger.info("Tentative de création d'un membre avec un email déjà enregistré: ");
            model.addAttribute("message", "l'adresse mail est deja utilisé");
            return "/registration";
        }
        if (!MailUtils.isValid(user.getEmail())) {
            model.addAttribute("message", "l'adresse mail n'est pas valide");
            return "/registration";
        }
        logger.info(" UN nouveau membre : " + user.getName() + " " + user.getLastName() + " " + user.getEmail() + " " + user.getPassword());
        userService.addUser(user);
        return "/messageSignUp";
    }

    @GetMapping(value = "/login")
    public ModelAndView loginGet(Model model) {
        model.addAttribute("user", new User());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            return new ModelAndView("redirect:/sites");
        }
        return new ModelAndView("/login");
    }

    @PostMapping(value = "/login")
    public ModelAndView loginPost(Model model, @ModelAttribute("user") User user) {
        return new ModelAndView("redirect:/index");
    }

}