package com.openclassrooms.amisescalade.service.impl;


import com.openclassrooms.amisescalade.model.Commentaire;
import com.openclassrooms.amisescalade.model.Site;
import com.openclassrooms.amisescalade.model.User;
import com.openclassrooms.amisescalade.repository.CommentaireRepository;
import com.openclassrooms.amisescalade.service.CommentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CommentaireServiceImpl implements CommentaireService {

    @Autowired
    CommentaireRepository commentaireRepository;

    @Override
    public Commentaire siteId(Site site) {
        Commentaire commentaire = new Commentaire();
        commentaire.setSite(site);
        return commentaire;
    }

    @Override
    public List<Commentaire> findAll() {
        return commentaireRepository.findAll();
    }

    @Override
    public Commentaire findById(Long id) {
        Assert.notNull(id, "Id commentaire must not be null");
        Optional<Commentaire> optionalCommentaire = commentaireRepository.findById(id);
        return optionalCommentaire.isPresent() ? optionalCommentaire.get() : null;
    }

    @Override
    public void add(Commentaire commentaire) {
        Assert.notNull(commentaire, "commentaire must not be null");
        commentaireRepository.save(commentaire);
    }

    @Override
    public void edit(Commentaire commentaire) {
        Assert.notNull(commentaire, "commentaire must not be null");
        commentaireRepository.save(commentaire);
    }

    @Override
    public void delete(Long id) {
        Assert.notNull(id, "Id commentaire must not be null");
        commentaireRepository.deleteById(id);
    }
}
