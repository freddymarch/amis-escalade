package com.openclassrooms.amisescalade.service;

import com.openclassrooms.amisescalade.model.Site;

import java.util.List;
import java.util.Optional;

public interface SiteService {

    List<Site> searchAllSites();

    Site searchSiteid(Long id);

    Optional<String> addSite(Site site);

    void editSite(Site site);

    void deleteSite(Long siteId);
}
