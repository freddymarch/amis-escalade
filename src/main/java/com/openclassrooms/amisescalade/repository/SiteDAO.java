package com.openclassrooms.amisescalade.repository;

import com.openclassrooms.amisescalade.model.Research;
import com.openclassrooms.amisescalade.model.Site;

import java.util.List;

public interface SiteDao {

    List<Site> findSiteByCritere(Research research);
}
