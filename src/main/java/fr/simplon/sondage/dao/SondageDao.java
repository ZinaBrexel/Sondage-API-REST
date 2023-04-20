package fr.simplon.sondage.dao;

import fr.simplon.sondage.entity.Sondage;

import java.util.Collection;

/**
 Interface représentant l'accès aux données des sondages.
 */

public interface SondageDao {

    /**
     Sauvegarde un sondage dans la base de données.
     @param sondage le sondage à sauvegarder
     */
    void save(Sondage sondage);

    /**
     Met à jour les informations d'un sondage dans la base de données.
     @param sondage le sondage à mettre à jour
     */
    void update(Sondage sondage);

    /**
     Supprime un sondage de la base de données.
     @param id l'identifiant du sondage à supprimer
     */
    void delete (Long id);

    /**
     Récupère tous les sondages de la base de données.
     @return une collection de sondages
     */
    Collection<Sondage> findAll();

    /**
     Récupère un sondage de la base de données en fonction de son identifiant.
     @param id l'identifiant du sondage à récupérer
     @return le sondage correspondant à l'identifiant
     */
    Sondage findById(Long id);


}
