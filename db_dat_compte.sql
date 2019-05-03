-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  ven. 03 mai 2019 à 12:53
-- Version du serveur :  10.1.38-MariaDB
-- Version de PHP :  7.1.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `db_dat_compte`
--

-- --------------------------------------------------------

--
-- Structure de la table `account`
--

CREATE TABLE `account` (
  `id_account` bigint(20) NOT NULL,
  `balance` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `account`
--

INSERT INTO `account` (`id_account`, `balance`) VALUES
(1, 100);

-- --------------------------------------------------------

--
-- Structure de la table `statement`
--

CREATE TABLE `statement` (
  `id_statement` bigint(20) NOT NULL,
  `amount` double NOT NULL,
  `date` datetime NOT NULL,
  `type` int(11) DEFAULT NULL,
  `account_id_account` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id_account`);

--
-- Index pour la table `statement`
--
ALTER TABLE `statement`
  ADD PRIMARY KEY (`id_statement`),
  ADD KEY `FKojuyqg2boj6ocljvr4ytje292` (`account_id_account`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `account`
--
ALTER TABLE `account`
  MODIFY `id_account` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `statement`
--
ALTER TABLE `statement`
  MODIFY `id_statement` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `statement`
--
ALTER TABLE `statement`
  ADD CONSTRAINT `FKojuyqg2boj6ocljvr4ytje292` FOREIGN KEY (`account_id_account`) REFERENCES `account` (`id_account`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
