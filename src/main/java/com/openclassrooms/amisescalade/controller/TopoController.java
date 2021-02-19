package com.openclassrooms.amisescalade.controller;

import com.openclassrooms.amisescalade.model.Topo;
import com.openclassrooms.amisescalade.model.User;
import com.openclassrooms.amisescalade.service.TopoService;
import com.openclassrooms.amisescalade.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Controller MVC pour gérer les fonctionnalités d'un topo.
 *
 */
@Controller
public class TopoController {

    private static final String TOPO = "topo";
    private static final String UTILISATEUR = "utilisateur";

    @Autowired
    private TopoService topoService;

    @Autowired
    private UserService userService;

    /**
     * Consulter la liste des topos.
     *
     * @param model
     * @return la liste des topos.
     */
    @GetMapping("/topos")
    public String tousLesTopos(Model model) {
        model.addAttribute(TOPO, topoService.findAll());
        return "/topo/topos";
    }

    /**
     * Initialisation de la page d'ajout d'un topo.
     *
     * @param model
     * @return
     */
    @GetMapping("/addTopo")
    public String addTopo(Model model, Authentication authentication) {
        model.addAttribute(TOPO, new Topo());
        model.addAttribute(UTILISATEUR, authentication);
        return "/topo/addTopo";
    }

    /**
     * Ajout d'un nouveau topo.
     *
     * @param topo nouveau topo à ajouter.
     * @return
     */
    @PostMapping("/addTopo")
    public String addTopo(@ModelAttribute(TOPO) Topo topo) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        topo.setUserWithTopo(userService.findUserByEmail(authentication.getName()));
        topo.setAvailable(true);
        topoService.add(topo);
        return "redirect:/topos";
    }

    /**
     * Initialisation de la page de modification d'un topo.
     *
     * @param id identifiant du site à modifier.
     * @return
     */
    @GetMapping("/editTopo/{id}")
    public String editTopo(Model model, @PathVariable Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute(UTILISATEUR, authentication);
        model.addAttribute(TOPO, topoService.findById(id));
        return "/topo/editTopo";
    }

    /**
     * Modification d'un topo.
     *
     * @param topo topo à modifier.
     * @return
     */
    @PostMapping("/editTopo")
    public String editTopo(@ModelAttribute(TOPO) Topo topo) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        topo.setUserWithTopo(userService.findUserByEmail(authentication.getName()));
        topo.setAvailable(true);
        topoService.edit(topo);
        return "redirect:/";
    }

    /**
     * Initialisation de la page de reservation d'un topo.
     *
     * @param model
     * @return
     */
    @GetMapping("/bookingTopo/{topoId}")
    public String bookingTopo(Model model, @PathVariable Long topoId) {
        model.addAttribute(TOPO, topoService.findById(topoId));
        return "/topo/bookingTopo";
    }

    /**
     * reservation d'un topo.
     *
     * @param model
     * @return
     */
    @PostMapping("/bookingTopo")
    public String bookingTopo(Model model, @ModelAttribute(TOPO) Topo topo) {
        Topo requestReservation = topoService.findById(topo.getId());
        User user = userService.findUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        topo.setAvailable(false);
        topoService.requestReservation(requestReservation, user);
        return ("/confirmReservation");
    }

    /**
     * Confirmation de reservation d'un topo.
     *
     * @param
     * @return
     */
    @GetMapping("/confirmReservation")
    public String confimReservation() {
        return "/confirmReservation";
    }

    /**
     * Initialisation de la page de pour accepter la reservation d'un topo.
     *
     * @param
     * @return
     */
    @GetMapping("/acceptReservation/{topoId}")
    public String acceptReservation(Model model, @PathVariable Long topoId) {
        model.addAttribute(TOPO, topoService.findById(topoId));
        return "/topo/acceptReservation";
    }

    /**
     * Accepter la reservation d'un topo.
     *
     * @param
     * @return
     */
    @PostMapping("/acceptReservation")
    public String ReservationValidated(@ModelAttribute(TOPO) Topo topo) {
        Topo topoAValider = topoService.findById(topo.getId());
        topoService.validationReservation(topoAValider);
        return "redirect:/personalPages";
    }

    /**
     * Suppression d'un topo à partir de son identifiant.
     *
     * @param model identifiant du topo à supprimer.
     * @return
     */
    @GetMapping("/deleteTopo/{topoId}")
    public String supprimerTopo(Model model, @PathVariable Long topoId) {
        topoService.delete(topoId);
        return "redirect:/topos";
    }

    /**
     * Initialisation de la page de pour refuser la reservation d'un topo.
     *
     * @param model
     * @return
     */
    @GetMapping("/refuseReservation/{topoId}")
    public String refuserResa(Model model, @PathVariable Long topoId) {
        model.addAttribute("topo", topoService.findById(topoId));
        return ("/topo/refuseReservation");
    }

    /**
     * Refuser la reservation d'un topo.
     *
     * @param topo
     * @return
     */
    @PostMapping("/refuseReservation")
    public String reservationRefusee(@ModelAttribute(TOPO) Topo topo) {
        Topo topoArefuser = topoService.findById(topo.getId());
        topoService.refusReservation(topoArefuser);
        return ("redirect:/topos");
    }
}
