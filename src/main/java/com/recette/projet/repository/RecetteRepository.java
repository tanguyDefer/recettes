package com.recette.projet.repository;

import com.recette.projet.entities.recette.Recette;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface RecetteRepository extends JpaRepository<Recette, Long> {
    @Query(nativeQuery = true,
            value = "Select * FROM recette INNER JOIN recette_format_recette ON recette.id_recette = recette_format_recette.id_recette INNER JOIN format_recette ON recette_format_recette.id_format_recette = format_recette.id_format_recette INNER JOIN recette_provenance_recette on recette_provenance_recette.id_recette = recette.id_recette INNER JOIN provenance_recette on recette_provenance_recette.id_provenance_recette = provenance_recette.id_provenance_recette WHERE provenance_recette.id_provenance_recette = :id GROUP BY recette.libelle_recette;")
    public Iterable<Recette> sortWithFormat(Long id);

    @Query(nativeQuery = true,
            value = "Select * FROM recette INNER JOIN recette_format_recette ON recette.id_recette = recette_format_recette.id_recette INNER JOIN format_recette ON recette_format_recette.id_format_recette = format_recette.id_format_recette WHERE recette_format_recette.id_format_recette = :id")
    public Iterable<Recette> sortWithFormatByIdRecette(Long id);

    @Query(nativeQuery = true,
            value = "Select * FROM recette INNER JOIN recette_format_recette ON recette.id_recette = recette_format_recette.id_recette INNER JOIN format_recette ON recette_format_recette.id_format_recette = format_recette.id_format_recette WHERE recette.libelle_recette LIKE %?1%")
    public List<Recette> findByName(String keyword);

    @Query(nativeQuery = true,
            value = "Select * FROM recette INNER JOIN recette_format_recette ON recette.id_recette = recette_format_recette.id_recette INNER JOIN format_recette ON recette_format_recette.id_format_recette = format_recette.id_format_recette WHERE recette.duree_totale_recette LIKE %?1% AND format_recette.id_format_recette = ?2 GROUP BY format_recette.libelle_format_recette")
    public List<Recette> findByDureeAndFormat(String keyword, Long id);

    @Query(nativeQuery = true,
            value = "Select * FROM recette INNER JOIN recette_format_recette ON recette.id_recette = recette_format_recette.id_recette INNER JOIN format_recette ON recette_format_recette.id_format_recette = format_recette.id_format_recette WHERE recette.duree_totale_recette LIKE %?1% GROUP BY format_recette.libelle_format_recette")
    public List<Recette> findByDuree(String keyword);

    @Query(nativeQuery = true,
            value = "Select * FROM recette GROUP BY recette.duree_totale_recette")
    public List<Recette> findAllGroupBy();

    @Query(nativeQuery = true,
            value = "Select * FROM recette INNER JOIN recette_format_recette ON recette.id_recette = recette_format_recette.id_recette INNER JOIN format_recette ON recette_format_recette.id_format_recette =  format_recette.id_format_recette WHERE format_recette.id_format_recette = :id GROUP BY recette.duree_totale_recette")
    public List<Recette> findAllByFormatGroupBy(Long id);
}
