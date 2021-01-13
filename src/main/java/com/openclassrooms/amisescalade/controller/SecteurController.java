package com.openclassrooms.amisescalade.controller;

import com.openclassrooms.amisescalade.model.Secteur;
import com.openclassrooms.amisescalade.service.SecteurService;
import com.openclassrooms.amisescalade.service.SiteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SecteurController {

    private static final Logger logger = LoggerFactory.getLogger(SecteurController.class);
    private static final String SECTEUR = "secteur";

    @Autowired
    private SecteurService secteurService;

    @Autowired
    private SiteService siteService;

    @GetMapping("/addSecteur")
    public String addSecteur(Model model, @RequestParam Long id) {
        model.addAttribute(SECTEUR, secteurService.siteId(siteService.searchSiteid(id)));
        return "/secteur/addSecteur";
    }

    @PostMapping("/addSecteur")
    public String addSecteur(@ModelAttribute("secteur") Secteur secteur) {
        logger.info("Création d'un nouveau secteur : {}", secteur);
        secteurService.addSecteur(secteur);
        return "redirect:/sites";
    }

    @GetMapping("/editSecteur/{id}")
    public String recoverSecteur(Model model, @PathVariable Long id) {
        model.addAttribute(SECTEUR, secteurService.searchSecteurId(id));
        return "/secteur/editSecteur";
    }

    @PostMapping("/editSecteur")
    public String editSecteur(@ModelAttribute("secteur") Secteur secteur) {
        secteurService.editSecteur(secteur);
        return "redirect:/sites";
    }

    @GetMapping("/deleteSecteur/{id}")
    public String deleteSecteur(@PathVariable Long id) {
        secteurService.deleteSecteur(id);
        return "redirect:/sites";
    }
}
