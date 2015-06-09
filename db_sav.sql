-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Serveur: 127.0.0.1
-- Généré le : Mar 09 Juin 2015 à 19:22
-- Version du serveur: 5.1.54
-- Version de PHP: 5.3.5

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
(256, 39, NULL),
(331, 37, NULL),
(331, 45, NULL),
(334, 36, NULL),
(334, 38, NULL),
(335, 40, NULL),
(336, 42, NULL),
(337, 43, NULL),
(339, 41, NULL),
(341, 44, NULL),
(343, 46, NULL);

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
(256, 202, '0000-00-00'),
(331, 277, '0000-00-00'),
(334, 102, '0000-00-00'),
(335, 281, '0000-00-00'),
(336, 284, '0000-00-00'),
(337, 285, '0000-00-00'),
(338, 286, '0000-00-00'),
(339, 287, '0000-00-00'),
(340, 288, '0000-00-00'),
(341, 289, '0000-00-00'),
(342, 290, '0000-00-00'),
(343, 291, '0000-00-00');

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
(1, 334, NULL),
(1, 335, NULL),
(2, 256, NULL),
(2, 331, NULL),
(2, 336, NULL),
(2, 341, NULL),
(2, 343, NULL),
(3, 335, NULL),
(9, 335, NULL);

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
(1, 1, '2012-06-14'),
(2, 2, '2012-06-15');

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=282 ;

--
-- Contenu de la table `client`
--

