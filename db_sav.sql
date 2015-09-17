-- phpMyAdmin SQL Dump
-- version 3.3.9.2
-- http://www.phpmyadmin.net
--
-- Serveur: 127.0.0.1
-- Généré le : Jeu 17 Septembre 2015 à 04:27
-- Version du serveur: 5.5.10
-- Version de PHP: 5.3.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `db_sav`
--

-- --------------------------------------------------------

--
-- Structure de la table `attribution_devis_reparation`
--

CREATE TABLE IF NOT EXISTS `attribution_devis_reparation` (
  `id_fiche` int(8) NOT NULL DEFAULT '0',
  `id_devis_reparation` int(8) NOT NULL DEFAULT '0',
  `date_attrib_devis_reparation` date DEFAULT NULL,
  PRIMARY KEY (`id_fiche`,`id_devis_reparation`),
  KEY `fk_idDevis_attrib_devis_DevisRepar` (`id_devis_reparation`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `attribution_devis_reparation`
--

INSERT INTO `attribution_devis_reparation` (`id_fiche`, `id_devis_reparation`, `date_attrib_devis_reparation`) VALUES
(2, 1, NULL),
(3, 3, NULL),
(4, 2, NULL),
(5, 6, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `attribution_etat_fiche`
--

CREATE TABLE IF NOT EXISTS `attribution_etat_fiche` (
  `id_fiche` int(8) NOT NULL DEFAULT '0',
  `id_etat_fiche` int(8) NOT NULL DEFAULT '0',
  `date_attribution_etat_fiche` date DEFAULT NULL,
  PRIMARY KEY (`id_fiche`,`id_etat_fiche`),
  KEY `id_etat_fiche` (`id_etat_fiche`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `attribution_etat_fiche`
--

INSERT INTO `attribution_etat_fiche` (`id_fiche`, `id_etat_fiche`, `date_attribution_etat_fiche`) VALUES
(1, 1, '2015-09-03'),
(2, 2, '2015-09-03'),
(3, 3, '2015-09-03'),
(4, 4, '2015-09-03'),
(5, 5, '2015-09-09');

-- --------------------------------------------------------

--
-- Structure de la table `attribution_fiche`
--

CREATE TABLE IF NOT EXISTS `attribution_fiche` (
  `id_employe` int(8) NOT NULL DEFAULT '0',
  `id_fiche` int(8) NOT NULL DEFAULT '0',
  `date_attribution_fiche` date DEFAULT NULL,
  PRIMARY KEY (`id_employe`,`id_fiche`),
  KEY `id_fiche` (`id_fiche`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `attribution_fiche`
--

INSERT INTO `attribution_fiche` (`id_employe`, `id_fiche`, `date_attribution_fiche`) VALUES
(1, 4, NULL),
(3, 4, NULL),
(4, 4, NULL),
(4, 5, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `attribution_piece`
--

CREATE TABLE IF NOT EXISTS `attribution_piece` (
  `id_devis_reparation` int(8) NOT NULL DEFAULT '0',
  `id_piece` int(8) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_devis_reparation`,`id_piece`),
  KEY `fk_idPiece_piece` (`id_piece`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `attribution_piece`
--


-- --------------------------------------------------------

--
-- Structure de la table `attribution_privilege`
--

CREATE TABLE IF NOT EXISTS `attribution_privilege` (
  `id_role` int(8) NOT NULL DEFAULT '0',
  `id_privilege` int(8) NOT NULL DEFAULT '0',
  `date_attribution_privilege` date DEFAULT NULL,
  PRIMARY KEY (`id_role`,`id_privilege`),
  KEY `fk_idpriv` (`id_privilege`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `attribution_privilege`
--

INSERT INTO `attribution_privilege` (`id_role`, `id_privilege`, `date_attribution_privilege`) VALUES
(1, 1, NULL),
(1, 2, NULL),
(1, 3, NULL),
(1, 4, NULL),
(1, 5, NULL),
(1, 6, NULL),
(1, 7, NULL),
(1, 8, NULL),
(2, 3, NULL),
(2, 4, NULL),
(2, 5, NULL),
(2, 6, NULL),
(2, 9, NULL),
(3, 4, NULL),
(4, 5, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `attribution_role`
--

CREATE TABLE IF NOT EXISTS `attribution_role` (
  `id_employe` int(8) NOT NULL DEFAULT '0',
  `id_role` int(8) NOT NULL DEFAULT '0',
  `date_attribution_role` date DEFAULT NULL,
  PRIMARY KEY (`id_employe`,`id_role`),
  KEY `f_k_id_Rol` (`id_role`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `attribution_role`
--

INSERT INTO `attribution_role` (`id_employe`, `id_role`, `date_attribution_role`) VALUES
(1, 1, NULL),
(4, 2, NULL),
(5, 2, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE IF NOT EXISTS `client` (
  `id_client` int(8) NOT NULL AUTO_INCREMENT,
  `nom_Client` varchar(30) DEFAULT NULL,
  `prenom_client` varchar(30) DEFAULT NULL,
  `adresse` text,
  `num_tel_port` int(8) DEFAULT NULL,
  `num_tel_fix` int(8) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `mot_passe` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_client`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Contenu de la table `client`
--

INSERT INTO `client` (`id_client`, `nom_Client`, `prenom_client`, `adresse`, `num_tel_port`, `num_tel_fix`, `email`, `mot_passe`) VALUES
(1, 'Moussi', 'Mohamed', 'Tunis', 21550705, 21550705, 'msi.moussi@gmail.com', 'cwco72'),
(2, 'Moussi', 'Mohamed', 'Tunis', 21550705, 21550705, 'msi.moussi@gmail.com', 'q7gor'),
(3, 'MSI', 'Moussi', 'Paris', 2147483647, 2147483647, 'msi.moussi@gmail.com', 'j6qcx'),
(4, 'Msi', 'mmm', 'mmm', 222, 2222, 'kjb', 'd6ldl'),
(5, 'Sadki', 'Ahmed', 'Tunis', 25252525, 71000165, 'sadki.ahmed@gmail.com', 'r5mpx');

-- --------------------------------------------------------

--
-- Structure de la table `devis_reparation`
--

CREATE TABLE IF NOT EXISTS `devis_reparation` (
  `id_devis_reparation` int(8) NOT NULL AUTO_INCREMENT,
  `rapport_diagnostique` text,
  `devis` text NOT NULL,
  `Commentaire_Devis` text NOT NULL,
  `date_creation_devis` date DEFAULT NULL,
  PRIMARY KEY (`id_devis_reparation`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Contenu de la table `devis_reparation`
--

INSERT INTO `devis_reparation` (`id_devis_reparation`, `rapport_diagnostique`, `devis`, `Commentaire_Devis`, `date_creation_devis`) VALUES
(1, 'panne de dÃ©marrage systÃ¨me', 'formatage et installation windows 10 avec  les pilotes', 'ajout des logiciels (winrar, antivirus, adobe reader)', NULL),
(2, 'test', 'tests', 'test', NULL),
(3, 'pile CMOS expirÃ©', 'changement de pile CMOS et configuration de temps', 'comment', NULL),
(6, 'Probleme de ventilateur de boite d alimentation', 'Changement de ventilateur\nNettoyage de carte mÃ¨re\nFormatage PC', 'Commentaire', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `document`
--

CREATE TABLE IF NOT EXISTS `document` (
  `id_document` int(8) NOT NULL AUTO_INCREMENT,
  `nom_document` varchar(100) DEFAULT NULL,
  `url_document` varchar(100) DEFAULT NULL,
  `id_employe` int(8) DEFAULT NULL,
  PRIMARY KEY (`id_document`),
  KEY `fk_idEmp_Doc_Emp` (`id_employe`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `document`
--


-- --------------------------------------------------------

--
-- Structure de la table `employe`
--

CREATE TABLE IF NOT EXISTS `employe` (
  `id_employe` int(8) NOT NULL AUTO_INCREMENT,
  `nom_Emp` varchar(30) DEFAULT NULL,
  `prenom_Emp` varchar(30) DEFAULT NULL,
  `adresse_Emp` text,
  `numTelMobil` int(8) DEFAULT NULL,
  `numTelFix` int(8) DEFAULT NULL,
  `emailEmp` varchar(30) DEFAULT NULL,
  `passwordEmp` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_employe`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Contenu de la table `employe`
--

INSERT INTO `employe` (`id_employe`, `nom_Emp`, `prenom_Emp`, `adresse_Emp`, `numTelMobil`, `numTelFix`, `emailEmp`, `passwordEmp`) VALUES
(1, 'Moussi', 'Mohamed', 'tunis', 21550705, 21550705, 'moussi.m@live.fr', 'med1200..'),
(2, 'moussi', 'mohamed', 'tunis', 21550705, 21550705, 'msi.moussi@gmail.com', 'med1200..'),
(3, 'Med', 'Med', 'Paris', 2147483647, 2147483647, 'moussi.m@live.fr', 'med1200..!!'),
(4, 'Technicien1', 'Ahmed', 'tunis', 21550705, 21550705, 'technicien.1@gmail.com', 'test'),
(5, 'test', 'test', 'test', 6265, 65151, 'test', 'test');

-- --------------------------------------------------------

--
-- Structure de la table `etat_fiche`
--

CREATE TABLE IF NOT EXISTS `etat_fiche` (
  `id_etat_fiche` int(8) NOT NULL AUTO_INCREMENT,
  `nom_etat` varchar(50) DEFAULT NULL,
  `commentaire_etat` text,
  PRIMARY KEY (`id_etat_fiche`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Contenu de la table `etat_fiche`
--

INSERT INTO `etat_fiche` (`id_etat_fiche`, `nom_etat`, `commentaire_etat`) VALUES
(1, 'en attente de traitement', 'comment'),
(2, 'en attente de traitement', 'comment'),
(3, 'Reception', 'comment'),
(4, 'Sous devis', 'egzgez'),
(5, 'En cours de diagnostique', 'Urgent');

-- --------------------------------------------------------

--
-- Structure de la table `fiche`
--

CREATE TABLE IF NOT EXISTS `fiche` (
  `id_fiche` int(8) NOT NULL AUTO_INCREMENT,
  `date_creation_fiche` datetime DEFAULT NULL,
  `date_fermeture_fiche` date DEFAULT NULL,
  `date_envoi_materiel` date DEFAULT NULL,
  `id_client` int(8) DEFAULT NULL,
  `description_panne` text,
  `observation` text NOT NULL,
  `id_materiel` int(8) NOT NULL,
  PRIMARY KEY (`id_fiche`),
  KEY `id_client` (`id_client`),
  KEY `id_materiel` (`id_materiel`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Contenu de la table `fiche`
--

INSERT INTO `fiche` (`id_fiche`, `date_creation_fiche`, `date_fermeture_fiche`, `date_envoi_materiel`, `id_client`, `description_panne`, `observation`, `id_materiel`) VALUES
(1, '2015-09-03 16:15:15', NULL, NULL, 1, 'Bootage', 'observation', 1),
(2, '2015-09-03 16:01:45', NULL, NULL, 2, 'Bootage', 'observation', 2),
(3, '2015-09-04 13:24:10', NULL, NULL, 3, 'Disque dur', 'observation', 3),
(4, '2015-09-08 01:23:30', NULL, NULL, 4, 'dvsg', 'gezg', 4),
(5, '2015-09-13 13:12:09', NULL, NULL, 5, 'Ventilateur', 'observation', 5);

-- --------------------------------------------------------

--
-- Structure de la table `fournisseur`
--

CREATE TABLE IF NOT EXISTS `fournisseur` (
  `id_fournisseur` int(8) NOT NULL AUTO_INCREMENT,
  `nom_fournisseur` varchar(30) DEFAULT NULL,
  `adresse_fournisseur` text,
  `num_tel_fournisseur` int(12) DEFAULT NULL,
  `fax_fournisseur` int(12) DEFAULT NULL,
  `email_fournisseur` varchar(40) DEFAULT NULL,
  `information_complementaire` text,
  PRIMARY KEY (`id_fournisseur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `fournisseur`
--


-- --------------------------------------------------------

--
-- Structure de la table `materiel`
--

CREATE TABLE IF NOT EXISTS `materiel` (
  `id_materiel` int(8) NOT NULL AUTO_INCREMENT,
  `modele` varchar(40) DEFAULT NULL,
  `marque` varchar(40) DEFAULT NULL,
  `numero_serie` varchar(70) DEFAULT NULL,
  `statut_materiel` varchar(20) DEFAULT NULL,
  `accessoire` text NOT NULL,
  `remarque` text NOT NULL,
  `raye` varchar(150) NOT NULL,
  `subit_choc` varchar(150) NOT NULL,
  `vis_ouvert` varchar(150) NOT NULL,
  `id_fournisseur` int(8) NOT NULL,
  PRIMARY KEY (`id_materiel`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Contenu de la table `materiel`
--

INSERT INTO `materiel` (`id_materiel`, `modele`, `marque`, `numero_serie`, `statut_materiel`, `accessoire`, `remarque`, `raye`, `subit_choc`, `vis_ouvert`, `id_fournisseur`) VALUES
(1, 'Dell', 'Dell', '6541681', '---', 'accessoire', 'remarque', 'oui', 'oui', 'oui', 0),
(2, 'Inspiron', 'Dell', '2155208', '---', 'Accessoire', 'Remarque', 'Oui', 'Oui', '3 vis oouverts', 0),
(3, 'Paillon', 'HP', '2656513651', '---', 'clavier', 'remarque', 'non', 'non', 'non', 0),
(4, 'lkn', 'kj', '651', '---', 'gzeg', 'zegze', 'fezf', 'gz', 'gzegz', 0),
(5, 'Inspiron N5110', 'Dell', '3246982547', '---', 'Disque dur externe', 'bruit', 'Oui', 'Non', 'Non', 0);

-- --------------------------------------------------------

--
-- Structure de la table `piece_rechange`
--

CREATE TABLE IF NOT EXISTS `piece_rechange` (
  `id_piece` int(8) NOT NULL AUTO_INCREMENT,
  `modele_piece` varchar(50) DEFAULT NULL,
  `marque_piece` varchar(50) DEFAULT NULL,
  `num_serie_piece` varchar(50) DEFAULT NULL,
  `inform_suppl` text,
  `prix` double DEFAULT NULL,
  PRIMARY KEY (`id_piece`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `piece_rechange`
--


-- --------------------------------------------------------

--
-- Structure de la table `privilege`
--

CREATE TABLE IF NOT EXISTS `privilege` (
  `id_privilege` int(8) NOT NULL AUTO_INCREMENT,
  `privilege` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_privilege`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Contenu de la table `privilege`
--

INSERT INTO `privilege` (`id_privilege`, `privilege`) VALUES
(1, 'gerer base de connaissance'),
(2, 'gerer fiche de technicien'),
(3, 'gerer fiche de reception de materiel'),
(4, 'Suivre reparation'),
(5, 'verifier materiel'),
(6, 'gerer fiche d envoi de materiel'),
(7, 'gerer les ordres de reparation de materiel'),
(8, 'consulter statistique'),
(9, 'consulter fiche d ordre de reparation');

-- --------------------------------------------------------

--
-- Structure de la table `role`
--

CREATE TABLE IF NOT EXISTS `role` (
  `id_role` int(8) NOT NULL AUTO_INCREMENT,
  `role` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id_role`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `role`
--

INSERT INTO `role` (`id_role`, `role`) VALUES
(1, 'Responsable technique'),
(2, 'Technicien'),
(3, 'Client'),
(4, 'Agent commercial');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `attribution_devis_reparation`
--
ALTER TABLE `attribution_devis_reparation`
  ADD CONSTRAINT `fk_idDevis_attrib_devis_DevisRepar` FOREIGN KEY (`id_devis_reparation`) REFERENCES `devis_reparation` (`id_devis_reparation`),
  ADD CONSTRAINT `fk_idFich_attrib_devis_Repar` FOREIGN KEY (`id_fiche`) REFERENCES `fiche` (`id_fiche`);

--
-- Contraintes pour la table `attribution_etat_fiche`
--
ALTER TABLE `attribution_etat_fiche`
  ADD CONSTRAINT `attribution_etat_fiche_ibfk_5` FOREIGN KEY (`id_fiche`) REFERENCES `fiche` (`id_fiche`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `attribution_etat_fiche_ibfk_6` FOREIGN KEY (`id_etat_fiche`) REFERENCES `etat_fiche` (`id_etat_fiche`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `attribution_fiche`
--
ALTER TABLE `attribution_fiche`
  ADD CONSTRAINT `attribution_fiche_ibfk_1` FOREIGN KEY (`id_employe`) REFERENCES `employe` (`id_employe`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `attribution_fiche_ibfk_2` FOREIGN KEY (`id_fiche`) REFERENCES `fiche` (`id_fiche`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `attribution_piece`
--
ALTER TABLE `attribution_piece`
  ADD CONSTRAINT `fk_idDevis_devis` FOREIGN KEY (`id_devis_reparation`) REFERENCES `devis_reparation` (`id_devis_reparation`),
  ADD CONSTRAINT `fk_idPiece_piece` FOREIGN KEY (`id_piece`) REFERENCES `piece_rechange` (`id_piece`);

--
-- Contraintes pour la table `attribution_privilege`
--
ALTER TABLE `attribution_privilege`
  ADD CONSTRAINT `fk_idpriv` FOREIGN KEY (`id_privilege`) REFERENCES `privilege` (`id_privilege`),
  ADD CONSTRAINT `fk_idrol` FOREIGN KEY (`id_role`) REFERENCES `role` (`id_role`);

--
-- Contraintes pour la table `attribution_role`
--
ALTER TABLE `attribution_role`
  ADD CONSTRAINT `f_k_id_Emp` FOREIGN KEY (`id_employe`) REFERENCES `employe` (`id_employe`),
  ADD CONSTRAINT `f_k_id_Rol` FOREIGN KEY (`id_role`) REFERENCES `role` (`id_role`);

--
-- Contraintes pour la table `document`
--
ALTER TABLE `document`
  ADD CONSTRAINT `fk_idEmp_Doc_Emp` FOREIGN KEY (`id_employe`) REFERENCES `employe` (`id_employe`);

--
-- Contraintes pour la table `fiche`
--
ALTER TABLE `fiche`
  ADD CONSTRAINT `fiche_ibfk_7` FOREIGN KEY (`id_client`) REFERENCES `client` (`id_client`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fiche_ibfk_8` FOREIGN KEY (`id_materiel`) REFERENCES `materiel` (`id_materiel`) ON DELETE CASCADE ON UPDATE CASCADE;
