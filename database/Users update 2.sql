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
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `passengerluggage_id` int(11) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `zip` varchar(255) DEFAULT NULL,
  `land` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `brands`
--

DROP TABLE IF EXISTS `brands`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `brands` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `brand` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brands`
--

LOCK TABLES `brands` WRITE;
/*!40000 ALTER TABLE `brands` DISABLE KEYS */;
INSERT INTO `brands` VALUES (1,'Samsonite'),(2,'Rimowa'),(3,'Line'),(4,'Eastpak'),(5,'American Tourister'),(6,'Alumaxx'),(7,'Bamex'),(8,'Carryon'),(9,'Decent'),(10,'Delsey'),(11,'Ellehammer'),(12,'Enrico Benetti'),(13,'Kipling'),(14,'Okiedog'),(15,'Pick Pack'),(16,'Princess'),(17,'Saxoline'),(18,'Skoot'),(19,'Suitsuit'),(20,'The Cuties and Pals'),(21,'Titan'),(22,'Travelite'),(23,'Trunkie'),(24,'Tumi');
/*!40000 ALTER TABLE `brands` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `colors`
--

DROP TABLE IF EXISTS `colors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `colors` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `color` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `colors`
--

LOCK TABLES `colors` WRITE;
/*!40000 ALTER TABLE `colors` DISABLE KEYS */;
INSERT INTO `colors` VALUES (1,'Black'),(2,'White'),(3,'Grey'),(4,'Brown'),(5,'Red'),(6,'Orange'),(7,'Yellow'),(8,'Green'),(9,'Blue'),(10,'Purple'),(11,'Multicolor');
/*!40000 ALTER TABLE `colors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `email`
--

DROP TABLE IF EXISTS `email`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `email` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `passengerluggage_id` int(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `email`
--

LOCK TABLES `email` WRITE;
/*!40000 ALTER TABLE `email` DISABLE KEYS */;
/*!40000 ALTER TABLE `email` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locations`
--

DROP TABLE IF EXISTS `locations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `locations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `location` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locations`
--

LOCK TABLES `locations` WRITE;
/*!40000 ALTER TABLE `locations` DISABLE KEYS */;
INSERT INTO `locations` VALUES (1,'Seattle'),(2,'Amsterdam'),(3,'Moskou'),(4,'Berlijn'),(5,'New York'),(6,'Nieuw-Vennep');
/*!40000 ALTER TABLE `locations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materials`
--

DROP TABLE IF EXISTS `materials`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `materials` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `material` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materials`
--

LOCK TABLES `materials` WRITE;
/*!40000 ALTER TABLE `materials` DISABLE KEYS */;
/*!40000 ALTER TABLE `materials` ENABLE KEYS */;
UNLOCK TABLES;

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
  `situation` enum('Gevonden','Verloren','Afgehandeld') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passengerluggage`
--

LOCK TABLES `passengerluggage` WRITE;
/*!40000 ALTER TABLE `passengerluggage` DISABLE KEYS */;
INSERT INTO `passengerluggage` VALUES (1,'Tom','','Scholten','KL1783',1,0,0,0,0,'null',0,0,1,'null',0,NULL,NULL,NULL,'Afgehandeld'),(2,'Jimmy','van','Wieringen','SK1549',1,0,0,0,0,'null',0,0,1,'null',0,NULL,NULL,NULL,'Verloren'),(3,'Alex',NULL,'Lisenkov','RU177',3,0,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,0,NULL,NULL,NULL,NULL),(4,'Tarik','','Kilic','TK1673',4,0,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,0,NULL,NULL,NULL,NULL),(5,'Tom','','Zheng','FR4055',5,0,0,0,0,'null',0,0,2,'null',0,NULL,NULL,NULL,NULL),(6,'Tom','','Kamp','LH2478',6,0,0,0,0,'null',0,0,2,'null',0,NULL,NULL,NULL,NULL),(7,'Tom','van der','Horst','BA8734',7,0,0,0,0,'null',0,0,2,'null',0,NULL,NULL,NULL,NULL),(8,'Tom','','Lisenkov','KL907',8,0,0,0,0,'null',0,0,3,'null',0,NULL,NULL,NULL,NULL),(9,'Tom','','Scholten','LH1995',1,0,0,0,0,'null',0,0,3,'null',0,NULL,NULL,NULL,NULL),(10,'Tom','','Scholten','BID6A',2,0,0,0,0,'null',0,0,3,'null',0,NULL,NULL,NULL,NULL),(11,'Tom','','Hu','AB6660',3,0,0,0,0,'null',0,0,4,'null',0,NULL,NULL,NULL,NULL),(12,'Tom','van','Kooten','AB6306',4,0,0,0,0,'null',0,0,4,'null',0,NULL,NULL,NULL,NULL),(13,'Tom','','Bakker','TG921',5,0,0,0,0,'null',0,0,4,'null',0,NULL,NULL,NULL,NULL),(14,'Tom','','Harri','HY601',6,0,0,0,0,'null',0,0,5,'null',0,NULL,NULL,NULL,NULL),(15,'Nick',NULL,'Verbaas','PE136',5,0,0,0,0,'null',0,0,3,'null',0,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `passengerluggage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phone`
--

DROP TABLE IF EXISTS `phone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `phone` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `passengerluggage_id` int(11) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phone`
--

LOCK TABLES `phone` WRITE;
/*!40000 ALTER TABLE `phone` DISABLE KEYS */;
/*!40000 ALTER TABLE `phone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `types`
--

DROP TABLE IF EXISTS `types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `types` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `types`
--

LOCK TABLES `types` WRITE;
/*!40000 ALTER TABLE `types` DISABLE KEYS */;
INSERT INTO `types` VALUES (1,'Suitcase'),(2,'Carry-on'),(3,'Rucksack'),(4,'Electronica');
/*!40000 ALTER TABLE `types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `fname` varchar(255) DEFAULT NULL,
  `mname` varchar(255) DEFAULT NULL,
  `lname` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `ee_num` varchar(255) DEFAULT NULL,
  `employee` tinyint(1) DEFAULT NULL,
  `manager` tinyint(1) DEFAULT NULL,
  `admin` tinyint(1) DEFAULT NULL,
  `setting_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'broodjetom','115026','Tom','','Scholten','0648128767','12345',1,0,0,1),(2,'bob','-874524924','Thomas',NULL,'Kamp','0613245342','54321',0,1,0,2),(3,'drdick','101129530','Jimmy','van','Wieringen','0676543233','34567',0,0,1,3),(4,'alextosti','2996766','Alex',NULL,'Lisenkov','0687634522','96857',1,0,0,4),(5,'totaltarik','110131079','Tarik',NULL,'Kilic','0697867535','47386',1,0,0,5),(6,'blazingspirit420','717401928','Kah Kit',NULL,'Zheng','0614254786','15368',0,1,0,6),(7,'manager','3556498','Manager',NULL,'Test','0909090909','09090',0,1,0,4),(8,'admin','3556498','Admin','','Test','0909090909','09090',0,0,1,3),(9,'employee','3556498','Employee',NULL,'Test','0909090909','09090',1,0,0,5),(10,'DarrellWorld','-1338961692','Darrell','','Poleon','0695847362','39284',0,0,0,6);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-12-03 15:18:06
