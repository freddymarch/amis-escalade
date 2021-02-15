package com.openclassrooms.amisescalade.controller;

import com.openclassrooms.amisescalade.model.Commentaire;
import com.openclassrooms.amisescalade.model.Site;
import com.openclassrooms.amisescalade.service.CommentaireService;
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

/**
 * Controller MVC pour gérer les fonctionnalités d'un site.
 *
 */
@Controller
public class SiteController {
    private static final Logger logger = LoggerFactory.getLogger(SiteController.class);
    private static final String SITE = "site";
    private static final String SITES = "sites";
    private static final String COMMENTAIRE = "commentaire";

    @Autowired
    private SiteService siteService;

    @Autowired
    private CommentaireService commentaireService;

    @Autowired
    private UserService userService;

    /**
     * Consulter la liste des sites
     *
     * @param model
     * @return la liste des sites.
     */
    @GetMapping("/sites")
    public String sites(Model model) {
        model.addAttribute(SITES, siteService.findAll());
        return "/site/sites";
    }

    /**
     * Consulter les informations détaillées d'un site (le site lui-même, ses secteurs et ses commentaires).
     *
     * @param model
     * @param id Id du site.
     * @return
     */
    @GetMapping("/site/{id}")
    public String secteur(Model model, @PathVariable Long id) {
        model.addAttribute(SITE, siteService.findById(id));
        return "/site/site";
    }

    /**
     * Initialisation de la page d'ajout d'un site.
     *
     * @param model
     * @return
     */
    @GetMapping("/addSite")
    public String addSite(Model model) {
        model.addAttribute(SITE, new Site());
        return "/site/addSite";
    }

    /**
     * Ajout d'un nouveau site
     *
     * @param site nouveau site à ajouter.
     * @return
     */
    @PostMapping("/addSite")
    public String addSite(@ModelAttribute(SITE) Site site) {
        logger.info(" Ajout du nouveau site : " + site.getNom() + " " + site.getPays() + " " + site.getAdresse() + " " + site.getTag());
        siteService.add(site);
        return "redirect:/sites";
    }

    /**
     * Modification d'un site.
     *
     * @param site site à modifier.
     * @return
     */
    @PostMapping("/editSite")
    public String editSite(@ModelAttribute(SITE) Site site) {
        siteService.edit(site);
        return "redirect:/sites";
    }

    /**
     * Initialisation de la page de modification d'un site.
     *
     * @param model
     * @param id identifiant du site à modifier.
     * @return
     */
    @GetMapping("/editSite/{id}")
    public String recoverSite(Model model, @PathVariable Long id) {
        model.addAttribute(SITE, siteService.findById(id));
        return "/site/editSite";
    }

    /**
     * Suppression d'un site à partir de son identifiant.
     *
     * @param id identifiant du site à supprimer.
     * @return
     */
    @GetMapping("/deleteSite/{id}")
    public String deleteSite(@PathVariable Long id) {
        siteService.delete(id);
        return "redirect:/sites";
    }

    /**
     * Initialisation de la page d'ajout d'un commentaire à un site.
     *
     * @param model
     * @param idSite identifiant du site auquel le commentaire sera ajouté.
     * @return
     */
    @GetMapping("/addCommentaire")
    public String addCommentaire(Model model, @RequestParam Long idSite) {
        Site site = siteService.findById(idSite);
        model.addAttribute(SITE, site);
        model.addAttribute(COMMENTAIRE, commentaireService.siteId(siteService.findById(idSite)));
        return "/commentaire/addCommentaire";
    }

    /**
     * Ajouter un commentaire à un site.
     *
     * @param commentaire
     * @return
     */
    @PostMapping("/addCommentaire")
    public String addCommentaire(@ModelAttribute(COMMENTAIRE) Commentaire commentaire) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        commentaire.setUser(userService.findUserByEmail(authentication.getName()));
        commentaireService.add(commentaire);
        return "redirect:/sites";
    }

    /**
     * Consultation d'un commentaire en vue de sa modification
     *
     * @param model
     * @param id identifiant du commentaire.
     * @return
     */
    @GetMapping("/editCommentaire/{id}")
    public String recoverCommentaire(Model model, @PathVariable Long id) {
        model.addAttribute(COMMENTAIRE, commentaireService.findById(id));
        return "/commentaire/editCommentaire";
    }

    /**
     * Modification du commentaire d'un site.
     *
     * @param commentaire commentaire à modifier.
     * @return
     */
    @PostMapping("/editCommentaire")
    public String editCommentaire(@ModelAttribute(COMMENTAIRE) Commentaire commentaire) {
        commentaireService.edit(commentaire);
        return "redirect:/sites";
    }

    /**
     * Suppression d'un commentaire d'un site.
     *
     * @param id identitiant du commentaire à supprimer.
     * @return
     */
    @GetMapping("/deleteCommentaire/{id}")
    public String deleteCommentaire(@PathVariable Long id) {
        commentaireService.delete(id);
        return "redirect:/sites";
    }
}
