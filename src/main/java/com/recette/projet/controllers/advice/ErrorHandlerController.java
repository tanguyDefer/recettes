package com.recette.projet.controllers.advice;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorHandlerController implements ErrorController {

    @ExceptionHandler(value = {Exception.class})
    @RequestMapping("/error")
    public String getErrorPath(Model model) {
        model.addAttribute("titre", "Erreur");
        return "/error/error";
    }
}
