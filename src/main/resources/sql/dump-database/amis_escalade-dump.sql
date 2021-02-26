-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: 
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!50606 SET @OLD_INNODB_STATS_AUTO_RECALC=@@INNODB_STATS_AUTO_RECALC */;
/*!50606 SET GLOBAL INNODB_STATS_AUTO_RECALC=OFF */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `amis-escalade`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `amis-escalade` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `amis-escalade`;

--
-- Table structure for table `t_commentaire`
--

DROP TABLE IF EXISTS `t_commentaire`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_commentaire` (
  `C_ID` int NOT NULL AUTO_INCREMENT,
  `C_DATE` date DEFAULT NULL,
  `C_COMMENTAIRE` varchar(500) DEFAULT NULL,
  `C_ID_SITE` int DEFAULT NULL,
  `C_ID_USER` int DEFAULT NULL,
  PRIMARY KEY (`C_ID`),
  KEY `FKqtakb8mgtq4ry4ijcful3w4v2` (`C_ID_USER`),
  KEY `t_commentaire_ibfk_1` (`C_ID_SITE`),
  CONSTRAINT `t_commentaire_ibfk_1` FOREIGN KEY (`C_ID_SITE`) REFERENCES `t_site` (`C_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `t_commentaire_ibfk_2` FOREIGN KEY (`C_ID_USER`) REFERENCES `t_user` (`C_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_commentaire`
--

LOCK TABLES `t_commentaire` WRITE;
/*!40000 ALTER TABLE `t_commentaire` DISABLE KEYS */;
INSERT INTO `t_commentaire` VALUES (15,'2021-02-17','très bon site d\'escalade ',20,32),(16,'2021-02-17','Je conseille ce site d\'escalade ',20,34),(17,'2021-02-17','Excellent site ',21,34),(18,'2021-02-17','Je recommande ce site pour les grimpeurs expérimentés',21,35),(19,'2021-02-17','Un site sympa pour les débutant  ',20,35);
/*!40000 ALTER TABLE `t_commentaire` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_role`
--

DROP TABLE IF EXISTS `t_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_role` (
  `C_ID` int NOT NULL AUTO_INCREMENT,
  `C_CODE` varchar(50) NOT NULL,
  `C_LABEL` varchar(50) NOT NULL,
  PRIMARY KEY (`C_ID`),
  UNIQUE KEY `C_CODE` (`C_CODE`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_role`
--

LOCK TABLES `t_role` WRITE;
/*!40000 ALTER TABLE `t_role` DISABLE KEYS */;
INSERT INTO `t_role` VALUES (3,'ADMIN','Administrateur'),(4,'MEMBER','Membre');
/*!40000 ALTER TABLE `t_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_secteur`
--

DROP TABLE IF EXISTS `t_secteur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_secteur` (
  `C_ID` int NOT NULL AUTO_INCREMENT,
  `C_NAME_SECTEUR` varchar(50) DEFAULT NULL,
  `C_VOIES` varchar(100) DEFAULT NULL,
  `C_HEIGHT_MAX` varchar(100) DEFAULT NULL,
  `C_EQUIPMENT` varchar(100) DEFAULT NULL,
  `C_TYPE_OF_SOCKETS` varchar(100) DEFAULT NULL,
  `C_ADDITIONAL_INFORMATION` varchar(100) DEFAULT NULL,
  `C_ID_SITE` int DEFAULT NULL,
  `C_ID_User` int DEFAULT NULL,
  `C_COTATION` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`C_ID`),
  KEY `FK93yqkxksutag7ka0q9t1kddqo` (`C_ID_User`),
  KEY `t_secteur_ibfk_1` (`C_ID_SITE`),
  CONSTRAINT `t_secteur_ibfk_1` FOREIGN KEY (`C_ID_SITE`) REFERENCES `t_site` (`C_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `t_secteur_ibfk_2` FOREIGN KEY (`C_ID_User`) REFERENCES `t_user` (`C_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_secteur`
--

LOCK TABLES `t_secteur` WRITE;
/*!40000 ALTER TABLE `t_secteur` DISABLE KEYS */;
INSERT INTO `t_secteur` VALUES (32,'Picothérapie','230','80m','harnais , casque , chaussons d\'escalade','granite','une des plus parcourues',20,24,'6a'),(33,'La ligne du temps','420','80 m','harnais , casque , chaussons d\'escalade','granite','la première voie difficile de la falaise',20,24,'7a'),(34,'Secteur Cascade','2','100m','harnais , casque , chaussons d\'escalade','calcaire , granite','Deux grandes classiques incontournables',21,24,'3c , 7a'),(35,'Secteur Point de vue','5','150','harnais , casque , chaussons d\'escalade','calcaire , granite','Quelques tout petits et petits pour L1, 2, 5 et 6.',21,24,'6a , 6b');
/*!40000 ALTER TABLE `t_secteur` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_site`
--

DROP TABLE IF EXISTS `t_site`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_site` (
  `C_ID` int NOT NULL AUTO_INCREMENT,
  `C_SITE_NAME` varchar(50) DEFAULT NULL,
  `C_SITE_TAG` varchar(100) DEFAULT NULL,
  `C_SITE_LOC_PAYS` varchar(100) DEFAULT NULL,
  `C_SITE_ADRESSE` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`C_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_site`
--

LOCK TABLES `t_site` WRITE;
/*!40000 ALTER TABLE `t_site` DISABLE KEYS */;
INSERT INTO `t_site` VALUES (20,'Ablon','Officiel Les amis de l’escalade ','france','40 Falaises - Escalade choisie aux environs du lac d’Annecy - R. Durieux, 2007'),(21,'Ailefroide','Officiel Les amis de l’escalade ','france','Maison du Parc national des Écrins - Maison du Parc de La Vallouise');
/*!40000 ALTER TABLE `t_site` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_topo`
--

DROP TABLE IF EXISTS `t_topo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_topo` (
  `C_ID` int NOT NULL AUTO_INCREMENT,
  `C_NAME` varchar(50) DEFAULT NULL,
  `C_DESCRIPTION` varchar(500) DEFAULT NULL,
  `C_PLACES` varchar(100) DEFAULT NULL,
  `C_RELEASE_DATE` date DEFAULT NULL,
  `C_ID_USER_WITH_TOPO` int DEFAULT NULL,
  `C_ID_USER_RESERVE` int DEFAULT NULL,
  `C_STATUS` varchar(100) DEFAULT NULL,
  `C_AVAILABLE` tinyint(1) DEFAULT NULL,
  `C_CONFIRM_RESERVATION` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`C_ID`),
  KEY `FKp2wd3vt4nu9mj2c356a3asohi` (`C_ID_USER_RESERVE`),
  KEY `FKfcojk2dxh79nl2emxcslbyfbb` (`C_ID_USER_WITH_TOPO`),
  CONSTRAINT `FKfcojk2dxh79nl2emxcslbyfbb` FOREIGN KEY (`C_ID_USER_WITH_TOPO`) REFERENCES `t_user` (`C_ID`),
  CONSTRAINT `FKp2wd3vt4nu9mj2c356a3asohi` FOREIGN KEY (`C_ID_USER_RESERVE`) REFERENCES `t_user` (`C_ID`),
  CONSTRAINT `t_topo_ibfk_1` FOREIGN KEY (`C_ID_USER_WITH_TOPO`) REFERENCES `t_user` (`C_ID`),
  CONSTRAINT `t_topo_ibfk_2` FOREIGN KEY (`C_ID_USER_RESERVE`) REFERENCES `t_user` (`C_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_topo`
--

LOCK TABLES `t_topo` WRITE;
/*!40000 ALTER TABLE `t_topo` DISABLE KEYS */;
INSERT INTO `t_topo` VALUES (13,'Ablon','La falaise appartient à un vallon de calcaire urgonien, parvenu jusqu’à nous sous forme de murs verticaux ou légèrement déversants, compacts et finement ciselés d’une multitude de cannelures et de picots, qui sont d’ailleurs la marque de fabrique d’Ablon. Quasiment aucun voie n’y échappe, et vos doigts s’en souviendront.',' Escalade choisie aux environs du lac d’Annecy','2021-02-17',31,NULL,NULL,1,0),(14,'Ailefroide','Préparez-vous à plonger dans un océan de granit d’une qualité constante, caractérisé par son grain féroce, qui le rend agréablement adhérent quand il s’agit de se tenir sur les prises, mais quelque peu abrasif pour la peau des doigts. Tout est là, des blocs dépassant rarement 4 m de haut, aux grandes parois dalleuses où vous embarquez pour des voyages de 400 m d’escalade.','Maison du Parc national des Écrins - Maison du Parc de La Vallouise','2021-02-17',31,NULL,NULL,1,0),(15,'Annot','La particularité du grès du coin, c’est qu’il ne présente que peu de prises : des trous, des plats, peu de réglettes... D’où des passages aussi physiques que limpides, et quelques mouvements morphologiques (on a la taille ou pas !). La particularité du site est dans les méthodes complexes, les réta ardus et les blocs hauts où se trouvent généralement les plus beaux passages.','Annot se trouve au Nord-Est du Verdon, à environ 90 km de Nice et 200 km de Marseille','2021-02-17',31,NULL,NULL,1,0);
/*!40000 ALTER TABLE `t_topo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_user` (
  `C_ID` int NOT NULL AUTO_INCREMENT,
  `C_NAME` varchar(50) DEFAULT NULL,
  `C_LASTNAME` varchar(100) DEFAULT NULL,
  `C_EMAIL` varchar(50) DEFAULT NULL,
  `C_PASSWORD` varchar(100) DEFAULT NULL,
  `C_ROLE_ID` int DEFAULT NULL,
  PRIMARY KEY (`C_ID`),
  KEY `FK7ir4idtqo8c6ixic2g8i43pu2` (`C_ROLE_ID`),
  CONSTRAINT `FK7ir4idtqo8c6ixic2g8i43pu2` FOREIGN KEY (`C_ROLE_ID`) REFERENCES `t_role` (`C_ID`),
  CONSTRAINT `t_user_ibfk_1` FOREIGN KEY (`C_ROLE_ID`) REFERENCES `t_role` (`C_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (24,'Marchandise','Freddy','freddy.marchandise@gmail.com','$2a$10$dCg1pk8IFoV65FJXXUwtGuRvXZdJiv7548p0Nm.DacQd1ADGTTt6m',3),(31,'ADMIN','ADMIN','ADMIN@gmail.com','$2a$10$nr1cgxxctloqgmB.KhgDsOd8N2KEqdnHJcc9IDNNZRLHMpKMfPOWq',3),(32,'Lacroix','Maurice','Maurice-Lacroix@gmail.com','$2a$10$oNDjZGLEj5BxUvAACekUruGyGl3WK0o2udrrJyXg6w6QYVfL6QelK',4),(33,'Bigot','Josette','Josette-78@gmail.com','$2a$10$0HT8YCjfu0ayLOrak.vbGOfA8flsvaJdy91K2mo0tEhoYhV6Uu0n6',4),(34,'Fernandes','Xavier','Xavier-Fernandes@gmail.com','$2a$10$IflvuS162JiphGflMaBA/u6giDYkF/wavXe0qi78ACFMm7mlyD1TO',4),(35,'Cordier-Pereira','Roger','Cordier-Pereira@gmail.com','$2a$10$ZzF3kItxKXFUI.fiBsNONefHio8Ud8w8UOUgvHxAxP5xhdaJrS62G',4),(36,'Voisin','Vincent','Vincent@gmail.com','$2a$10$ZVREzM1BwFGvHSji63YDve7kVe00mHMzMKXo/zUGIVoT.2iijj5va',4);
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;