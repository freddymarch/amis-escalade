package com.openclassrooms.amisescalade.service.impl;

import com.openclassrooms.amisescalade.model.Research;
import com.openclassrooms.amisescalade.model.Site;
import com.openclassrooms.amisescalade.repository.SiteRepository;
import com.openclassrooms.amisescalade.repository.impl.SiteDAOImpl;
import com.openclassrooms.amisescalade.service.ResearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResearchServiceImpl implements ResearchService {

    @Autowired
    SiteRepository siteRepository;

    @Autowired
    SiteDAOImpl siteDAO;

    @Override
    public List<Site> researchSites(Research research) {
        List<Site> maListe = siteDAO.findSiteByCritere(research);
        return maListe;
    }
}
