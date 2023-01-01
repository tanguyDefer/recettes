package com.recette.projet.controllers;

import com.recette.projet.entities.Utilisateur;
import com.recette.projet.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/utilisateur")
public class UtilisateurController {

    @Autowired
    UtilisateurRepository utilisateurRepository;

    @GetMapping
    public String welcome() {return "Welcome REST CONTOLLER: UTILISATEUR";}

    @GetMapping("/all")
    public String findAll(Model model) {
        model.addAttribute("utilisateurs", utilisateurRepository.findAll());
        return "utilisateur/utilisateurs";
    }

}
