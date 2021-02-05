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

@Controller
public class TopoController {

    private static final String TOPO = "topo";
    private static final String UTILISATEUR = "utilisateur";

    @Autowired
    private TopoService topoService;

    @Autowired
    private UserService userService;

    @GetMapping("/topos")
    public String tousLesTopos(Model model) {
        model.addAttribute(TOPO, topoService.findAll());
        return "/topo/topos";
    }

    @GetMapping("/addTopo")
    public String addTopo(Model model, Authentication authentication) {
        model.addAttribute(TOPO,new Topo());
        model.addAttribute(UTILISATEUR, authentication);
        return "/topo/addTopo";
    }

    @PostMapping("/addTopo")
    public String addTopo(@ModelAttribute(TOPO) Topo topo) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        topo.setUserWithTopo(userService.findUserByEmail(authentication.getName()));
        topo.setAvailable(true);
        topoService.add(topo);
        return "redirect:/topos";
    }

    @GetMapping("/editTopo/{id}")
    public String editTopo(Model model, @PathVariable Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute(UTILISATEUR, authentication);
        model.addAttribute(TOPO, topoService.findById(id));
        return "/topo/editTopo";
    }

    @PostMapping("/editTopo")
    public String editTopo(@ModelAttribute(TOPO) Topo topo) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        topo.setUserWithTopo(userService.findUserByEmail(authentication.getName()));
        topo.setAvailable(true);
        topoService.edit(topo);
        return "redirect:/";
    }

    @GetMapping("/bookingTopo/{topoId}")
    public String bookingTopo(Model model,@PathVariable Long topoId){
        model.addAttribute(TOPO,topoService.findById(topoId));
        return "/topo/bookingTopo";
    }

    @PostMapping("/bookingTopo")
    public String bookingTopo(Model model,@ModelAttribute(TOPO) Topo topo) {
        Topo requestReservation = topoService.findById(topo.getId());
        User user = userService.findUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        topo.setAvailable(false);
        topoService.requestReservation(requestReservation,user);
        return ("/confirmReservation");
    }

    @GetMapping("/confirmReservation")
    public String confimReservation() {
        return "/confirmReservation";
    }

    @GetMapping("/acceptReservation/{topoId}")
    public String acceptReservation(Model model, @PathVariable Long topoId) {
        model.addAttribute(TOPO, topoService.findById(topoId));
        return "/topo/acceptReservation";
    }

    @PostMapping("/acceptReservation")
    public String ReservationValidated(@ModelAttribute(TOPO) Topo topo) {
        Topo topoAValider = topoService.findById(topo.getId());
        topoService.validationReservation(topoAValider);
        return "redirect:/personalPages";
    }

    @GetMapping("/deleteTopo/{topoId}")
    public String supprimerTopo(Model model, @PathVariable Long topoId) {
        topoService.delete(topoId);
        return "redirect:/topo/topos";
    }

    @GetMapping("/refuseReservation/{topoId}")
    public String refuserResa(Model model, @PathVariable Long topoId) {
        model.addAttribute("topo", topoService.findById(topoId));
        return ("/topo/refuseReservation");
    }

    @PostMapping("/refuseReservation")
    public String reservationRefusee(@ModelAttribute(TOPO) Topo topo) {
        Topo topoArefuser = topoService.findById(topo.getId());
        topoService.refusReservation(topoArefuser);
        return ("redirect:/topos");
    }
}
