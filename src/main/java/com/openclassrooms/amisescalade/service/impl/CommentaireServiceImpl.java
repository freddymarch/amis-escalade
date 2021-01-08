package com.openclassrooms.amisescalade.service.impl;


import com.openclassrooms.amisescalade.model.Commentaire;
import com.openclassrooms.amisescalade.model.Secteur;
import com.openclassrooms.amisescalade.model.Site;
import com.openclassrooms.amisescalade.model.User;
import com.openclassrooms.amisescalade.repository.CommentaireRepository;
import com.openclassrooms.amisescalade.service.CommentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public Commentaire userId(User user) {
        Commentaire commentaire = new Commentaire();
        commentaire.setUser(user);
        return commentaire;
    }

    @Override
    public List<Commentaire> searchAllCommentaire() {
        return commentaireRepository.findAll();
    }

    @Override
    public Commentaire searchCommentaireid(Long id) {
        Optional<Commentaire> optionalCommentaire = commentaireRepository.findById(id);
        if (optionalCommentaire.isPresent()) {
            return optionalCommentaire.get();
        }
        return null;
    }

    @Override
    public Optional<String> addCommentaire(Commentaire commentaire) {
        commentaireRepository.save(commentaire);
        return Optional.empty();
    }

    @Override
    public void editCommentaire(Commentaire commentaire) {
        commentaireRepository.save(commentaire);
    }

    @Override
    public void deleteCommentaire(Long Id) {
        commentaireRepository.deleteById(Id);
    }
}
