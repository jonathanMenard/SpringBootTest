package com.example.entrevueSpringBoot.dao;

import com.example.entrevueSpringBoot.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmDao extends JpaRepository<Film, Long> {

    Film findById(long id);

}
