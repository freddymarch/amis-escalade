package com.openclassrooms.amisescalade.repository;

import com.openclassrooms.amisescalade.model.Research;
import com.openclassrooms.amisescalade.model.Site;

import java.util.List;

/**
 * Repositiory d'accès aux données d'une recherche en base de données.
 */
public interface SiteDAO {

    List<Site> findSiteByCritere(Research research);
}