INSERT INTO `client` (`id_client`, `nom_Client`, `prenom_client`, `adresse`, `num_tel_port`, `num_tel_fix`, `email`, `mot_passe`) VALUES
(191, 'Moussi', 'Mohamed', 'cite', 21550705, 78000000, 'moussi.m@live.fr', '123456password'),
(192, 'kkk', 'kkkk', 'kkk', 555, 555, '555', '22222'),
(193, 'kkk', 'kkkk', 'kkk', 555, 555, '555', '22222'),
(194, 'kkk', 'kkkk', 'kkk', 555, 555, '555', '22222'),
(195, 'kkk', 'kkkk', 'kkk', 555, 555, '555', '22222'),
(196, 'kkk', 'kkkk', 'kkk', 555, 555, '555', '22222'),
(197, 'kkk', 'kkkk', 'kkk', 555, 555, '555', '22222'),
(198, 'kkk', 'kkkk', 'kkk', 555, 555, '555', '22222'),
(199, 'kkk', 'kkkk', 'kkk', 555, 555, '555', '22222'),
(200, '', '', '', 0, 0, '', ''),
(201, 'Mohamed', 'Mohamed', 'Mohamed', 0, 0, '555', '22222'),
(202, '', '', '', 0, 0, '', ''),
(203, '', '', '', 0, 0, '', ''),
(204, '', '', '', 0, 0, '', ''),
(205, '', '', '', 0, 0, '', ''),
(206, '', '', '', 0, 0, '', ''),
(207, '', '', '', 0, 0, '', ''),
(208, '', '', '', 0, 0, '', ''),
(209, '', '', '', 0, 0, '', ''),
(210, '', '', '', 0, 0, '', ''),
(211, '', '', '', 0, 0, '', ''),
(212, '', '', '', 0, 0, '', ''),
(213, '', '', '', 0, 0, '', ''),
(214, '', '', '', 0, 0, '', ''),
(215, '', '', '', 0, 0, '', ''),
(216, '', '', '', 0, 0, '', ''),
(217, '', '', '', 0, 0, '', ''),
(218, '', '', '', 0, 0, '', ''),
(219, '', '', '', 0, 0, '', ''),
(220, '', '', '', 0, 0, '', ''),
(221, '', '', '', 0, 0, '', ''),
(222, '', '', '', 0, 0, '', ''),
(223, '', '', '', 0, 0, '', ''),
(224, '', '', '', 0, 0, '', ''),
(225, '', '', '', 0, 0, '', ''),
(226, 'abdennebi', 'nizar', 'sdfsdf ', 25354402, 0, 'nizar.abdennebi@gmail.com', '123456'),
(227, '', '', '', 0, 0, '', ''),
(228, '', '', '', 0, 0, '', ''),
(229, '', '', '', 0, 0, '', ''),
(230, '', '', '', 0, 0, '', ''),
(231, '', '', '', 0, 0, '', ''),
(232, '', '', '', 0, 0, '', ''),
(233, '', '', '', 0, 0, '', ''),
(234, '', '', '', 0, 0, '', ''),
(235, '', '', '', 0, 0, '', ''),
(236, '', '', '', 0, 0, '', ''),
(237, '', '', '', 0, 0, '', ''),
(238, '', '', '', 0, 0, '', ''),
(239, '', '', '', 0, 0, '', ''),
(240, '', '', '', 0, 0, '', ''),
(241, 'mmm', '', '', 0, 0, '', ''),
(242, 'kllm', '', '', 0, 0, '', ''),
(243, 'mmmmmm', '', '', 0, 0, '', ''),
(244, 'aaaa', '', '', 0, 0, '', ''),
(245, '', '', '', 0, 0, '', ''),
(246, 'modif', '', '', 0, 0, '', ''),
(247, 'abd rahmen', '', '', 0, 0, '', ''),
(248, '', '', '', 0, 0, '', ''),
(249, '', '', '', 0, 0, '', ''),
(250, '', '', '', 0, 0, '', ''),
(251, 'mmm', 'lk,k', 'lj', 562, 45, 'jn,', 'ihbjn'),
(252, 'unfv', 'hnd', 'tn', 85, 85, 'net', 'net'),
(253, '', '', '', 0, 0, '', ''),
(254, '', '', '', 0, 0, '', ''),
(255, '', '', '', 0, 0, '', ''),
(256, '', '', '', 0, 0, '', ''),
(257, '', '', '', 0, 0, '', ''),
(258, '', '', '', 0, 0, '', ''),
(259, '', '', '', 0, 0, '', ''),
(260, '', '', '', 0, 0, '', ''),
(261, '', '', '', 0, 0, '', ''),
(262, '', '', '', 0, 0, '', ''),
(263, '', '', '', 0, 0, '', ''),
(264, '', '', '', 0, 0, '', ''),
(265, '', '', '', 0, 0, '', ''),
(266, 'gharbi', 'ahmed', 'citÃ© zouhour numero 50', 21550473, 71548645, 'mkj@hotmail.com', '147258369'),
(267, 'mm', 'mmm', '', 0, 0, '', ''),
(268, 'mm', '', '', 0, 0, '', ''),
(269, 'ahmadi', 'Moradd', 'cite mimoza n 50 Beja', 21550705, 78555245, 'msi.moussi@gmail.com', '12345678m'),
(270, 'Jmili', 'Issa', 'beja', 21000000, 78555555, 'medmed@live.fr', '123456'),
(271, 'mmiuh', 'mmm', '', 0, 0, '', ''),
(272, '', '', '', 0, 0, '', ''),
(273, 'abdennebi', 'nizar', 'Tunis', 23000000, 71333333, 'nizar.abdi@gmail.com', '147258369'),
(274, 'werhani', 'Slah', 'citÃ© khadhra N70 ariana', 55555555, 71111111, 'med@hotmail.com', '22222'),
(275, 'moussi', 'mohamed', 'citÃ© ', 21550705, 7800000, 'moussi@live.fr', '123456'),
(276, '$NomC', '$PrenomC', '$AdresseC', 0, 0, '$EmailC', '$MotPasseC'),
(277, 'uy', 'Ã§yyb', 'Ã§Ã¨y', 652, 52, 'yuhh', 'uih'),
(278, 'abdennebi', 'nizar', 'sdfsdfsd ', 25354402, 71772772, 'nizar.abdennebi@gmail.com', '123456'),
(279, 'aaaa', 'toto', 'hhdhdhdhh', 78554226, 71559886, 'toto@gmail.com', '123456'),
(280, 'mohamed', 'moussi', 'tunis', 21550705, 21550705, 'moussi.m@live.fr', 'med1200..'),
(281, 'aaaaaaaa', 'aaaaaaaaaa', 'aaaaaaaaaaa', 65465, 54161, 'msi.moussi@gmail.com', 'test');

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=47 ;

--
-- Contenu de la table `devis_reparation`
--

