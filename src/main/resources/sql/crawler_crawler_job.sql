CREATE DATABASE  IF NOT EXISTS `crawler` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `crawler`;
-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: crawler
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `crawler_job`
--

DROP TABLE IF EXISTS `crawler_job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `crawler_job` (
  `name` varchar(32) NOT NULL,
  `running` tinyint(4) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `current` int(11) DEFAULT NULL,
  `total` int(11) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `last_update` datetime DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crawler_job`
--

LOCK TABLES `crawler_job` WRITE;
/*!40000 ALTER TABLE `crawler_job` DISABLE KEYS */;
INSERT INTO `crawler_job` VALUES ('categoriesJob',0,'Complete',28,28,'2018-06-26 15:20:47','2018-06-26 15:20:56','2018-06-26 15:20:56'),('categoriesListImgJob',0,'Complete',255,255,'2018-06-26 15:21:24','2018-06-26 15:23:33','2018-06-26 15:23:33'),('categoriesListJob',0,'Complete',28,28,'2018-06-26 15:21:04','2018-06-26 15:21:25','2018-06-26 15:21:25'),('CGWallpaperCategoriesJob',0,'Stop',0,0,NULL,NULL,NULL),('CGWallpaperDownloadJob',0,'Stop',0,0,NULL,NULL,NULL),('CGWallpaperJob',0,'Stop',0,0,NULL,NULL,NULL),('gameWallpaperCategoriesJob',0,'Stop',0,0,NULL,NULL,NULL),('gameWallpaperDownloadJob',0,'Stop',0,0,NULL,NULL,NULL),('gameWallpaperJob',0,'Stop',0,0,NULL,NULL,NULL),('wallpaperListJob',1,'Running',92,110,'2018-06-28 17:30:40','2018-06-28 16:58:12','2018-06-28 17:40:02');
/*!40000 ALTER TABLE `crawler_job` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-03 18:25:02
