package com.recette.projet.controllers.advice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageErrorController {

    public PageErrorController() {
        // TODO Auto-generated constructor stub
    }

    @GetMapping("/notFound")
    public String pageNotFound(Model model) {
        model.addAttribute("titre", "404 NOT FOUND");
        return "error/notFound";
    }

    @GetMapping("/badGateway")
    public String badGateway() {
        return "Problème de sécurité !";
    }

}
