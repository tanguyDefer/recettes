package com.recette.projet.entities.recette;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "RECETTE")
public class Recette {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recette")
    private Long id;

    @Column(name = "libelle_recette")
    private String libelleRecette;

    @Column(name = "duree_cuisine_recette")
    private String dureeCuisineRecette;

    @Column(name = "duree_totale_recette")
    private String dureeTotaleRecette;

    @Column(name = "infos_supp")
    private String infosSupp;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "recette_provenance_recette", joinColumns = @JoinColumn(name = "id_recette", referencedColumnName = "id_recette"),
            inverseJoinColumns = @JoinColumn(name = "id_provenance_recette", referencedColumnName = "id_provenance_recette"))
    private List<ProvenanceRecette> provenanceRecette = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "recette_format_recette", joinColumns = @JoinColumn(name = "id_recette", referencedColumnName = "id_recette"),
            inverseJoinColumns = @JoinColumn(name = "id_format_recette", referencedColumnName = "id_format_recette"))
    private List<FormatRecette> formatsRecette = new ArrayList<>();

    @Override
    public String toString() {
        return "Recette{" +
                "id=" + id +
                ", libelleRecette='" + libelleRecette + '\'' +
                ", dureeCuisineRecette='" + dureeCuisineRecette + '\'' +
                ", dureeTotaleRecette='" + dureeTotaleRecette + '\'' +
                ", infosSupp='" + infosSupp + '\'' +
                ", provenanceRecette=" + provenanceRecette +
                ", formatsRecette=" + formatsRecette +
                '}';
    }


    public Recette(Long id, String libelleRecette, String dureeCuisineRecette, String dureeTotaleRecette, String infosSupp, List<ProvenanceRecette> provenanceRecette, List<FormatRecette> formatsRecette) {
        this.id = id;
        this.libelleRecette = libelleRecette;
        this.dureeCuisineRecette = dureeCuisineRecette;
        this.dureeTotaleRecette = dureeTotaleRecette;
        this.infosSupp = infosSupp;
        this.provenanceRecette = provenanceRecette;
        this.formatsRecette = formatsRecette;
    }


    public Recette() {
        // TODO Auto-generated constructor stub
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelleRecette() {
        return libelleRecette;
    }

    public void setLibelleRecette(String libelleRecette) {
        this.libelleRecette = libelleRecette;
    }



    public String getDureeCuisineRecette() {
        return dureeCuisineRecette;
    }

    public void setDureeCuisineRecette(String dureeCuisineRecette) {
        this.dureeCuisineRecette = dureeCuisineRecette;
    }

    public String getDureeTotaleRecette() {
        return dureeTotaleRecette;
    }

    public void setDureeTotaleRecette(String dureeTotaleRecette) {
        this.dureeTotaleRecette = dureeTotaleRecette;
    }

    public String getInfosSupp() {
        return infosSupp;
    }

    public void setInfosSupp(String infosSupp) {
        this.infosSupp = infosSupp;
    }

    public List<FormatRecette> getFormatsRecette() {
        return formatsRecette;
    }

    public void setFormatsRecette(List<FormatRecette> formatsRecette) {
        this.formatsRecette = formatsRecette;
    }

    public List<ProvenanceRecette> getProvenanceRecette() {
        return provenanceRecette;
    }

    public void setProvenanceRecette(List<ProvenanceRecette> provenanceRecette) {
        this.provenanceRecette = provenanceRecette;
    }

}
