package com.openclassrooms.amisescalade.service;

import com.openclassrooms.amisescalade.model.Site;

import java.util.List;
import java.util.Optional;

public interface SiteService {

    List<Site> findAll();

    Site findById(Long id);

    void add(Site site);

    void edit(Site site);

    void delete(Long siteId);
}
