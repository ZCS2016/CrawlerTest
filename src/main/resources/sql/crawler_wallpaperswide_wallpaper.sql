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
-- Table structure for table `wallpaperswide_wallpaper`
--

DROP TABLE IF EXISTS `wallpaperswide_wallpaper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `wallpaperswide_wallpaper` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `categories_id` int(11) DEFAULT NULL,
  `page` int(11) DEFAULT NULL COMMENT '页码',
  `title` varchar(256) DEFAULT NULL COMMENT '标题',
  `src` varchar(256) DEFAULT NULL COMMENT '链接',
  `img` varchar(256) DEFAULT NULL COMMENT '封面',
  `img_hd` varchar(256) DEFAULT NULL COMMENT 'HD图片',
  `img_fhd` varchar(256) DEFAULT NULL COMMENT 'FHD图片',
  `hash` varchar(64) NOT NULL COMMENT 'hash',
  PRIMARY KEY (`id`),
  UNIQUE KEY `hash_UNIQUE` (`hash`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wallpaperswide_wallpaper`
--

LOCK TABLES `wallpaperswide_wallpaper` WRITE;
/*!40000 ALTER TABLE `wallpaperswide_wallpaper` DISABLE KEYS */;
/*!40000 ALTER TABLE `wallpaperswide_wallpaper` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-26 18:23:13
