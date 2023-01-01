package com.recette.projet.repository;

import com.recette.projet.entities.recette.ProvenanceRecette;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProvenanceRecetteRepository extends JpaRepository<ProvenanceRecette, Long> {

}
