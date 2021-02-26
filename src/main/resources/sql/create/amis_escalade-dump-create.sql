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
