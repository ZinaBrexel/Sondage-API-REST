# Sondage API REST 📊
[![forthebadge](https://forthebadge.com/images/badges/built-with-love.svg)](https://forthebadge.com)

[![forthebadge](https://forthebadge.com/images/badges/powered-by-electricity.svg)](https://forthebadge.com)

----------

## Description du projet 🌱

Ce projet a été créé dans le cadre de ma formation de développeur web. Il s'inscrit dans le contexte d'une entreprise fictive d'assurance appelée OXO, pour laquelle j'ai travaillé en tant que développeur. Le directeur du Système d'Information a souhaité lancer une nouvelle plateforme permettant aux salariés de voter sur des sujets liés à l'entreprise.

La plateforme comprendra à terme une page d'accueil avec plusieurs propositions ouvertes et la possibilité de voter Pour ou Contre ces propositions. Chaque salarié aura le droit de créer de nouvelles propositions, de les afficher en détail, les modifier et les supprimer (CRUD).

Le travail demandé consiste à concevoir et développer les points d'accès pour les fonctionnalités CRUD des sondages (uniquement les sondages, pas le système de votes). Pour cela, il faudra créer le backend en intégralité avec la base de données MySQL, le modèle de données JPA et le serveur Spring Boot.


----------



## Livrables 🧳

Les fonctionnalités CRUD des sondages sont accessibles via les points d'accès suivants :

- GET/sondages : permet de récupérer la liste de tous les sondages dont la date de clôture est dans le futur.

- GET /sondages/{id} : permet de lire le sondage correspondant à l'identifiant {id} et de le retourner au format JSON.
- POST /sondages : permet de créer un nouveau sondage et renvoie une réponse HTTP 200.
- PUT /sondages/{id} : permet de modifier le sondage correspondant à l'identifiant {id} et renvoie une réponse HTTP 200.
- DELETE /sondages/{id} : permet de supprimer le sondage correspondant à l'identifiant {id} et renvoie une réponse HTTP 200.

Le livrable doit inclure une méthode de test JUnit pour chaque point d'accès à l'API en utilisant RestTemplate.

En outre, il est également attendu la fourniture d'une page "swagger-ui.html" permettant de lister et tester les points d'accès de l'API. Cette page doit être générée à l'aide de springdoc et swagger.

![](https://zupimages.net/up/23/16/0i58.png)

----------

## Langages et Framwork utilisés 💬

![Image](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)


![MySQL Badge](https://img.shields.io/badge/MySQL-4479A1?logo=mysql&logoColor=fff&style=for-the-badge)

![JSON Badge](https://img.shields.io/badge/JSON-000?logo=json&logoColor=fff&style=for-the-badge)

![Hibernate Badge](https://img.shields.io/badge/Hibernate-59666C?logo=hibernate&logoColor=fff&style=for-the-badge)

![Spring Boot Badge](https://img.shields.io/badge/Spring%20Boot-6DB33F?logo=springboot&logoColor=fff&style=for-the-badge)

----------

## La base de données📋

Les données à enregistrer pour un Sondage :

- une description (chaîne vide/blanche interdite, min 3 caractères et max 120 caractères)
- une question (max 120 car.)
- une date de création (automatiquement remplie au jour actuel),
- une date de cloture (doit être après la date de création)
- le nom de la personne qui l'a proposé (chaine vide/blanche interdite, max 64 car.)
----------



## Prérequis 🔐

**1. Créer une base de données MySQL**


Dans ce projet, la base de données 'sondages' doit être créee avant de lancer l'application. Cependant, la table 'sondage' n'a pas besoin d'être créée préalablement car elle sera générée automatiquement à partir du code. 

Dans ce projet, la base de données 'sondages' doit être créee avant de lancer l'application. Cependant, la table 'sondage' n'a pas besoin d'être créée préalablement car elle sera générée automatiquement à partir du code.


**2. Cloner le repository**

Vous pouvez consulter la documentation correspondante en cliquant sur le lien suivant : https://docs.github.com/fr/repositories/creating-and-managing-repositories/cloning-a-repository.
Elle contient toutes les informations nécessaires pour cloner le dépôt.

**3. Modification de application.properties**

Pour pouvoir vous connecter à votre base de donnée vous devrez adapter votre configuration dans ce fichier situé dans resources/application.properties

Le port utilisé par l'API est le port 8080 par défaut , pour utiliser un autre port veuillez ajouter 

```
server.port=
```
Suivi du numéro de port que vous souhaitez utiliser. 

En ce qui concerne les test, des ports aléatoires sont défini via le code .

```
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

@LocalServerPort
    private int port;

Sondage updatedSondage = restTemplate.getForObject("http://localhost:" + port + "/sondages/{id}", Sondage.class, sondage.getId());
```

## Utilisation 💻

Instructions d'utilisation

1. Pour lancer l'application , exécuter le fichier 'SondageApplication' se situant dans 'main/java/fr.simplon.sondage.SondageApplication'.

2. Pour lancer les test unitaires, une fois le serveur lancé, exécuter le fichier 'SondageControllerTest' se situant dans 'test/java/fr.simplon.sondage.SondageControllerTest'.


3. Enjoy ! ✨



