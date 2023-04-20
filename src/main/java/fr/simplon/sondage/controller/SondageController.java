package fr.simplon.sondage.controller;

import fr.simplon.sondage.dao.impl.SondageRepository;
import fr.simplon.sondage.entity.Sondage;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.NoSuchElementException;

/**
 Cette classe implémente les méthodes pour effectuer les opérations CRUD sur les sondages. Elle utilise une instance de

 SondageRepository pour accéder à la base de données. Les opérations disponibles sont : la récupération de tous les sondages,

 la récupération d'un sondage spécifique par son identifiant, l'ajout d'un nouveau sondage, la mise à jour d'un sondage existant

 et la suppression d'un sondage existant. Cette classe est annotée avec @RestController pour indiquer que chaque méthode renvoie

 une réponse HTTP qui sera sérialisée directement dans le corps de la réponse.
 */
@RestController
public class SondageController {

    @Autowired
    private SondageRepository sondageRepository;

    /**
     Cette méthode renvoie tous les sondages enregistrés dans la base de données.
     @return une collection de sondages.
     */
    @GetMapping("/sondages")
    public Collection<Sondage> findAll (){
        return sondageRepository.findAll();
    }

    /**
     Cette méthode renvoie un sondage spécifique en fonction de son identifiant.
     @param id l'identifiant du sondage à récupérer.
     @return le sondage correspondant à l'identifiant.
     @throws NoSuchElementException si aucun sondage correspondant à l'identifiant n'est trouvé.
     */
    @GetMapping("/sondages/{id}")
    public Sondage getSondage(@PathVariable Long id) {
        Sondage sondage = sondageRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Sondage non trouvé avec l'identifiant : " + id));
        return sondage;
    }


    /**
     Cette méthode ajoute un nouveau sondage à la base de données.
     @param newSondage le nouveau sondage à ajouter.
     @return le sondage ajouté.
     */
    @PostMapping("/sondages/formulaire")
    public Sondage addSondage(@RequestBody @Valid Sondage newSondage){
        return sondageRepository.save(newSondage);
    }

    /**
     Cette méthode met à jour un sondage existant dans la base de données.
     @param newSondage les données mises à jour pour le sondage existant.
     @param id l'identifiant du sondage à mettre à jour.
     @return le sondage mis à jour.
     */
    @PutMapping("/sondages/formulaire/{id}")
    public Sondage updateSondage(@RequestBody @Valid Sondage newSondage, @PathVariable long id) {
        return sondageRepository.findById(id)
                .map(sondage -> {
                    sondage.setDescription(newSondage.getDescription());
                    sondage.setQuestion(newSondage.getQuestion());
                    sondage.setDate_cloture(newSondage.getDate_cloture());
                    sondage.setCreateur(newSondage.getCreateur());
                    return sondageRepository.save(sondage);
                })
                .orElseGet(() -> {
                    newSondage.setId(id);
                    return sondageRepository.save(newSondage);
                });
    }

    /**
     Cette méthode supprime un sondage existant de la base de données.
     @param id l'identifiant du sondage à supprimer.
     @throws NoSuchElementException si aucun sondage correspondant à l'identifiant n'est trouvé.
     */
    @DeleteMapping("/sondages/{id}")
    public void deleteSondage(@PathVariable Long id) {
        Sondage sondage = sondageRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Sondage non trouvé avec l'identifiant : " + id));
        sondageRepository.delete(sondage);
    }

}
