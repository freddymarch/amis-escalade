package com.openclassrooms.amisescalade.controller;

import com.openclassrooms.amisescalade.model.Commentaire;
import com.openclassrooms.amisescalade.model.Site;
import com.openclassrooms.amisescalade.model.User;
import com.openclassrooms.amisescalade.service.CommentaireService;
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
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SiteController {
    private static final Logger logger = LoggerFactory.getLogger(SiteController.class);
    private static final String SITE = "site";
    private static final String SITES = "sites";
    private static final String USER = "user";
    private static final String COMMENTAIRE = "commentaire";
    private static final String SECTEUR = "secteur";

    @Autowired
    private SiteService siteService;

    @Autowired
    private SecteurService secteurService;

    @Autowired
    private CommentaireService commentaireService;

    @Autowired
    private UserService userService;

    @GetMapping("/sites")
    public String sites(Model model) {
        model.addAttribute(USER, userService.findAll());
        model.addAttribute(SITES, siteService.findAll());
        return "/site/sites";
    }

    @GetMapping("/site/{id}")
    public String secteur(Model model, @PathVariable Long id , String name) {
        model.addAttribute(USER, userService.fundUserByName(name));
        model.addAttribute(SITE, siteService.findById(id));
        model.addAttribute(SECTEUR, secteurService.findAll());
        model.addAttribute(COMMENTAIRE, commentaireService.findAll());
        return "/site/site";
    }

    @GetMapping("/addSite")
    public String addSite(Model model) {
        model.addAttribute(SITE, new Site());
        return "/site/addSite";
    }

    @PostMapping("/addSite")
    public String addSite(@ModelAttribute(SITE) Site site) {
        logger.info(" Un nouveau site : " + site.getNom() + " " + site.getPays() + " " + site.getAdresse() + " " + site.getTag());
        siteService.add(site);
        return "redirect:/sites";
    }

    @PostMapping("/editSite")
    public String editSite(@ModelAttribute(SITE) Site site) {
        siteService.edit(site);
        return "redirect:/sites";
    }

    @GetMapping("/editSite/{id}")
    public String recoverSite(Model model, @PathVariable Long id) {
        model.addAttribute(SITE, siteService.findById(id));
        return "/site/editSite";
    }


    @GetMapping("/deleteSite/{id}")
    public String deleteSite(@PathVariable Long id) {
        siteService.delete(id);
        return "redirect:/sites";
    }

    @GetMapping("/addCommentaire")
    public String addCommentaire(Model model, @RequestParam Long idSite) {
        Site site = siteService.findById(idSite);
        model.addAttribute(SITE, site);
        model.addAttribute(COMMENTAIRE, commentaireService.siteId(siteService.findById(idSite)));
        return "/commentaire/addCommentaire";
    }

    @PostMapping("/addCommentaire")
    public String addCommentaire(@ModelAttribute(COMMENTAIRE) Commentaire commentaire) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        commentaire.setUser(userService.findUserByEmail(authentication.getName()));
        commentaireService.add(commentaire);
        return "redirect:/sites";
    }

    @GetMapping("/editCommentaire/{id}")
    public String recoverCommentaire(Model model, @PathVariable Long id) {
        model.addAttribute(COMMENTAIRE, commentaireService.findById(id));
        return "/commentaire/editCommentaire";
    }

    @PostMapping("/editCommentaire")
    public String editCommentaire(@ModelAttribute(COMMENTAIRE) Commentaire commentaire) {
        commentaireService.edit(commentaire);
        return "redirect:/sites";
    }

    @GetMapping("/deleteCommentaire/{id}")
    public String deleteCommentaire(@PathVariable Long id) {
        commentaireService.delete(id);
        return "redirect:/sites";
    }
}
