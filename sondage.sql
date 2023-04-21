-- phpMyAdmin SQL Dump
-- version 5.1.2
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:8082
-- Généré le : jeu. 20 avr. 2023 à 20:53
-- Version du serveur : 5.7.24
-- Version de PHP : 8.0.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `sondages`
--

-- --------------------------------------------------------

--
-- Structure de la table `sondage`
--

CREATE TABLE `sondage` (
  `id` bigint(20) NOT NULL,
  `createur` varchar(64) DEFAULT NULL,
  `date_cloture` date NOT NULL,
  `date_creation` date NOT NULL,
  `description` varchar(120) DEFAULT NULL,
  `question` varchar(120) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `sondage`
--

INSERT INTO `sondage` (`id`, `createur`, `date_cloture`, `date_creation`, `description`, `question`) VALUES
(1, 'Philippe', '2023-05-01', '2023-04-20', 'Nouvelle couverture santé', 'Souhaitez-vous souscrire à la nouvelle couverture santé proposée par OXO ?'),
(2, 'Sophie', '2023-05-02', '2023-04-20', 'Options de télétravail', 'Seriez-vous intéressé par des options de télétravail supplémentaires ?'),
(3, 'Alexandre', '2023-05-03', '2023-04-20', 'Changement d\'horaires', 'Accepteriez-vous un changement d\'horaires pour mieux s\'adapter aux clients ?'),
(4, 'Béatrice', '2023-05-04', '2023-04-20', 'Prime de fin d\'année', 'Seriez-vous favorable à une prime de fin d\'année pour les salariés les plus performants ?'),
(5, 'Jacques', '2023-05-05', '2023-04-20', 'Aménagement de locaux', 'Souhaitez-vous des aménagements supplémentaires dans les locaux d\'OXO ?'),
(6, 'Céline', '2023-05-06', '2023-04-20', 'Nouvelle politique de recrutement', 'Êtes-vous favorable à une nouvelle politique de recrutement visant à diversifier les profils ?'),
(7, 'Antoine', '2023-05-07', '2023-04-20', 'Formation professionnelle', 'Seriez-vous intéressé par des formations professionnelles pour améliorer vos compétences ?'),
(8, 'Emilie', '2023-05-08', '2023-04-20', 'Réduction du temps de travail', 'Accepteriez-vous une réduction du temps de travail pour favoriser l\'équilibre vie professionnelle/vie personnelle ?'),
(9, 'François', '2023-05-09', '2023-04-20', 'Programme de bien-être', 'Seriez-vous intéressé par un programme de bien-être proposé par OXO ?'),
(10, 'Hélène', '2023-05-10', '2023-04-20', 'Plan de formation à la cybersécurité', 'Souhaitez-vous suivre un plan de formation à la cybersécurité pour renforcer la sécurité informatique chez OXO ?'),
(11, 'Gérard', '2023-05-11', '2023-04-20', 'Nouvelles opportunités de mobilité internationale', 'Seriez-vous intéressé par des nouvelles opportunités de mobilité internationale chez OXO ?'),
(12, 'Isabelle', '2023-05-12', '2023-04-20', 'Programme de mentorat', 'Seriez-vous intéressé par un programme de mentorat pour développer vos compétences professionnelles ?'),
(13, 'Julien', '2023-05-13', '2023-04-20', 'Nouvelle offre de services', 'Seriez-vous favorable à une nouvelle offre de services pour les clients d\'OXO ?'),
(14, 'Laurent', '2023-05-14', '2023-04-20', 'Programme de reconversion professionnelle', 'Seriez-vous intéressé par un programme de reconversion professionnelle chez OXO ?'),
(15, 'Marie', '2023-05-15', '2023-04-20', 'Amélioration de la communication interne', 'Souhaitez-vous des améliorations dans la communication interne au sein d\'OXO ?'),
(16, 'Nicolas', '2023-05-16', '2023-04-20', 'Projet de développement durable', 'Seriez-vous favorable à un projet de développement durable chez OXO ?'),
(17, 'Olivia', '2023-05-17', '2023-04-20', 'Programme de reconnaissance des salariés', 'Seriez-vous favorable à un programme de reconnaissance des salariés chez OXO ?'),
(18, 'Pierre', '2023-05-18', '2023-04-20', 'Changement de fournisseur de café', 'Seriez-vous favorable à un changement de fournisseur de café pour la cafétéria d\'OXO ?'),
(19, 'Quentin', '2023-05-19', '2023-04-20', 'Projet de R&D', 'Seriez-vous favorable à un projet de R&D chez OXO ?'),
(20, 'Rachel', '2023-05-20', '2023-04-20', 'Programme de mentorat inversé', 'Seriez-vous intéressé par un programme de mentorat inversé pour partager vos connaissances avec des collaborateurs plus '),
(21, 'Sylvie', '2023-05-21', '2023-04-20', 'Amélioration de la sécurité des locaux', 'Seriez-vous favorable à des améliorations de la sécurité des locaux d\'OXO ?'),
(22, 'Thierry', '2023-05-22', '2023-04-20', 'Nouveau système de gestion des notes de frais', 'Seriez-vous favorable à l\'utilisation d\'un nouveau système de gestion des notes de frais chez OXO ?'),
(23, 'Ursula', '2023-05-23', '2023-04-20', 'Nouveau programme de volontariat', 'Seriez-vous intéressé par un nouveau programme de volontariat chez OXO ?'),
(24, 'Victor', '2023-05-24', '2023-04-20', 'Projet d\'innovation collaborative', 'Seriez-vous favorable à un projet d\'innovation collaborative chez OXO ?');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `sondage`
--
ALTER TABLE `sondage`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `sondage`
--
ALTER TABLE `sondage`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
