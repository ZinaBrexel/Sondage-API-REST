package fr.simplon.sondage.dao.impl;

import fr.simplon.sondage.entity.Sondage;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface qui étend l'interface {@link JpaRepository} pour la gestion de l'entité {@link Sondage}.
 * Cette interface permet de définir les méthodes de base pour la manipulation des données relatives à l'entité {@link Sondage}.
 */
public interface SondageRepository extends JpaRepository<Sondage, Long> {
}
