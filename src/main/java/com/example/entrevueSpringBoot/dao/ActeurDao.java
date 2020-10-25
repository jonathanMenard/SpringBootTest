package com.example.entrevueSpringBoot.dao;

import com.example.entrevueSpringBoot.model.Acteur;
import com.example.entrevueSpringBoot.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActeurDao extends JpaRepository<Acteur, Long> {

    Acteur findById(long id);
}