INSERT INTO `devis_reparation` (`id_devis_reparation`, `rapport_diagnostique`, `devis`, `Commentaire_Devis`, `date_creation_devis`) VALUES
(31, '1111', '11115', '11115', NULL),
(32, 'mm55', 'mmm55', 'mmm55', NULL),
(33, 'lxvmm', 'kbhsjd', 'jhv', NULL),
(34, 'ooo', 'oo', 'oo', NULL),
(35, 'mohamed', 'mkdj', 'lkn', NULL),
(36, 'Panne Affichage', 'Changement disque dur avec un barette memoire', 'Installation SystÃ¨me', NULL),
(37, 'panne processeur', 'changement de processeur', 'installation systÃ¨me', NULL),
(38, 'mmahmed', 'kjhdmm', 'lmmmm', NULL),
(39, 'gfhhfdhghfd', 'hgh', 'hgfh', NULL),
(40, 'kjf', 'jdcnv', 'mkjfnvs', NULL),
(41, 'lk', 'mnli', 'mn', NULL),
(42, 'rapport', 'ljhb', 'jhvdf', NULL),
(43, 'fiuhe', 'duf', 'mdkv', NULL),
(44, 'fi hit', 'fi hit', 'ok', NULL),
(45, 'test', 'test', 'test', NULL),
(46, 'panne ', 'devis', 'comment', NULL);

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

--
-- Contenu de la table `employe`
--

INSERT INTO `employe` (`id_employe`, `nom_Emp`, `prenom_Emp`, `adresse_Emp`, `numTelMobil`, `numTelFix`, `emailEmp`, `passwordEmp`) VALUES
(1, 'abdennebi', 'nizar', 'fjhd', 54, 5641, 'nizar.abdennebi@gmail.com', '123456'),
(2, 'aaaa', 'nizar2', 'lhb', 51, 651, 'nizar.abdennebi@ymail.com', '654321'),
(3, 'moidv', 'kjb', 'kb', 564, 54, 'jhvb', 'kjb'),
(4, 'kjb', 'mjkb', 'kjjb', 5, 54, 'kjb', 'kjb'),
(5, 'mkj', 'lhb', 'lib', 65, 654, 'oiih', 'lb'),
(6, 'liik', 'muh', 'lj', 45, 65, 'oih', 'kjbj'),
(7, 'ydjtd', 'trh', 'htrh', 65, 351, 'kjb', 'hvb'),
(8, 'rg', 'gfsd', 'gdfs', 584, 458, 'dfs', 'df'),
(9, 'ml', 'kb', 'ilu', 5, 6, 'oln', 'kb'),
(10, 'oub', 'lhb', 'mub', 54, 65, 'jbn', 'lkb'),
(11, 'hs', 'drth', 'htr', 51, 651, 'fsdh', '45'),
(12, 'abc', 'moghzel', 'sdfsdf', 21554778, 71554887, 'moghzel@gmail.com', '123456'),
(13, 'dfgd', 'dfgdfg', 'ssfgs', 89789789, 56456456, 'dsdfsd', '123456');

-- --------------------------------------------------------

--
-- Structure de la table `etat_fiche`
--

