package com.recette.projet.repository;

import com.recette.projet.entities.Utilisateur;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    @Query(" select utilisateur from Utilisateur utilisateur " +
            " where utilisateur.pseudoUtilisateur = ?1")
    Optional<Utilisateur> findUserWithName(String username);

}
