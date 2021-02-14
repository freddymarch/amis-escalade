package com.openclassrooms.amisescalade.controller;

import com.openclassrooms.amisescalade.model.Commentaire;
import com.openclassrooms.amisescalade.model.Secteur;
import com.openclassrooms.amisescalade.model.User;
import com.openclassrooms.amisescalade.service.SecteurService;
import com.openclassrooms.amisescalade.service.SiteService;
import com.openclassrooms.amisescalade.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class SecteurController {

    private static final Logger logger = LoggerFactory.getLogger(SecteurController.class);
    private static final String SECTEUR = "secteur";
    private static final String COMMENTAIRE = "commentaire";

    @Autowired
    private SecteurService secteurService;

    @Autowired
    private SiteService siteService;

    @Autowired
    private UserService userService;

    @GetMapping("/addSecteur")
    public String addSecteur(Model model, @RequestParam Long id) {
        Secteur secteur = new Secteur();
        secteur.setSite(siteService.findById(id));
        model.addAttribute(SECTEUR, secteur);
        return "/secteur/addSecteur";
    }

    @PostMapping("/addSecteur")
    public String addSecteur(@ModelAttribute(SECTEUR) Secteur secteur, @ModelAttribute(COMMENTAIRE) Commentaire commentaire) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        secteur.setUser(userService.findUserByEmail(authentication.getName()));
        logger.info("Création d'un nouveau secteur : {}", secteur);
        secteurService.add(secteur);
        return "redirect:/sites";
    }

    @GetMapping("/editSecteur/{id}")
    public String recoverSecteur(Model model, @PathVariable Long id) {
        model.addAttribute(SECTEUR, secteurService.findById(id));
        return "/secteur/editSecteur";
    }

    @PostMapping("/editSecteur")
    public String editSecteur(@ModelAttribute(SECTEUR) Secteur secteur) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        secteur.setUser(userService.findUserByEmail(authentication.getName()));
        secteurService.edit(secteur);
        return "redirect:/sites";
    }

    @GetMapping("/deleteSecteur/{id}")
    public String deleteSecteur(@PathVariable Long id) {
        secteurService.delete(id);
        return "redirect:/sites";
    }
}
