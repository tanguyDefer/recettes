package com.recette.projet.controllers;

import com.recette.projet.entities.recette.Recette;
import com.recette.projet.repository.FormatRecetteRepository;
import com.recette.projet.repository.ProvenanceRecetteRepository;
import com.recette.projet.repository.RecetteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/recettes")
public class RecetteController {

    @Autowired
    RecetteRepository recetteRepository;

    @Autowired
    FormatRecetteRepository formatRecetteRepository;

    @Autowired
    ProvenanceRecetteRepository provenanceRecetteRepository;


    @GetMapping
    public String welcome() {
        return "Welcome REST CONTROLLER : RECETTE";
    }

    @GetMapping("/{id}")
    public String findAllByProvenance(@PathVariable("id") Long id, Model model) {
        model.addAttribute("recettesFormat", recetteRepository.sortWithFormat(id));
        model.addAttribute("time", recetteRepository.findAllGroupBy());
        model.addAttribute("formats", formatRecetteRepository.findAll());
        model.addAttribute("provenanceRecette", provenanceRecetteRepository.findAll());
        model.addAttribute("provenanceSelected", provenanceRecetteRepository.findById(1L).orElse(null));
        model.addAttribute("focusProvenance", id);
        model.addAttribute("displayAllRecettes", true);
        model.addAttribute("menuHelloFresh", true);
        model.addAttribute("titre", "Recettes venant de Hello Fresh");
        return "recettes/displayAllRecettes";

    }

    @GetMapping("/hellofresh/format/{id}")
    public String findByFormat(@PathVariable("id") Long id, Model model) {
        model.addAttribute("recettesFormat", recetteRepository.sortWithFormatByIdRecette(id));
        model.addAttribute("provenanceRecette", provenanceRecetteRepository.findAll());
        model.addAttribute("idFormat",id);
        model.addAttribute("formats", formatRecetteRepository.findAll());
        model.addAttribute("time", recetteRepository.findAllByFormatGroupBy(id));
        model.addAttribute("provenanceSelected", provenanceRecetteRepository.findById(1L).orElse(null));
        model.addAttribute("focusProvenance", 1);
        model.addAttribute("menuHelloFresh", true);
        model.addAttribute("provenance", 1);
        model.addAttribute("focus", id);
        return "recettes/displayAllRecettes";
    }

    @GetMapping("/hellofresh/{id}")
    public String findById(@PathVariable("id") Long id, Model model) {
        Recette recette = recetteRepository.findById(id).orElse(null);
        assert recette != null;
        model.addAttribute("formats", formatRecetteRepository.findAll());
        model.addAttribute("recettesFormat", recetteRepository.sortWithFormatByIdRecette(id));
        model.addAttribute("provenanceRecette", provenanceRecetteRepository.findAll());
        model.addAttribute("provenanceSelected", provenanceRecetteRepository.findById(1L).orElse(null));
        model.addAttribute("ficheRecette", recetteRepository.findById(id).orElse(null));
        model.addAttribute("focusProvenance", 1);
        model.addAttribute("menuHelloFresh", true);
        model.addAttribute("titre", recette.getLibelleRecette() + " " + recette.getInfosSupp());
        return "recettes/ficheRecette";
    }

    @RequestMapping("/search")
    public String findBySearch(Model model, @Param("keyword") String keyword) {
        if (recetteRepository.findByName(keyword).isEmpty()) {
            model.addAttribute("recettesFormat", recetteRepository.sortWithFormat(1L));
            model.addAttribute("notFind", true);
            model.addAttribute("search", keyword);

        } else {
            model.addAttribute("recettesFormat", recetteRepository.findByName(keyword));
        }
        model.addAttribute("focusProvenance", 1L);
        model.addAttribute("time", recetteRepository.findAllGroupBy());
        model.addAttribute("formats", formatRecetteRepository.findAll());
        model.addAttribute("provenanceRecette", provenanceRecetteRepository.findAll());
        model.addAttribute("provenanceSelected", provenanceRecetteRepository.findById(1L).orElse(null));
        model.addAttribute("focusProvenance", 1);
        model.addAttribute("displayAllRecettesBtn", true);
        model.addAttribute("displayAllRecettes", true);
        model.addAttribute("menuHelloFresh", true);
        return "recettes/displayAllRecettes";
    }

    @RequestMapping("/format/filter/{duree}/{id}")
    public String findBySearchInFormat(Model model, @PathVariable("duree") String duree, @PathVariable("id") Long id) {
        model.addAttribute("recettesFormat", recetteRepository.findByDureeAndFormat(duree, id));
        model.addAttribute("focusProvenance", 1L);
        model.addAttribute("idFormat",id);
        model.addAttribute("focus", id);
        model.addAttribute("time", recetteRepository.findAllByFormatGroupBy(id));
        model.addAttribute("formats", formatRecetteRepository.findAll());
        model.addAttribute("provenanceRecette", provenanceRecetteRepository.findAll());
        model.addAttribute("provenanceSelected", provenanceRecetteRepository.findById(1L).orElse(null));
        model.addAttribute("focusProvenance", 1);
        model.addAttribute("displayAllRecettesBtn", true);
        model.addAttribute("displayAllRecettes", true);
        model.addAttribute("menuHelloFresh", true);
        return "recettes/displayAllRecettes";
    }

    @GetMapping("/filter/{duree}")
    public String findAllByDuree(@PathVariable("duree") String duree, Model model) {
        model.addAttribute("formats", formatRecetteRepository.findAll());
        model.addAttribute("recettesFormat", recetteRepository.findByDuree(duree));
        model.addAttribute("time", recetteRepository.findAllGroupBy());
        model.addAttribute("provenanceRecette", provenanceRecetteRepository.findAll());
        model.addAttribute("provenanceSelected", provenanceRecetteRepository.findById(1L).orElse(null));
        model.addAttribute("focusProvenance", 1);
        model.addAttribute("displayAllRecettesBtn", true);
        model.addAttribute("displayAllRecettes", true);
        model.addAttribute("menuHelloFresh", true);
        return "recettes/displayAllRecettes";

    }

}
