package com.example.entrevueSpringBoot.model;

import java.util.List;

import javax.persistence.*;


@Entity
public class Film {

    @Id
    @GeneratedValue
    private long id;

    private String titre;

    private String description;

    @OneToMany(mappedBy="film")
    private List<Acteur> acteurs;


    //constructeurs

    public Film() {

    }

    public Film(String titre, String description, List<Acteur> acteurs) {
        this.titre = titre;
        this.description = description;
        this.acteurs = acteurs;

    }

    //getter et setter

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Acteur> getActeurs() {
        return acteurs;
    }

    public void setActeurs(List<Acteur> acteurs) {

        this.acteurs = acteurs;

    }


}
