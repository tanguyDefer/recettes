package com.recette.projet.controllers;

import com.recette.projet.repository.ProvenanceRecetteRepository;
import com.recette.projet.repository.RecetteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class HomeController {

    @Autowired
    ProvenanceRecetteRepository provenanceRecetteRepository;
    public HomeController() {
        // TODO Auto-generated constructor stub
    }

    @GetMapping
    public String home(Model model) {
        model.addAttribute("titrePage", "Bienvenue sur Recettes");
        model.addAttribute("displayAcceuil", true);
        model.addAttribute("menuAcceuil", true);
        model.addAttribute("showAcceuilBtn", true);
        model.addAttribute("provenanceRecette", provenanceRecetteRepository.findAll());
        return "homePage";
    }

    @GetMapping("/error")
    public String error(Model model) {
        model.addAttribute("titrePage", "Erreur");
        return "homePage";
    }
}
