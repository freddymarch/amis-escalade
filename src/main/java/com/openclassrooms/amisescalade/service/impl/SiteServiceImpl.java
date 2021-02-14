package com.openclassrooms.amisescalade.service.impl;

import com.openclassrooms.amisescalade.model.Site;
import com.openclassrooms.amisescalade.repository.CommentaireRepository;
import com.openclassrooms.amisescalade.repository.SecteurRepository;
import com.openclassrooms.amisescalade.repository.SiteRepository;
import com.openclassrooms.amisescalade.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SiteServiceImpl implements SiteService {

    @Autowired
    private SiteRepository siteRepository;

    @Autowired
    private CommentaireRepository commentaireRepository;

    @Autowired
    private SecteurRepository secteurRepository;

    @Override
    public List<Site> findAll() {
        return siteRepository.findAll();
    }

    @Override
    public Site findById(Long id) {
        Assert.notNull(id, "Id site must not be null");
        Optional<Site> optionalSite = siteRepository.findById(id);
        return optionalSite.isPresent() ? optionalSite.get() : null;
    }

    @Override
    public void add(Site site) {
        Assert.notNull(site, "Site must not be null");
        siteRepository.save(site);
    }

    @Override
    public void edit(Site site) {
        Assert.notNull(site, "Site must not be null");
        siteRepository.save(site);
    }

    @Override
    public void delete(Long id) {
        Assert.notNull(id, "Id site must not be null");
        commentaireRepository.deleteBySiteId(id);
        secteurRepository.deleteBySiteId(id);
        siteRepository.deleteById(id);
    }

}
