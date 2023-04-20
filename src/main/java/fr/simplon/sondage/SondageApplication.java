package fr.simplon.sondage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Point d'entrée de l'application de sondage.
 * La classe SondageApplication utilise la configuration de Spring Boot pour initialiser l'application.
 */
@SpringBootApplication
public class SondageApplication {

    /**
     * Méthode principale qui démarre l'application de sondage en utilisant la configuration Spring Boot.
     * @param args les arguments en ligne de commande passés à l'application, si il y en a.
     */
    public static void main(String[] args) {
        SpringApplication.run(SondageApplication.class, args);
    }

}
