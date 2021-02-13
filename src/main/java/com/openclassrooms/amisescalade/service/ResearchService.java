package com.openclassrooms.amisescalade.service;

import com.openclassrooms.amisescalade.model.Research;
import com.openclassrooms.amisescalade.model.Site;

import java.util.List;

public interface ResearchService {

    List<Site> researchSites(Research research);

}
