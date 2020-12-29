package com.openclassrooms.amisescalade.controller;

import com.openclassrooms.amisescalade.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

    @Autowired
    private UserService userService;


    @GetMapping("/")
    public String welcome(Model model) {
        return "/index";
    }

}
