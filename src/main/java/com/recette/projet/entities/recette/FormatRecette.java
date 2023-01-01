package com.recette.projet.entities.recette;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="FORMAT_RECETTE")
public class FormatRecette {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_format_recette")
    private Long id;

    @Column(name = "libelle_format_recette")
    private String libelleFormatRecette;

//    @NotNull
//    @ManyToMany(mappedBy="formatsRecette")
//    private Set<Recette> recettes = new HashSet<Recette>();

    public FormatRecette() {
        // TODO Auto-generated constructor stub
    }
    public Long getId() {
        return id;
    }

//    public Set<Recette> getRecettes() {
//        return recettes;
//    }
//
//    public void setRecettes(Set<Recette> recettes) {
//        this.recettes = recettes;
//    }

    @Override
    public String toString() {
        return "FormatRecette{" +
                "id=" + id +
                ", libelleFormatRecette='" + libelleFormatRecette + '\'' +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelleFormatRecette() {
        return libelleFormatRecette;
    }

    public void setLibelleFormatRecette(String libelleFormatRecette) {
        this.libelleFormatRecette = libelleFormatRecette;
    }
}
