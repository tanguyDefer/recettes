package com.recette.projet.repository;

import com.recette.projet.entities.recette.FormatRecette;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FormatRecetteRepository extends JpaRepository<FormatRecette, Long> {

    @Query("select format from FormatRecette format where format.id <> :id")
    public Iterable<FormatRecette> findAllExceptOne(Long id);
}
