package com.openclassrooms.amisescalade.controller;

import com.openclassrooms.amisescalade.model.Research;
import com.openclassrooms.amisescalade.service.ResearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ResearchController {

    private static final String RESEARCH = "research";

    @Autowired
    private ResearchService researchService;

    @GetMapping("/research")
    public String research(Model model) {
        model.addAttribute(RESEARCH, new Research());
        return "/research";
    }


    @PostMapping("/research")
    public String research(Model model, @ModelAttribute("research") Research research) {
        model.addAttribute("resultatSites", researchService.researchSites(research));
        return "/research";
    }
}
