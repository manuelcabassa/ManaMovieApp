CREATE DATABASE  IF NOT EXISTS `movieapp` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `movieapp`;
-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: movieapp
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client` (
  `idClient` int NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) NOT NULL,
  `middleName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) NOT NULL,
  `address` varchar(100) NOT NULL,
  `dateOfBirth` date NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `isAdmin` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idClient`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,'Manuel','A','Cabassa','San Juan','1992-02-23','mcabassa','admin123','Y'),(2,'Joan','Marie','Alvarez','Camuy','1995-03-03','jalvarez','prueba1','Y'),(3,'test','test','test','test','2023-01-01','test','test123','N'),(4,'TEST100','test2','HolaPrueba','test2','2023-01-01','prueba','test2','Y'),(8,'Jomar','','Soto','San Juan','1994-02-08','jsoto','prueba123','N'),(10,'admin','','admin','N/A','2023-04-28','admin','12345','Y');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client_has_movies`
--

DROP TABLE IF EXISTS `client_has_movies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client_has_movies` (
  `Client_idClient` int NOT NULL,
  `Movies_idMovie` int NOT NULL,
  `rentalDate` date DEFAULT NULL,
  PRIMARY KEY (`Client_idClient`,`Movies_idMovie`),
  KEY `fk_Client_has_Movies_Movies1_idx` (`Movies_idMovie`),
  KEY `fk_Client_has_Movies_Client_idx` (`Client_idClient`),
  CONSTRAINT `fk_Client_has_Movies_Client` FOREIGN KEY (`Client_idClient`) REFERENCES `client` (`idClient`),
  CONSTRAINT `fk_Client_has_Movies_Movies1` FOREIGN KEY (`Movies_idMovie`) REFERENCES `movie` (`idMovie`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client_has_movies`
--

LOCK TABLES `client_has_movies` WRITE;
/*!40000 ALTER TABLE `client_has_movies` DISABLE KEYS */;
/*!40000 ALTER TABLE `client_has_movies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie` (
  `idMovie` int NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `director` varchar(45) DEFAULT NULL,
  `writters` varchar(100) DEFAULT NULL,
  `releaseDate` date NOT NULL,
  `runningTime` varchar(45) DEFAULT NULL,
  `rated` varchar(45) NOT NULL,
  `genre` varchar(25) NOT NULL,
  `cast` varchar(300) DEFAULT NULL,
  `ImgPath` varchar(300) NOT NULL,
  `isRented` varchar(45) NOT NULL,
  `movie_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idMovie`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES (4,'65','t','t','2023-01-01','t','T','t','t','C:\\Users\\Manuel\\Desktop\\Java\\ManaMovieApp\\src\\main\\resources\\Image\\65.jpg','N',NULL),(5,'Creed','n/a','n/a','2023-01-01','n/a','PG','','Drama','C:\\Users\\Manuel\\Desktop\\Java\\ManaMovieApp\\src\\main\\resources\\Image\\Creed.jpg','N',NULL),(6,'Screen','t','t','2023-01-01','t','T','t','t','C:\\Users\\Manuel\\Desktop\\Java\\ManaMovieApp\\src\\main\\resources\\Image\\ScreenMovie.jpg','N',NULL),(8,'Renfield','t','t','2023-01-01','t','T','t','t','C:\\Users\\Manuel\\Desktop\\Java\\ManaMovieApp\\src\\main\\resources\\Image\\Renfield.jpg','N',NULL),(10,'Salt','t','t','2023-01-01','t','T','t','t','C:\\Users\\Manuel\\Desktop\\Java\\ManaMovieApp\\src\\main\\resources\\Image\\Salt.jpg','N',NULL),(16,'c','c','c','2023-01-01','c','C','c','c','C:\\Users\\Manuel\\Desktop\\Java\\ManaMovieApp\\src\\main\\resources\\Image\\Creed.jpg','N',NULL);
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-06 21:19:28
