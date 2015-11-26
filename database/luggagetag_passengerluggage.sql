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
-- Table structure for table `passengerluggage`
--

DROP TABLE IF EXISTS `passengerluggage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `passengerluggage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(255) DEFAULT NULL,
  `mname` varchar(255) DEFAULT NULL,
  `lname` varchar(255) DEFAULT NULL,
  `flight` varchar(255) DEFAULT NULL,
  `brand_id` int(11) DEFAULT NULL,
  `color_id` int(11) DEFAULT NULL,
  `weight` int(11) DEFAULT NULL,
  `material_id` int(11) DEFAULT NULL,
  `stickers` tinyint(1) DEFAULT NULL,
  `characteristic` text,
  `belt` tinyint(1) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  `location_id` int(11) DEFAULT NULL,
  `comment` text,
  `users_id` int(11) DEFAULT NULL,
  `date_added` date DEFAULT NULL,
  `date_changed` date DEFAULT NULL,
  `date_finished` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passengerluggage`
--

LOCK TABLES `passengerluggage` WRITE;
/*!40000 ALTER TABLE `passengerluggage` DISABLE KEYS */;
INSERT INTO `passengerluggage` VALUES (1,'Tom','','Scholten','KL1783',1,0,0,0,0,'null',0,0,1,'null',0,NULL,NULL,NULL),(2,'Jimmy','van','Wieringen','SK1549',1,0,0,0,0,'null',0,0,1,'null',0,NULL,NULL,NULL),(3,'Alex',NULL,'Lisenkov','RU177',3,0,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,0,NULL,NULL,NULL),(4,'Tarik','','Kilic','TK1673',4,0,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,0,NULL,NULL,NULL),(5,'Tom','','Zheng','FR4055',5,0,0,0,0,'null',0,0,2,'null',0,NULL,NULL,NULL),(6,'Tom','','Kamp','LH2478',6,0,0,0,0,'null',0,0,2,'null',0,NULL,NULL,NULL),(7,'Tom','van der','Horst','BA8734',7,0,0,0,0,'null',0,0,2,'null',0,NULL,NULL,NULL),(8,'Tom','','Lisenkov','KL907',8,0,0,0,0,'null',0,0,3,'null',0,NULL,NULL,NULL),(9,'Tom','','Scholten','LH1995',1,0,0,0,0,'null',0,0,3,'null',0,NULL,NULL,NULL),(10,'Tom','','Scholten','BID6A',2,0,0,0,0,'null',0,0,3,'null',0,NULL,NULL,NULL),(11,'Tom','','Hu','AB6660',3,0,0,0,0,'null',0,0,4,'null',0,NULL,NULL,NULL),(12,'Tom','van','Kooten','AB6306',4,0,0,0,0,'null',0,0,4,'null',0,NULL,NULL,NULL),(13,'Tom','','Bakker','TG921',5,0,0,0,0,'null',0,0,4,'null',0,NULL,NULL,NULL),(14,'Tom','','Harri','HY601',6,0,0,0,0,'null',0,0,5,'null',0,NULL,NULL,NULL);
/*!40000 ALTER TABLE `passengerluggage` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-11-26 11:28:47
