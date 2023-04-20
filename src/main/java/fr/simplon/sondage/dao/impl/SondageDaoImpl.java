package fr.simplon.sondage.dao.impl;

import fr.simplon.sondage.dao.SondageDao;
import fr.simplon.sondage.entity.Sondage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Implémentation de l'interface {@link SondageDao} qui utilise
 * {@link SondageRepository} pour effectuer des opérations de base de données.
 */
@Repository
public class SondageDaoImpl implements SondageDao {

    private final SondageRepository sondageRepository;

    /**
     Constructeur qui injecte une instance de {@link SondageRepository}.
     @param sondageRepository une instance de {@link SondageRepository} utilisée pour effectuer des opérations de base de données
     */
    @Autowired
    public SondageDaoImpl(SondageRepository sondageRepository) {
        this.sondageRepository = sondageRepository;
    }

    /**
    * Récupère tous les objets {@link Sondage} de la base de données et les trie par ordre croissant de date de création.
    * @return une {@link Collection} de tous les objets {@link Sondage} de la base de données, triée par ordre croissant de date de création
    */
    @Override
    public Collection<Sondage> findAll() {
        return sondageRepository.findAll(Sort.by(Sort.Order.asc("date_creation")));
    }

    /**
    * Récupère un objet {@link Sondage} avec l'identifiant donné de la base de données.
    * @param id l'identifiant de l'objet {@link Sondage} à récupérer
    * @return l'objet {@link Sondage} avec l'identifiant donné
    * @throws RuntimeException si aucun objet {@link Sondage} avec l'identifiant donné n'est trouvé
    */
    @Override
    public Sondage findById(Long id) {
        return sondageRepository.findById(id).orElseThrow(() -> new RuntimeException("Identifiant invalide: " + id));
    }

    /**
    * Enregistre un objet {@link Sondage} dans la base de données.
    * @param sondage l'objet {@link Sondage} à enregistrer dans la base de données
    */
    @Override
    public void save(Sondage sondage) {
        sondageRepository.save(sondage);
    }

    /**
    * Met à jour un objet {@link Sondage} dans la base de données.
    * @param sondage l'objet {@link Sondage} à mettre à jour dans la base de données
    * @throws RuntimeException si aucun objet {@link Sondage} avec l'identifiant donné n'est trouvé
    */
    @Override
    public void update(Sondage sondage) {
        Sondage sondageToUpdate = sondageRepository.findById(sondage.getId())
                .orElseThrow(() -> new RuntimeException("Identifiant invalide: " + sondage.getId()));

        sondageToUpdate.setDescription(sondage.getDescription());
        sondageToUpdate.setQuestion(sondage.getQuestion());
        sondageToUpdate.setDate_cloture(sondage.getDate_cloture());
        sondageToUpdate.setCreateur(sondage.getCreateur());

        sondageRepository.save(sondageToUpdate);
    }

    /**
     * Supprime un objet {@link Sondage} de la base de données avec l'identifiant donné.
     * @param id l'identifiant de l'objet {@link Sondage} à supprimer de la base de données
     */
    @Override
    public void delete(Long id) {
        sondageRepository.deleteById(id);
    }
}


