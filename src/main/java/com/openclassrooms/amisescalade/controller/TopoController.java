package com.openclassrooms.amisescalade.controller;

import com.openclassrooms.amisescalade.model.Topo;
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

    @Autowired
    private TopoService topoService;

    @Autowired
    private UserService userService;

    @GetMapping("/topos")
    public String tousLesTopos(Model model) {
        model.addAttribute("topos", topoService.searchAllTopo());
        return "/topo/topos";
    }

    @GetMapping("/addTopo")
    public String addTopo(Model model, Authentication authentication) {
        model.addAttribute("topo", new Topo());
        model.addAttribute("utilisateur", authentication);
        return "/topo/addTopo";
    }

    @PostMapping("/addTopo")
    public String addTopo(@ModelAttribute("topo") Topo topo) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        topo.setUserWithTopo(userService.findUserByEmail(authentication.getName()));
        topoService.addTopo(topo);
        return "redirect:/topos";
    }

    @GetMapping("/editTopo/{id}")
    public String editTopo(Model model, @PathVariable Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("utilisateur", authentication);
        model.addAttribute("topo", topoService.searchTopoid(id));
        return "/topo/editTopo";
    }

    @PostMapping("/editTopo")
    public String editTopo(@ModelAttribute("topo") Topo topo) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        topo.setUserWithTopo(userService.findUserByEmail(authentication.getName()));
        topoService.editTopo(topo);
        return "redirect:/";
    }

    @GetMapping("/deleteTopo/{topoId}")
    public String supprimerTopo(Model model, @PathVariable Long topoId) {
        topoService.deleteTopo(topoId);
        return "redirect:/topos";
    }
}
