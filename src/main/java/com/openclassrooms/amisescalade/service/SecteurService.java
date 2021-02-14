package com.openclassrooms.amisescalade.service;

import com.openclassrooms.amisescalade.model.Secteur;

import java.util.List;

public interface SecteurService {

    List<Secteur> findAll();

    Secteur findById(Long id);

    void add(Secteur secteur);

    void edit(Secteur secteur);

    void delete(Long id);
}