CREATE TABLE IF NOT EXISTS `etat_fiche` (
  `id_etat_fiche` int(8) NOT NULL AUTO_INCREMENT,
  `nom_etat` varchar(50) DEFAULT NULL,
  `commentaire_etat` text,
  PRIMARY KEY (`id_etat_fiche`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=292 ;

--
-- Contenu de la table `etat_fiche`
--

INSERT INTO `etat_fiche` (`id_etat_fiche`, `nom_etat`, `commentaire_etat`) VALUES
(99, 'Ouvert', 'panne disque dur'),
(100, 'Ouvert', 'panne disque dur'),
(101, 'Ouvert', 'panne disque dur'),
(102, 'en attente de traitement', 'dfsdfsdf'),
(103, 'Ouvert', 'panne disque dur'),
(104, 'Ouvert', 'panne disque dur'),
(105, 'Ouvert', 'panne disque dur'),
(106, 'Ouvert', 'panne disque dur'),
(107, 'Ouvert', 'panne disque dur'),
(108, 'Ouvert', 'panne disque dur'),
(109, 'Ouvert', 'panne disque dur'),
(110, 'Ouvert', 'panne disque dur'),
(111, 'Ouvert', 'panne disque dur'),
(112, 'Ouvert', 'panne disque dur'),
(113, 'Ouvert', 'panne disque dur'),
(114, 'Ouvert', 'panne disque dur'),
(115, 'Ouvert', 'panne disque dur'),
(116, 'Ouvert', 'panne disque dur'),
(117, 'Ouvert', 'panne disque dur'),
(118, 'Ouvert', 'panne disque dur'),
(119, 'Ouvert', 'panne disque dur'),
(120, 'Ouvert', 'panne disque dur'),
(121, 'Ouvert', 'panne disque dur'),
(122, 'Ouvert', 'panne disque dur'),
(123, 'Ouvert', 'panne disque dur'),
(124, 'Ouvert', 'panne disque dur'),
(125, 'Ouvert', 'panne disque dur'),
(126, 'Ouvert', 'panne disque dur'),
(127, 'Ouvert', 'panne disque dur'),
(128, 'Ouvert', 'panne disque dur'),
(129, 'Ouvert', 'panne disque dur'),
(130, 'Ouvert', 'panne disque dur'),
(131, 'Ouvert', 'panne disque dur'),
(132, 'Ouvert', 'panne disque dur'),
(133, 'Ouvert', 'panne disque dur'),
(134, 'Ouvert', 'panne disque dur'),
(135, 'Ouvert', 'panne disque dur'),
(136, 'Ouvert', 'panne disque dur'),
(137, 'Ouvert', 'panne disque dur'),
(138, 'Ouvert', 'panne disque dur'),
(139, 'Ouvert', 'panne disque dur'),
(140, 'Ouvert', 'panne disque dur'),
(141, 'Ouvert', 'panne disque dur'),
(142, 'Ouvert', 'panne disque dur'),
(143, 'Ouvert', 'panne disque dur'),
(144, 'Ouvert', 'panne disque dur'),
(145, 'Ouvert', 'panne disque dur'),
(146, 'Ouvert', 'panne disque dur'),
(147, 'Ouvert', 'panne disque dur'),
(148, 'Ouvert', 'panne disque dur'),
(149, 'Ouvert', 'panne disque dur'),
(150, 'Ouvert', 'panne disque dur'),
(151, 'Ouvert', 'panne disque dur'),
(152, 'Ouvert', 'panne disque dur'),
(153, 'Ouvert', 'panne disque dur'),
(154, 'Ouvert', 'panne disque dur'),
(155, 'Ouvert', 'panne disque dur'),
(156, 'Ouvert', 'panne disque dur'),
(157, 'Ouvert', 'panne disque dur'),
(158, 'Ouvert', 'panne disque dur'),
(159, 'Ouvert', 'panne disque dur'),
(160, 'Ouvert', 'panne disque dur'),
(161, 'Ouvert', 'panne disque dur'),
(162, 'Ouvert', 'panne disque dur'),
(163, 'Ouvert', 'panne disque dur'),
(164, 'Ouvert', 'panne disque dur'),
(165, 'Ouvert', 'panne disque dur'),
(166, 'Ouvert', 'panne disque dur'),
(167, 'Ouvert', 'panne disque dur'),
(168, 'Ouvert', 'panne disque dur'),
(169, 'Ouvert', 'panne disque dur'),
(170, 'Ouvert', 'panne disque dur'),
(171, 'Ouvert', 'panne disque dur'),
(172, 'Ouvert', 'panne disque dur'),
(173, 'Ouvert', 'panne disque dur'),
(174, 'Ouvert', 'panne disque dur'),
(175, 'Ouvert', 'panne disque dur'),
(176, 'Ouvert', 'panne disque dur'),
(177, 'Ouvert', 'panne disque dur'),
(178, 'Ouvert', 'panne disque dur'),
(179, 'Ouvert', 'panne disque dur'),
(180, 'Ouvert', 'panne disque dur'),
(181, 'Ouvert', 'panne disque dur'),
(182, 'Ouvert', 'panne disque dur'),
(183, 'Ouvert', 'panne disque dur'),
(184, 'Ouvert', 'panne disque dur'),
(185, 'Ouvert', 'panne disque dur'),
(186, 'Ouvert', 'panne disque dur'),
(187, 'Ouvert', 'panne disque dur'),
(188, 'Ouvert', 'panne disque dur'),
(189, 'Ouvert', 'panne disque dur'),
(190, 'Ouvert', 'panne disque dur'),
(191, 'Ouvert', 'panne disque dur'),
(192, 'Ouvert', 'panne disque dur'),
(193, 'Ouvert', 'panne disque dur'),
(194, 'Ouvert', 'panne disque dur'),
(195, 'Ouvert', 'panne disque dur'),
(196, 'Ouvert', 'panne disque dur'),
(197, 'Ouvert', 'panne disque dur'),
(198, 'Ouvert', 'panne disque dur'),
(199, 'Ouvert', 'panne disque dur'),
(200, 'Ouvert', 'panne disque dur'),
(201, 'Ouvert', 'panne disque dur'),
(202, 'Ouvert', 'panne disque dur'),
(203, 'Ouvert', 'panne disque dur'),
(204, 'Ouvert', 'panne disque dur'),
(205, 'Ouvert', 'panne disque dur'),
(206, 'Ouvert', 'panne disque dur'),
(207, 'Ouvert', 'panne disque dur'),
(208, 'Ouvert', 'panne disque dur'),
(209, 'Ouvert', 'panne disque dur'),
(210, 'Ouvert', 'panne disque dur'),
(211, 'Ouvert', 'panne disque dur'),
(212, 'Ouvert', 'panne disque dur'),
(213, 'Ouvert', 'panne disque dur'),
(214, 'Ouvert', 'panne disque dur'),
(215, 'Ouvert', 'panne disque dur'),
(216, 'Ouvert', 'panne disque dur'),
(217, 'Ouvert', 'panne disque dur'),
(218, 'Ouvert', 'panne disque dur'),
(219, 'Ouvert', 'panne disque dur'),
(220, 'Ouvert', 'panne disque dur'),
(221, 'Ouvert', 'panne disque dur'),
(222, 'Ouvert', 'panne disque dur'),
(223, 'Ouvert', 'panne disque dur'),
(224, 'Ouvert', 'panne disque dur'),
(225, 'Ouvert', 'panne disque dur'),
(226, 'Ouvert', 'panne disque dur'),
(227, 'Ouvert', 'panne disque dur'),
(228, 'Ouvert', 'panne disque dur'),
(229, 'Ouvert', 'panne disque dur'),
(230, 'Ouvert', 'panne disque dur'),
(231, 'Ouvert', 'panne disque dur'),
(232, 'Ouvert', 'panne disque dur'),
(233, 'Ouvert', 'panne disque dur'),
(234, 'Ouvert', 'panne disque dur'),
(235, 'Ouvert', 'panne disque dur'),
(236, 'Ouvert', 'panne disque dur'),
(237, 'Ouvert', 'panne disque dur'),
(238, 'Ouvert', 'panne disque dur'),
(239, 'Ouvert', 'panne disque dur'),
(240, 'Ouvert', 'panne disque dur'),
(241, 'Ouvert', 'panne disque dur'),
(242, 'Ouvert', 'panne disque dur'),
(243, 'Ouvert', 'panne disque dur'),
(244, 'Ouvert', 'panne disque dur'),
(245, 'Ouvert', 'panne disque dur'),
(246, 'Ouvert', 'panne disque dur'),
(247, 'Ouvert', 'panne disque dur'),
(248, 'Ouvert', 'panne disque dur'),
(249, 'Ouvert', 'panne disque dur'),
(250, 'Ouvert', 'panne disque dur'),
(251, 'Ouvert', 'panne disque dur'),
(252, 'Ouvert', 'panne disque dur'),
(253, 'Ouvert', 'panne disque dur'),
(254, 'Ouvert', 'panne disque dur'),
(255, 'Ouvert', 'panne disque dur'),
(256, 'Ouvert', 'panne disque dur'),
(257, 'Ouvert', 'panne disque dur'),
(258, 'Ouvert', 'panne disque dur'),
(259, 'Ouvert', 'panne disque dur'),
(260, 'Ouvert', 'panne disque dur'),
(261, 'Ouvert', 'panne disque dur'),
(262, 'Ouvert', 'panne disque dur'),
(263, 'Ouvert', 'panne disque dur'),
(264, 'Ouvert', 'panne disque dur'),
(265, 'Ouvert', 'panne disque dur'),
(266, 'Ouvert', 'panne disque dur'),
(267, 'Ouvert', 'panne disque dur'),
(268, 'Ouvert', 'panne disque dur'),
(269, 'Ouvert', 'panne disque dur'),
(270, 'Ouvert', 'panne disque dur'),
(271, 'Ouvert', 'panne disque dur'),
(272, 'Ouvert', 'panne disque dur'),
(273, 'Ouvert', 'panne disque dur'),
(274, 'Ouvert', 'panne disque dur'),
(275, 'Ouvert', 'panne disque dur'),
(276, 'Ouvert', 'panne disque dur'),
(277, 'Ouvert', 'panne disque dur'),
(278, 'Ouvert', 'panne disque dur'),
(279, 'Ouvert', 'panne disque dur'),
(280, 'Ouvert', 'panne disque dur'),
(281, 'en attente de traitement', 'dfsdfsdf'),
(282, 'Ouvert', 'panne disque dur'),
(283, 'Ouvert', 'panne disque dur'),
(284, 'Ouvert', 'panne disque dur'),
(285, 'en attente de traitement', 'panne disque dur'),
(286, 'Ouvert', 'panne disque dur'),
(287, 'Ouvert', '$commentaire_etat_F'),
(288, 'En attante de confirmation de devis', 'panne disque dur'),
(289, 'reparation termine', 'panne disque dur'),
(290, 'Ouvert', 'dfsdfsdf'),
(291, 'Ouvert', 'test comment');

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=345 ;

--
-- Contenu de la table `fiche`
--

INSERT INTO `fiche` (`id_fiche`, `date_creation_fiche`, `date_fermeture_fiche`, `date_envoi_materiel`, `id_client`, `description_panne`, `observation`, `id_materiel`) VALUES
(256, '2012-06-05 00:00:00', NULL, NULL, 191, 'Panne carte graphique NVDIA', '', 170),
(331, '2012-11-11 00:00:00', NULL, NULL, 266, 'probleme bootage', '', 243),
(334, '2012-06-11 00:00:00', NULL, NULL, 269, 'Panne demarrage', '', 246),
(335, '2012-06-15 00:00:00', NULL, NULL, 270, 'Panne Processeur', '', 247),
(336, '2012-06-19 00:00:00', NULL, NULL, 273, 'lenteur de chargement de demarrage', '', 250),
(337, '2012-06-19 00:00:00', NULL, NULL, 274, 'panne de demarrage', '', 251),
(338, '2012-06-19 00:00:00', NULL, NULL, 275, 'panne affichage ecran', '', 252),
(339, '2000-12-12 00:00:00', NULL, NULL, 276, '$DescPanne', '', 253),
(340, '2000-12-12 00:00:00', NULL, NULL, 277, 'yugÃ¨yug', '', 254),
(341, '2012-12-12 00:00:00', NULL, NULL, 278, 'sdfsdfs', '', 255),
(342, '2012-06-15 00:00:00', NULL, NULL, 279, 'sdfsdfsd', '', 256),
(343, '2015-06-09 18:17:23', NULL, NULL, 280, 'disc dur', '', 257);

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
  `id_fournisseur` int(8) NOT NULL,
  PRIMARY KEY (`id_materiel`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=259 ;

--
-- Contenu de la table `materiel`
--

INSERT INTO `materiel` (`id_materiel`, `modele`, `marque`, `numero_serie`, `statut_materiel`, `accessoire`, `remarque`, `id_fournisseur`) VALUES
(169, '$Modele', '$Marque', '$NumSerie', '$StatMat', '', '', 0),
(170, 'inspiron N5110', 'DELL', '0215478ft', '---', '', '', 0),
(171, 'modele', 'MARQ', '$NumSerie', '---', '', '', 0),
(172, 'modele', 'MARQ', '$NumSerie', 'Non', '', '', 0),
(173, 'modele', 'MARQ', '$NumSerie', '---', '', '', 0),
(174, 'modele', 'MARQ', '$NumSerie', '---', '', '', 0),
(175, 'modele', 'MARQ', '$NumSerie', '---', '', '', 0),
(176, 'modele', 'MARQ', '$NumSerie', '---', '', '', 0),
(177, 'modele', 'MARQ', '$NumSerie', '---', '', '', 0),
(178, '', '', '', '---', '', '', 0),
(179, '', '', '', '---', '', '', 0),
(180, '', '', '', '---', '', '', 0),
(181, '', '', '', '---', '', '', 0),
(182, '', '', '', '', '', '', 0),
(183, '', '', '', '---', '', '', 0),
(184, '', '', '', '---', '', '', 0),
(185, '', '', '', '---', '', '', 0),
(186, '', '', '', '---', '', '', 0),
(187, '', '', '', '---', '', '', 0),
(188, '', '', '', '---', '', '', 0),
(189, '', '', '', '---', '', '', 0),
(190, '', '', '', '---', '', '', 0),
(191, '', '', '', '---', '', '', 0),
(192, '', '', '', '---', '', '', 0),
(193, '', '', '', '---', '', '', 0),
(194, '', '', '', '---', '', '', 0),
(195, '', '', '', '---', '', '', 0),
(196, '', '', '', '---', '', '', 0),
(197, '', '', '', '---', '', '', 0),
(198, '', '', '', '---', '', '', 0),
(199, '', '', '', '---', '', '', 0),
(200, '', '', '', '---', '', '', 0),
(201, '', '', '', '---', '', '', 0),
(202, '', '', '', '---', '', '', 0),
(203, 'inspiron 5040', 'DELL', 'dfs6s6df65sdf', 'Oui', '', '', 0),
(204, '', '', '', '---', '', '', 0),
(205, '', '', '', '---', '', '', 0),
(206, '', '', '', '---', '', '', 0),
(207, '', '', '', '---', '', '', 0),
(208, '', '', '', '---', '', '', 0),
(209, '', '', '', '---', '', '', 0),
(210, '', '', '', '---', '', '', 0),
(211, '', '', '', '---', '', '', 0),
(212, 'yhtgfds', '', '', '---', '', '', 0),
(213, '', '', '', '---', '', '', 0),
(214, '', '', '', '---', '', '', 0),
(215, '', '', '', '---', '', '', 0),
(216, '', '', '', '---', '', '', 0),
(217, '', '', '', '---', '', '', 0),
(218, '', '', '', '---', '', '', 0),
(219, '', '', '', '---', '', '', 0),
(220, '', '', '', '---', '', '', 0),
(221, '', '', '', '---', '', '', 0),
(222, '', '', '', '---', '', '', 0),
(223, '', '', '', '---', '', '', 0),
(224, '', '', '', '---', '', '', 0),
(225, '', '', '', '---', '', '', 0),
(226, '', '', '', '---', '', '', 0),
(227, '', '', '', '---', '', '', 0),
(228, 'miubn', 'kjb', 'jk', 'Oui', '', '', 0),
(229, 'net', 'nt', 'tn', 'Oui', '', '', 0),
(230, '', '', '', '---', '', '', 0),
(231, '', '', '', '---', '', '', 0),
(232, '', '', '', '---', '', '', 0),
(233, '', '', '', '---', '', '', 0),
(234, '', '', '', '---', '', '', 0),
(235, '', '', '', '---', '', '', 0),
(236, '', '', '', '---', '', '', 0),
(237, '', '', '', '---', '', '', 0),
(238, '', '', '', '---', '', '', 0),
(239, '', '', '', '---', '', '', 0),
(240, '', '', '', '---', '', '', 0),
(241, '', '', '', '---', '', '', 0),
(242, '', '', '', '---', '', '', 0),
(243, 'hp pavillon', 'hp', '5462dm', 'Non', '', '', 0),
(244, '', '', '', '---', '', '', 0),
(245, '', '', '', '---', '', '', 0),
(246, 'Sony VAIO', 'N500', '1254875467df', '---', '', '', 0),
(247, 'inspiron N5555', 'Dell', '52422shcb', '---', '', '', 0),
(248, '', '', '', '---', '', '', 0),
(249, '', '', '', '---', '', '', 0),
(250, 'acer 520c', 'Acer', '7212345356ca', 'Non', '', '', 0),
(251, 'Toshiba 770a', 'Toshiba', '84125243f', '---', '', '', 0),
(252, 'inspiron n200', 'dell', '2458156', 'Non', '', '', 0),
(253, '$Modele', '$Marque', '$NumSerie', 'oui', '', '', 0),
(254, 'iu', 'tf', 'trf', '---', '', '', 0),
(255, 'inspiron', 'dell', 'sdfsdfsjj', '---', '', '', 0),
(256, 'sdfdf', 'dfdfsd', 'sdfsdfsd', 'Oui', '', '', 0),
(257, 'inspiron n5110', 'Dell', '2525151', 'Non', '', '', 0),
(258, 'dzad', 'azazd', 'dazdad', 'Oui', 'azdazda', 'zdazd', 0);

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
(9, 'consulter fiche d ordre de reparation'),
(10, 'test');

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
