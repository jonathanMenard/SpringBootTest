package com.example.entrevueSpringBoot.web.controller;

import com.example.entrevueSpringBoot.dao.ActeurDao;
import com.example.entrevueSpringBoot.dao.FilmDao;
import com.example.entrevueSpringBoot.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FilmController {

    @Autowired
    private FilmDao filmDao;

    @Autowired
    private ActeurDao acteurDao;

    @GetMapping(value = "/api/film/{id}")
    public Film afficherUnFilm(@PathVariable int id) {

        Film film = filmDao.findById(id);

        return film;
    }

    @PostMapping(value = "/api/film")
    public ResponseEntity<Film> ajouterFilm(@RequestBody Film film) {

        //nous ajoutons le film à la BD
        Film filmAjoute =  filmDao.save(film);

        //nous ajoutons les acteurs
        filmAjoute.getActeurs().forEach( (acteur) ->{
            acteur.setFilm(filmAjoute);
            acteurDao.save(acteur);
        });

        return new ResponseEntity<Film>(filmAjoute, HttpStatus.CREATED);
    }
}
