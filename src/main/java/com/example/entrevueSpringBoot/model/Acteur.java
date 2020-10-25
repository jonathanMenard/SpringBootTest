package com.example.entrevueSpringBoot.model;

import javax.persistence.*;


@Entity
public class Acteur {

    @Id
    @GeneratedValue
    private long id;

    private String nom;

    private String prenom;

    @ManyToOne
    @JoinColumn(name="film_id")
    private Film film;

    //constructeurs

    public Acteur(){

    }

    public Acteur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }


    //getters et setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }


    public void setFilm(Film  film) {
        this.film = film;

        if(!film.getActeurs().contains(this)){
            film.getActeurs().add(this);
        }
    }
}
