package com.openclassrooms.amisescalade.service.impl;

import com.openclassrooms.amisescalade.model.Site;
import com.openclassrooms.amisescalade.model.User;
import com.openclassrooms.amisescalade.repository.CommentaireRepository;
import com.openclassrooms.amisescalade.repository.SiteRepository;
import com.openclassrooms.amisescalade.repository.UserRepository;
import com.openclassrooms.amisescalade.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SiteServiceImpl implements SiteService {

    @Autowired
    SiteRepository siteRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CommentaireRepository commentaireRepository;

    @Override
    public List<Site> searchAllSites() {
        return siteRepository.findAll();
    }

    @Override
    public Site searchSiteid(Long id) {
        Optional<Site> optionalSite = siteRepository.findById(id);
        if (optionalSite.isPresent()) {
            return optionalSite.get();
        }
        return null;
    }

    @Override
    public Optional<String> addSite(Site site) {
        siteRepository.save(site);
        return Optional.empty();
    }

    @Override
    public void editSite(Site site) {
        siteRepository.save(site);
    }

    @Override
    public void deleteSite(Long id) {
        siteRepository.deleteById(id);
    }

}