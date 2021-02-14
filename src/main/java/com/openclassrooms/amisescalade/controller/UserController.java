package com.openclassrooms.amisescalade.controller;

import com.openclassrooms.amisescalade.model.User;
import com.openclassrooms.amisescalade.service.SecteurService;
import com.openclassrooms.amisescalade.service.TopoService;
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

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private static final String USER = "user";
    private static final String SECTEUR = "SECTEUR";
    private static final String TOPO = "topo";

    @Autowired
    private UserService userService;

    @Autowired
    private TopoService topoService;

    @Autowired
    private SecteurService secteurService;

    @GetMapping("/registration")
    public ModelAndView registration(Model model) {
        model.addAttribute(USER, new User());
        return new ModelAndView("/registration");
    }

    @PostMapping("/registration")
    public ModelAndView addUser(Model model, @ModelAttribute(USER) User user) {

        User existingUser = userService.findUserByEmail(user.getEmail());
        if (existingUser != null) {
            logger.info("Tentative de création d'un membre avec un email déjà enregistré: ");
            model.addAttribute("message", "l'adresse mail est deja utilisé");
            return new ModelAndView("/registration");
        }
        if (!MailUtils.isValid(user.getEmail())) {
            model.addAttribute("message", "Adresse mail invalide");
            return new ModelAndView("/registration");
        }
        logger.info(" UN nouveau membre : " + user.getName() + " " + user.getLastName() + " " + user.getEmail() + " " + user.getPassword());
        userService.addUser(user);
        return new ModelAndView("/messageSignup");
    }

    @GetMapping(value = "/login")
    public ModelAndView loginGet(Model model) {
        model.addAttribute(USER, new User());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            return new ModelAndView("redirect:/sites");
        }
        return new ModelAndView("/login");
    }

    @GetMapping(value = "/personalPages")
    public String personalPages(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        logger.info("user connecter : {} ", user.getRole().getAuthority());
        model.addAttribute(SECTEUR, secteurService.findAll());
        model.addAttribute(USER, user);
        model.addAttribute(TOPO, topoService.findAll());
        return "/personalPages";
    }
}
