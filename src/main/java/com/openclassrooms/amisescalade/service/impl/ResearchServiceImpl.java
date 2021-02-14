package com.openclassrooms.amisescalade.service.impl;

import com.openclassrooms.amisescalade.model.Research;
import com.openclassrooms.amisescalade.model.Site;
import com.openclassrooms.amisescalade.repository.impl.SiteDaoImpl;
import com.openclassrooms.amisescalade.service.ResearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResearchServiceImpl implements ResearchService {

    @Autowired
    private SiteDaoImpl siteDAO;

    @Override
    public List<Site> researchSites(Research research) {
        return siteDAO.findSiteByCritere(research);
    }
}
