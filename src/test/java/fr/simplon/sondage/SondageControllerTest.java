package fr.simplon.sondage;

import fr.simplon.sondage.entity.Sondage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Collection;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

/**

 Cette classe est une classe de test pour la classe SondageController.

 Elle utilise TestRestTemplate pour tester les méthodes CRUD exposées par le contrôleur.

 Les annotations @SpringBootTest et @LocalServerPort sont utilisées pour démarrer l'application dans un environnement de test.
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SondageControllerTest {


    /**
     TestRestTemplate est un client REST utilisé pour tester l'API REST exposée par le contrôleur.
     */

    @Autowired
    private TestRestTemplate restTemplate;

    /**
     Le port local utilisé pour tester l'application.
     */
    @LocalServerPort
    private int port;


    /**
     Test de la méthode addSondage() qui ajoute un nouveau sondage en envoyant une requête POST à l'API REST.
     Le test vérifie que le statut de la réponse est OK (200) et que le sondage ajouté correspond aux données envoyées.
     */
    @Test
    public void testAddSondage() {
        String url = "http://localhost:"+ port +"/sondages/formulaire";
        Sondage sondage = new Sondage("Vacances", "Avez-vous pensé à poser vos prochaines vacances ?", LocalDate.now(), LocalDate.now().plusDays(7), "Julia");
        ResponseEntity<Sondage> response = restTemplate.postForEntity(url, sondage, Sondage.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        Sondage result = response.getBody();
        assertNotNull(result.getId());
        assertEquals(sondage.getDescription(), result.getDescription());
        assertEquals(sondage.getQuestion(), result.getQuestion());
        assertEquals(sondage.getDate_cloture(), result.getDate_cloture());
        assertEquals(sondage.getCreateur(), result.getCreateur());
    }

    /**
     Test de la méthode getSondage() qui récupère un sondage en envoyant une requête GET à l'API REST.
     Le test vérifie que le statut de la réponse est OK (200) et que le sondage récupéré correspond aux données du sondage avec l'identifiant 1.
     */
    @Test
    void testGetSondage() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Sondage> response = restTemplate.getForEntity("http://localhost:" + port + "/sondages/1", Sondage.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        Sondage result = response.getBody();
        assertEquals("Nouvelle couverture santé", result.getDescription());
        assertEquals("Souhaitez-vous souscrire à la nouvelle couverture santé proposée par OXO ?", result.getQuestion());
        assertEquals(LocalDate.of(2023, 4,20), result.getDate_creation());
        assertEquals(LocalDate.of(2023, 5,01),result.getDate_cloture());
        assertEquals("Philippe", result.getCreateur());
    }

    /**
     Test de la méthode getAllSondages() qui récupère tous les sondages en envoyant une requête GET à l'API REST.
     Le test vérifie que le statut de la réponse est OK (200) et que la liste des sondages n'est pas vide.
     */
    @Test
    public void testGetAllSondages() {
        String url = "http://localhost:" + port + "/sondages";
        ResponseEntity<Collection<Sondage>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Collection<Sondage>>() {});
        assertEquals(HttpStatus.OK, response.getStatusCode());
        Collection<Sondage> sondages = response.getBody();
        assertNotNull(sondages);
        assertFalse(sondages.isEmpty());
    }


    /**
     Test de la méthode updateSondage() qui met à jour un sondage en envoyant une requête PUT à l'API REST.
     Le test vérifie que le sondage est mis à jour avec les nouvelles données envoyées.
     */
    @Test
    public void testUpdateSondage() {
        RestTemplate restTemplate = new RestTemplate();
        Sondage sondage = restTemplate.getForObject("http://localhost:" + port + "/sondages/25", Sondage.class);
        sondage.setDescription("Utilisation de vos points numériques");
        sondage.setQuestion("Utilisez-vous des points numériques pour bénéficier des avantages du CE ? ");
        restTemplate.put("http://localhost:" + port + "/sondages/formulaire/{id}", sondage, sondage.getId());
        Sondage updatedSondage = restTemplate.getForObject("http://localhost:" + port + "/sondages/{id}", Sondage.class, sondage.getId());
        assertNotNull(updatedSondage);
        assertEquals("Utilisation de vos points numériques", updatedSondage.getDescription());
        assertEquals("Utilisez-vous des points numériques pour bénéficier des avantages du CE ? ", updatedSondage.getQuestion());
    }

    /**
     Test de la méthode deleteSondage() qui supprime un sondage en envoyant une requête DELETE à l'API REST.
     Le test vérifie que le statut de la réponse est OK (200) et que le sondage est supprimé.
     */
    @Test
    public void testDeleteSondage() {
        RestTemplate restTemplate = new RestTemplate();
        Sondage sondage = restTemplate.getForObject("http://localhost:" + port + "/sondages/21", Sondage.class);
        ResponseEntity<Void> response = restTemplate.exchange("http://localhost:" + port + "/sondages/{id}", HttpMethod.DELETE, null, Void.class, sondage.getId());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
