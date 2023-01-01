package com.recette.projet.controllers.advice;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.*;
import java.sql.SQLException;

@ControllerAdvice
public class ErrorController {

    public ErrorController() {
        // TODO Auto-generated constructor stub
    }

    @ExceptionHandler(value =
            {ConstraintDeclarationException.class, ConstraintDefinitionException.class,
                    UnexpectedTypeException.class, ConstraintViolationException.class,
                    SQLException.class, ValidationException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)

    public String errorSqlException(Exception e) {

        return "Erreur d'intégrité ou de validation : " + e.getMessage();
    }

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public String errorGeneralException(Model model, Exception e) {

        return "Il y a une erreur : " + e.getMessage();
    }

}
