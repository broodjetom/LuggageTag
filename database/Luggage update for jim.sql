-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: luggagetag
-- ------------------------------------------------------
-- Server version	5.7.9-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `luggage`
--

DROP TABLE IF EXISTS `luggage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `luggage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `brand_id` int(11) DEFAULT NULL,
  `color_id` int(11) DEFAULT NULL,
  `weight` float DEFAULT NULL,
  `material_id` int(11) DEFAULT NULL,
  `stickers` int(11) DEFAULT NULL,
  `characteristic` text,
  `belt` int(11) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  `location_id` int(11) DEFAULT NULL,
  `comment` text,
  `users_id` int(11) DEFAULT NULL,
  `date_added` date DEFAULT NULL,
  `date_changed` date DEFAULT NULL,
  `date_finished` date DEFAULT NULL,
  `situation` enum('Gevonden','Verloren','Afgehandeld') DEFAULT NULL,
  `passenger_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `luggage`
--

LOCK TABLES `luggage` WRITE;
/*!40000 ALTER TABLE `luggage` DISABLE KEYS */;
INSERT INTO `luggage` VALUES (1,1,1,10,1,1,'Dit is een testkoffer',1,1,1,'Wow jij bent echt mooi!',1,'2015-12-03','2015-12-03',NULL,'Verloren',NULL),(2,2,2,12,2,2,'Dit is ook een testkoffer',0,2,2,'Wat een aantekening is dit, zeg!',2,'2015-12-07','2015-12-07',NULL,'Verloren',NULL),(3,3,3,13,3,3,'Wat een kenmerken zeg.',1,3,3,'Dit is geschreven door Tom',3,'2015-11-09','2015-12-05',NULL,'Verloren',NULL),(4,4,4,14,4,4,'Het is zo leuk om een database te vullen',0,4,4,'School is stom.',4,'2014-09-15','2015-05-03',NULL,'Verloren',NULL),(6,4,5,18,3,4,'asdf',0,2,7,'asdf',9,'2015-11-08','2015-11-08','1970-01-01','Gevonden',NULL),(7,5,6,12,3,6,'asdf',0,2,6,'asdf',9,'2015-11-08','2015-11-08','1970-01-01','Verloren',NULL),(8,5,4,12.9,3,4,'hallo',0,3,5,'asdf',9,'2015-11-08','2015-11-08','1970-01-01','Verloren',NULL),(9,6,1,9.3,1,5,'asdf',0,3,5,'asdf',9,'2015-11-08','2015-11-08','1970-01-01','Verloren',NULL),(10,7,6,7.8,3,3,'asdf',0,3,6,'asdf',9,'2015-11-08','2015-11-08','1970-01-01','Verloren',NULL),(11,5,10,4.6,2,6,'asdf	',0,3,2,'asdf',9,'2015-11-08','2015-11-08','1970-01-01','Verloren',NULL),(12,5,7,4.6,3,2,'asdf',0,3,3,'asdf',9,'2015-11-08','2015-11-08','1970-01-01','Verloren',37),(13,2,7,2.7,4,8,'asdf',0,3,3,'asdf',9,'2015-11-08','2015-11-08','1970-01-01','Gevonden',0),(14,7,4,13.5,3,2,'Hey ik ben vierkant.',0,2,8,'Dit is geen comment.',9,'2015-12-08','2015-11-08','1970-01-01','Verloren',49);
/*!40000 ALTER TABLE `luggage` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-12-17 15:15:35
