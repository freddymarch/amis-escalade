package com.openclassrooms.amisescalade.controller;

import com.openclassrooms.amisescalade.model.Commentaire;
import com.openclassrooms.amisescalade.model.Site;
import com.openclassrooms.amisescalade.model.User;
import com.openclassrooms.amisescalade.service.CommentaireService;
import com.openclassrooms.amisescalade.service.SecteurService;
import com.openclassrooms.amisescalade.service.SiteService;
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

    @Autowired
    private SiteService siteService;

    @Autowired
    private SecteurService secteurService;

    @Autowired
    private CommentaireService commentaireService;

    @GetMapping("/sites")
    public String sites(Model model) {
        model.addAttribute(SITES, siteService.searchAllSites());
        return "/site/sites";
    }

    @GetMapping("/site/{id}")
    public String secteur(Model model, @PathVariable Long id) {
        model.addAttribute(SITE, siteService.searchSiteid(id));
        model.addAttribute("secteur", secteurService.searchAllSecteur());
        model.addAttribute("commentaire", commentaireService.searchAllCommentaire());
        return "/site/site";
    }

    @GetMapping("/addSite")
    public String addSite(Model model) {
        model.addAttribute(SITE, new Site());
        return "/site/addSite";
    }

    @PostMapping("/addSite")
    public String addSite(@ModelAttribute("site") Site site) {
        logger.info(" Un nouveau site : " + site.getNom() + " " + site.getPays() + " " + site.getAdresse() + " " + site.getTag());
        siteService.addSite(site);
        return "redirect:/sites";
    }

    @GetMapping("/editSite/{id}")
    public String recoverSite(Model model, @PathVariable Long id) {
        model.addAttribute(SITE, siteService.searchSiteid(id));
        return "/site/editSite";
    }

    @PostMapping("/editSite")
    public String editSite(@ModelAttribute("site") Site site) {
        siteService.editSite(site);
        return "redirect:/sites";
    }

    @GetMapping("/deleteSite/{id}")
    public String deleteSite(@PathVariable Long id) {
        siteService.deleteSite(id);
        return "redirect:/sites";
    }

    @GetMapping("/addCommentaire")
    public String addCommentaire(Model model, @RequestParam Long idSite) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        model.addAttribute("user", user);
        //Site site = siteService.rechercherSiteParId(siteId);
        //model.addAttribute("site", site);

        model.addAttribute("commentaire", commentaireService.siteId(siteService.searchSiteid(idSite)));
        return "/commentaire/addCommentaire";
    }

    @PostMapping("/addCommentaire")
    public String addCommentaire(@ModelAttribute("commentaire") Commentaire commentaire) {
        commentaireService.addCommentaire(commentaire);
        return "redirect:/sites";
    }

    @GetMapping("/editCommentaire/{id}")
    public String recoverCommentaire(Model model, @PathVariable Long id) {
        model.addAttribute("commentaire", commentaireService.searchCommentaireById(id));
        return "/commentaire/editCommentaire";
    }

    @PostMapping("/editCommentaire")
    public String editCommentaire(@ModelAttribute("commentaire") Commentaire commentaire) {
        commentaireService.editCommentaire(commentaire);
        return "redirect:/sites";
    }

    @GetMapping("/deleteCommentaire/{id}")
    public String deleteCommentaire(@PathVariable Long id) {
        commentaireService.deleteCommentaire(id);
        return "redirect:/sites";
    }
}
