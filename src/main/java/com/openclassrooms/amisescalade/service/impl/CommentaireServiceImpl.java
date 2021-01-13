package com.openclassrooms.amisescalade.service.impl;


import com.openclassrooms.amisescalade.model.Commentaire;
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
    public Commentaire searchCommentaireById(Long id) {
        Optional<Commentaire> optionalCommentaire = commentaireRepository.findById(id);
        return optionalCommentaire.isPresent() ? optionalCommentaire.get() : null;
    }

    @Override
    public void addCommentaire(Commentaire commentaire) {
        // TODO : Vérifier que le commentaire est valide avant de l'insérer en bdd
        commentaireRepository.save(commentaire);
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
