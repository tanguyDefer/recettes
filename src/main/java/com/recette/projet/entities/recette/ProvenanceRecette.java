package com.recette.projet.entities.recette;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PROVENANCE_RECETTE")
public class ProvenanceRecette {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_provenance_recette")
    private Long id;

    @Column(name = "nom_provenance_recette")
    private String nomProvenanceRecette;

    @Column(name = "url_provenance_recette")
    private String urlProvenanceRecette;

    @NotNull
    @ManyToMany(mappedBy = "provenanceRecette")
    private Set<Recette> recettes = new HashSet<Recette>();


    @Override
    public String toString() {
        return "ProvenanceRecette{" +
                "id=" + id +
                ", nomProvenanceRecette='" + nomProvenanceRecette + '\'' +
                ", urlProvenanceRecette='" + urlProvenanceRecette + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomProvenanceRecette() {
        return nomProvenanceRecette;
    }

    public void setNomProvenanceRecette(String nomProvenanceRecette) {
        this.nomProvenanceRecette = nomProvenanceRecette;
    }

    public String getUrlProvenanceRecette() {
        return urlProvenanceRecette;
    }

    public void setUrlProvenanceRecette(String urlProvenanceRecette) {
        this.urlProvenanceRecette = urlProvenanceRecette;
    }
}
