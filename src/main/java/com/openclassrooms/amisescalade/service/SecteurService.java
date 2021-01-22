package com.openclassrooms.amisescalade.service;

import com.openclassrooms.amisescalade.model.Secteur;
import com.openclassrooms.amisescalade.model.User;

import java.util.List;

public interface SecteurService {

    List<Secteur> findAll();

    Secteur findById(Long id);

    Secteur userId(User user);

    void add(Secteur secteur);

    void edit(Secteur secteur);

    void delete(Long id);
}
