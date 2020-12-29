package com.openclassrooms.amisescalade.service;

import com.openclassrooms.amisescalade.model.Site;
import com.openclassrooms.amisescalade.model.User;

import java.util.List;
import java.util.Optional;

public interface SiteService {

    List<Site> rechercherTousLesSites();

    Site rechercherSiteParId(Long id);

    Optional<String> addSite(Site site);

    void editSite(Site site);

    void deleteSite(Long siteId);
}
