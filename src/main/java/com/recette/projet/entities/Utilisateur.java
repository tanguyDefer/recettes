package com.recette.projet.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
@Table(name = "utilisateur")
public class Utilisateur implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_utilisateur")
    private Long id;

    @NotNull
    @Column(name = "pseudo_utilisateur")
    private String pseudoUtilisateur;

    @NotNull
    @Column(name = "mot_de_passe_utilisateur")
    private String password;

    public Utilisateur() {
        // TODO Auto-generated constructor stub
    }

    public Utilisateur(String pseudoUtilisateur, String password) {
        super();
        this.pseudoUtilisateur = pseudoUtilisateur;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + id +
                ", pseudoUtilisateur='" + pseudoUtilisateur + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getPseudoUtilisateur() {
        return pseudoUtilisateur;
    }

    public void setPseudoUtilisateur(String pseudoUtilisateur) {
        this.pseudoUtilisateur = pseudoUtilisateur;
    }
    // !!!!!!!!!!!!!!!!!!!!!!! SPRING SECURITY !!!!!!!!!!!!!!!!!!!!!!! \\
    @Override
    public boolean isAccountNonExpired() {
        return false;
    }


    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        //Faire des liens les profils
//        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
//        for (Role role : this.roles) {
//            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getLibelleRole()));
//        }
//
//        return authorities;
//    }


    public String getUsername() {
        return pseudoUtilisateur;
    }

    public void setUsername(String pseudo_utilisateur) {
        this.pseudoUtilisateur = pseudo_utilisateur;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String mot_de_passe_utilisateur) {
        this.password = mot_de_passe_utilisateur;

    }

    // !!!!!!!!!!!!!!!!!!!!!!! SPRING SECURITY !!!!!!!!!!!!!!!!!!!!!!! \\
}
