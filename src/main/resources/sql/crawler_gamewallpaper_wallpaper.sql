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
-- Table structure for table `gamewallpaper_wallpaper`
--

DROP TABLE IF EXISTS `gamewallpaper_wallpaper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `gamewallpaper_wallpaper` (
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
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gamewallpaper_wallpaper`
--

LOCK TABLES `gamewallpaper_wallpaper` WRITE;
/*!40000 ALTER TABLE `gamewallpaper_wallpaper` DISABLE KEYS */;
INSERT INTO `gamewallpaper_wallpaper` VALUES (1,1,1,'25 to Life wallpaper or background 01','https://www.gamewallpapers.com/viewwallpaper.php?wallpaper=wallpaper_25_to_life_01&titel=25+to+Life&nummer=01&normal=1','https://www.gamewallpapers.com/img_script/wallpaper_dir/img.php?src=wallpaper_25_to_life_01_1600.jpg&height=450&width=800&fill-to-fit',NULL,'https://www.gamewallpapers.com/download.php?img=wallpaper_25_to_life_01_1600.jpg','f08ed8c0504a93bf5d190b78a41b52791616f70746ff948c6d8488b29b4cd97e'),(2,1,1,'25 to Life wallpaper or background 07','https://www.gamewallpapers.com/viewwallpaper.php?wallpaper=wallpaper_25_to_life_07&titel=25+to+Life&nummer=07&normal=1','https://www.gamewallpapers.com/img_script/wallpaper_dir/img.php?src=wallpaper_25_to_life_07_1600.jpg&height=450&width=800&fill-to-fit',NULL,'https://www.gamewallpapers.com/download.php?img=wallpaper_25_to_life_07_1600.jpg','9a634e1e3541925e8ce7588604fc6532732c7cc9cbe9395600e10bae9d020e30'),(3,1,1,'25 to Life wallpaper or background 06','https://www.gamewallpapers.com/viewwallpaper.php?wallpaper=wallpaper_25_to_life_06&titel=25+to+Life&nummer=06&normal=1','https://www.gamewallpapers.com/img_script/wallpaper_dir/img.php?src=wallpaper_25_to_life_06_1600.jpg&height=450&width=800&fill-to-fit',NULL,'https://www.gamewallpapers.com/download.php?img=wallpaper_25_to_life_06_1600.jpg','83b1030d050585997531cf99dfe0f7c2d6494cd1dea7184a806a5e27a523b392'),(4,1,1,'25 to Life wallpaper or background 05','https://www.gamewallpapers.com/viewwallpaper.php?wallpaper=wallpaper_25_to_life_05&titel=25+to+Life&nummer=05&normal=1','https://www.gamewallpapers.com/img_script/wallpaper_dir/img.php?src=wallpaper_25_to_life_05_1600.jpg&height=450&width=800&fill-to-fit',NULL,'https://www.gamewallpapers.com/download.php?img=wallpaper_25_to_life_05_1600.jpg','6aa30852546b9a63e19e808e69d09ead2d2766ba4fff8a261d7f86f42ef3f92c'),(5,1,1,'25 to Life wallpaper or background 04','https://www.gamewallpapers.com/viewwallpaper.php?wallpaper=wallpaper_25_to_life_04&titel=25+to+Life&nummer=04&normal=1','https://www.gamewallpapers.com/img_script/wallpaper_dir/img.php?src=wallpaper_25_to_life_04_1600.jpg&height=450&width=800&fill-to-fit',NULL,'https://www.gamewallpapers.com/download.php?img=wallpaper_25_to_life_04_1600.jpg','49990dee07e5bb6939c2c5bf6e60c06add53124a71e14cbf3ce248689e6e6a74'),(6,1,1,'25 to Life wallpaper or background 03','https://www.gamewallpapers.com/viewwallpaper.php?wallpaper=wallpaper_25_to_life_03&titel=25+to+Life&nummer=03&normal=1','https://www.gamewallpapers.com/img_script/wallpaper_dir/img.php?src=wallpaper_25_to_life_03_1600.jpg&height=450&width=800&fill-to-fit',NULL,'https://www.gamewallpapers.com/download.php?img=wallpaper_25_to_life_03_1600.jpg','e6d4d585019bc79b50881811115175ab9b2ed7d92eee4753f6cea0500480bef9'),(7,1,1,'25 to Life wallpaper or background 02','https://www.gamewallpapers.com/viewwallpaper.php?wallpaper=wallpaper_25_to_life_02&titel=25+to+Life&nummer=02&normal=1','https://www.gamewallpapers.com/img_script/wallpaper_dir/img.php?src=wallpaper_25_to_life_02_1600.jpg&height=450&width=800&fill-to-fit',NULL,'https://www.gamewallpapers.com/download.php?img=wallpaper_25_to_life_02_1600.jpg','4a48f796178dcbb7e33cf1e9ae57fdd3b118b929dbb87599e98b5f7e6a170572'),(8,2,1,'4Story - Three Kingdoms & One Hero wallpaper or background 01','https://www.gamewallpapers.com/viewwallpaper.php?wallpaper=wallpaper_4story_-_three_kingdoms_and_one_hero_01&titel=4Story+-+Three+Kingdoms+%26+One+Hero&nummer=01&normal=1','https://www.gamewallpapers.com/img_script/wallpaper_dir/img.php?src=wallpaper_4story_-_three_kingdoms_and_one_hero_01_1920x1080.jpg&height=450&width=800&fill-to-fit',NULL,'https://www.gamewallpapers.com/download.php?img=wallpaper_4story_-_three_kingdoms_and_one_hero_01_1920x1080.jpg','d783ada319a15a404f1d5e8cf7b9b64a0e78ca8c308e0ba7e79d13d63a95c624'),(9,3,1,'A New Beginning wallpaper or background 01','https://www.gamewallpapers.com/viewwallpaper.php?wallpaper=wallpaper_a_new_beginning_01&titel=A+New+Beginning&nummer=01&normal=1','https://www.gamewallpapers.com/img_script/wallpaper_dir/img.php?src=wallpaper_a_new_beginning_01_2560x1440.jpg&height=450&width=800&fill-to-fit',NULL,'https://www.gamewallpapers.com/download.php?img=wallpaper_a_new_beginning_01_2560x1440.jpg','44fa16f9ec4163c843cfba47abdeb09232df9737510e60f778492625945cb620'),(10,4,1,'Ace Combat 4 wallpaper or background 05','https://www.gamewallpapers.com/viewwallpaper.php?wallpaper=wallpaper_ace_combat_4_05&titel=Ace+Combat+4&nummer=05&normal=1','https://www.gamewallpapers.com/img_script/wallpaper_dir/img.php?src=wallpaper_ace_combat_4_05_1600.jpg&height=450&width=800&fill-to-fit',NULL,'https://www.gamewallpapers.com/download.php?img=wallpaper_ace_combat_4_05_1600.jpg','cfb2d712e8a271e88a6c014408f0d012a0a244199d61fdd37ce67e4ddeef1870'),(11,5,1,'Ace Combat 5: The Unsung War wallpaper or background 01','https://www.gamewallpapers.com/viewwallpaper.php?wallpaper=wallpaper_ace_combat_5_the_unsung_war_01&titel=Ace+Combat+5%3A+The+Unsung+War&nummer=01&normal=1','https://www.gamewallpapers.com/img_script/wallpaper_dir/img.php?src=wallpaper_ace_combat_5_the_unsung_war_01_1600.jpg&height=450&width=800&fill-to-fit',NULL,'https://www.gamewallpapers.com/download.php?img=wallpaper_ace_combat_5_the_unsung_war_01_1600.jpg','b07869ec668aff676516e1fdc81e6eb0d115b62c9254b6339466874597fe0e1e'),(12,5,1,'Ace Combat 5: The Unsung War wallpaper or background 03','https://www.gamewallpapers.com/viewwallpaper.php?wallpaper=wallpaper_ace_combat_5_the_unsung_war_03&titel=Ace+Combat+5%3A+The+Unsung+War&nummer=03&normal=1','https://www.gamewallpapers.com/img_script/wallpaper_dir/img.php?src=wallpaper_ace_combat_5_the_unsung_war_03_1600.jpg&height=450&width=800&fill-to-fit',NULL,'https://www.gamewallpapers.com/download.php?img=wallpaper_ace_combat_5_the_unsung_war_03_1600.jpg','b68647bc7ba83a7f7c82ed5d57133ac16513d375bd459ee7ca9f53b36dbea266'),(13,5,1,'Ace Combat 5: The Unsung War wallpaper or background 02','https://www.gamewallpapers.com/viewwallpaper.php?wallpaper=wallpaper_ace_combat_5_the_unsung_war_02&titel=Ace+Combat+5%3A+The+Unsung+War&nummer=02&normal=1','https://www.gamewallpapers.com/img_script/wallpaper_dir/img.php?src=wallpaper_ace_combat_5_the_unsung_war_02_1680x1050.jpg&height=450&width=800&fill-to-fit',NULL,'https://www.gamewallpapers.com/download.php?img=wallpaper_ace_combat_5_the_unsung_war_02_1680x1050.jpg','88516dbceeec3bac3f9b09d56ddce5146685126d3028632dae62a7e8a5dd7fd6'),(14,6,1,'Ace Combat 6: Fires of Liberation wallpaper or background 01','https://www.gamewallpapers.com/viewwallpaper.php?wallpaper=wallpaper_ace_combat_6_fires_of_liberation_01&titel=Ace+Combat+6%3A+Fires+of+Liberation&nummer=01&normal=1','https://www.gamewallpapers.com/img_script/wallpaper_dir/img.php?src=wallpaper_ace_combat_6_fires_of_liberation_01_1920x1080.jpg&height=450&width=800&fill-to-fit',NULL,'https://www.gamewallpapers.com/download.php?img=wallpaper_ace_combat_6_fires_of_liberation_01_1920x1080.jpg','edac149a5670f033a4ec4c8f55c5e84f205b4445e511be49c53766932cb52745'),(15,7,1,'Ace Combat X: Skies of Deception wallpaper or background 01','https://www.gamewallpapers.com/viewwallpaper.php?wallpaper=wallpaper_ace_combat_x_skies_of_deception_01&titel=Ace+Combat+X%3A+Skies+of+Deception&nummer=01&normal=1','https://www.gamewallpapers.com/img_script/wallpaper_dir/img.php?src=wallpaper_ace_combat_x_skies_of_deception_01_1680x1050.jpg&height=450&width=800&fill-to-fit',NULL,'https://www.gamewallpapers.com/download.php?img=wallpaper_ace_combat_x_skies_of_deception_01_1680x1050.jpg','ce6f14d00be8dc2d44771f5e20ced22b4932aa9ad2d50334623cfd1500258955'),(16,7,1,'Ace Combat X: Skies of Deception wallpaper or background 02','https://www.gamewallpapers.com/viewwallpaper.php?wallpaper=wallpaper_ace_combat_x_skies_of_deception_02&titel=Ace+Combat+X%3A+Skies+of+Deception&nummer=02&normal=1','https://www.gamewallpapers.com/img_script/wallpaper_dir/img.php?src=wallpaper_ace_combat_x_skies_of_deception_02_1680x1050.jpg&height=450&width=800&fill-to-fit',NULL,'https://www.gamewallpapers.com/download.php?img=wallpaper_ace_combat_x_skies_of_deception_02_1680x1050.jpg','973cec3a0de072894b77f0a869ed812176ce10b9fb2b3934cacec8d9e0f68f5d'),(17,8,1,'Ace Combat Zero: The Belkan War wallpaper or background 01','https://www.gamewallpapers.com/viewwallpaper.php?wallpaper=wallpaper_ace_combat_zero_the_belkan_war_01&titel=Ace+Combat+Zero%3A+The+Belkan+War&nummer=01&normal=1','https://www.gamewallpapers.com/img_script/wallpaper_dir/img.php?src=wallpaper_ace_combat_zero_the_belkan_war_01_1680x1050.jpg&height=450&width=800&fill-to-fit',NULL,'https://www.gamewallpapers.com/download.php?img=wallpaper_ace_combat_zero_the_belkan_war_01_1680x1050.jpg','8aced9eb2594412c5cf5d37102283aa6cf864f4ac6bc7cf9e9a608bc0520212f'),(18,8,1,'Ace Combat Zero: The Belkan War wallpaper or background 03','https://www.gamewallpapers.com/viewwallpaper.php?wallpaper=wallpaper_ace_combat_zero_the_belkan_war_03&titel=Ace+Combat+Zero%3A+The+Belkan+War&nummer=03&normal=1','https://www.gamewallpapers.com/img_script/wallpaper_dir/img.php?src=wallpaper_ace_combat_zero_the_belkan_war_03_1680x1050.jpg&height=450&width=800&fill-to-fit',NULL,'https://www.gamewallpapers.com/download.php?img=wallpaper_ace_combat_zero_the_belkan_war_03_1680x1050.jpg','260515b26bc35e21efb1fd8d658a69b87bbeb5f62addc9198c37116f40f8c090'),(19,8,1,'Ace Combat Zero: The Belkan War wallpaper or background 02','https://www.gamewallpapers.com/viewwallpaper.php?wallpaper=wallpaper_ace_combat_zero_the_belkan_war_02&titel=Ace+Combat+Zero%3A+The+Belkan+War&nummer=02&normal=1','https://www.gamewallpapers.com/img_script/wallpaper_dir/img.php?src=wallpaper_ace_combat_zero_the_belkan_war_02_1680x1050.jpg&height=450&width=800&fill-to-fit',NULL,'https://www.gamewallpapers.com/download.php?img=wallpaper_ace_combat_zero_the_belkan_war_02_1680x1050.jpg','dfc2ac1823f7ef2a4348280a2dbb5447a4ff29192cba52c6140af583cb1fce86'),(20,9,1,'Act of War: Direct Action wallpaper or background 01','https://www.gamewallpapers.com/viewwallpaper.php?wallpaper=wallpaper_act_of_war_direct_action_01&titel=Act+of+War%3A+Direct+Action&nummer=01&normal=1','https://www.gamewallpapers.com/img_script/wallpaper_dir/img.php?src=wallpaper_act_of_war_direct_action_01_1600.jpg&height=450&width=800&fill-to-fit',NULL,'https://www.gamewallpapers.com/download.php?img=wallpaper_act_of_war_direct_action_01_1600.jpg','bf0c58148e1d42bb0a8d391d8d39698f29d7e6a45e14157be1a4c292cf07d98c'),(21,9,1,'Act of War: Direct Action wallpaper or background 03','https://www.gamewallpapers.com/viewwallpaper.php?wallpaper=wallpaper_act_of_war_direct_action_03&titel=Act+of+War%3A+Direct+Action&nummer=03&normal=1','https://www.gamewallpapers.com/img_script/wallpaper_dir/img.php?src=wallpaper_act_of_war_direct_action_03_1600.jpg&height=450&width=800&fill-to-fit',NULL,'https://www.gamewallpapers.com/download.php?img=wallpaper_act_of_war_direct_action_03_1600.jpg','b75097e834e19f7253ba50b5f3af84132b9b9937552ac661b3a1b76841aeddb0'),(22,9,1,'Act of War: Direct Action wallpaper or background 02','https://www.gamewallpapers.com/viewwallpaper.php?wallpaper=wallpaper_act_of_war_direct_action_02&titel=Act+of+War%3A+Direct+Action&nummer=02&normal=1','https://www.gamewallpapers.com/img_script/wallpaper_dir/img.php?src=wallpaper_act_of_war_direct_action_02_1600.jpg&height=450&width=800&fill-to-fit',NULL,'https://www.gamewallpapers.com/download.php?img=wallpaper_act_of_war_direct_action_02_1600.jpg','912d80c4747a9f9b1f6ab5f4fa30e053bf5f9efcd83f53a735b01f386c7eb32a'),(23,10,1,'Advent Shadow wallpaper or background 01','https://www.gamewallpapers.com/viewwallpaper.php?wallpaper=wallpaper_advent_shadow_01&titel=Advent+Shadow&nummer=01&normal=1','https://www.gamewallpapers.com/img_script/wallpaper_dir/img.php?src=wallpaper_advent_shadow_01_1600.jpg&height=450&width=800&fill-to-fit',NULL,'https://www.gamewallpapers.com/download.php?img=wallpaper_advent_shadow_01_1600.jpg','00011d0c19911f4973a1c05d492ff81696e7fd1d1b359eaea0b0c768728985b0');
/*!40000 ALTER TABLE `gamewallpaper_wallpaper` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-02 18:03:36
