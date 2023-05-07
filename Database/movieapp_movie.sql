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

-- Dump completed on 2023-05-06 21:18:01
