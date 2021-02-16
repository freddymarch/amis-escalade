package com.openclassrooms.amisescalade.repository.impl;

import com.openclassrooms.amisescalade.model.Research;
import com.openclassrooms.amisescalade.model.Site;
import com.openclassrooms.amisescalade.repository.SiteDAO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.isEmpty;

@Repository
public class SiteDaoImpl implements SiteDAO {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * findSiteByCritere permets de faire une requete JPQL avec les champs remplies uniquement
     *
     * @param recherche contient les elements de recherches saisi par l'utilisateur
     * @return le resutal de la requete
     */
    public List<Site> findSiteByCritere(Research recherche) {

        // Etape 1 : Construction dynamique de la requête
        String jpql = "SELECT DISTINCT si";
        jpql += " FROM Site AS si";
        jpql += " LEFT JOIN si.secteurs se";
        jpql += " WHERE 1=1";

        if (!isEmpty(recherche.getPays())) {
            jpql += " AND si.pays = :pays";
        }
        if (recherche.getNbSecteurs() != null) {
            jpql += " AND size(si.secteurs) = :nbSecteurs";
        }
        if (!isEmpty(recherche.getCotation())) {
            jpql += " AND se.cotation = :cotation";
        }

        // Etape 2 : Définition des paramètres de la requête
        Query query = entityManager.createQuery(jpql, Site.class);

        if (!isEmpty(recherche.getPays())) {
            query.setParameter("pays", recherche.getPays());
        }
        if (recherche.getNbSecteurs() != null) {
            query.setParameter("nbSecteurs", recherche.getNbSecteurs());
        }
        if (!isEmpty(recherche.getCotation())) {
            query.setParameter("cotation", recherche.getCotation());
        }
        return query.getResultList();
    }

}
