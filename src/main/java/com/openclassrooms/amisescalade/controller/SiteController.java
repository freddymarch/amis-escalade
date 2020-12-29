package com.openclassrooms.amisescalade.controller;

import com.openclassrooms.amisescalade.model.Site;
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

@Controller
public class SiteController {

    @Autowired
    SiteService siteService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/sites")
    public String sites(Model model) {
        model.addAttribute("sites", siteService.rechercherTousLesSites());
        return "/sites";
    }

    @GetMapping("/site/{id}")
    public String site(Model model, @PathVariable Long id) {
        model.addAttribute("site", siteService.rechercherSiteParId(id));
        return "/site";
    }

    @GetMapping("/addSite")
    public String addSite(Model model) {
        model.addAttribute("site", new Site());
        return "/addSite";
    }

    @PostMapping("/addSite")
    public String addSite(@ModelAttribute("site") Site site) {
        logger.info(" UN nouveau site : " + site.getNom() + " " + site.getPays() + " " + site.getAdresse() + " " + site.getTag());
        siteService.addSite(site);
        return "/index";
    }

    @GetMapping("/editSite/{id}")
    public String recoverSite(Model model, @PathVariable Long id) {
        model.addAttribute("site", siteService.rechercherSiteParId(id));
        return "/editSite";
    }

    @PostMapping("/editSite")
    public String modifierSite(@ModelAttribute("site") Site site) {
        siteService.editSite(site);
        return "redirect:/sites";
    }

    @GetMapping("/deleteSite/{siteId}")
    public String deleteSite(Model model, @PathVariable Long Id) {
        siteService.deleteSite(Id);
        return "/sites";
    }
}
