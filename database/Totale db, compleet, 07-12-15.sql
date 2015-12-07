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
  `passenger_id` int(11) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `zip` varchar(255) DEFAULT NULL,
  `land` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (3,NULL,'','',''),(4,NULL,'','',''),(5,NULL,'','',''),(6,NULL,'','',''),(7,NULL,'','',''),(8,NULL,'','',''),(9,NULL,'','',''),(10,NULL,'','',''),(11,NULL,'','',''),(12,44,'','','');
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
  `passenger_id` int(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `email`
--

LOCK TABLES `email` WRITE;
/*!40000 ALTER TABLE `email` DISABLE KEYS */;
INSERT INTO `email` VALUES (5,NULL,''),(6,NULL,''),(7,NULL,''),(8,NULL,''),(9,NULL,''),(10,NULL,''),(11,NULL,''),(12,NULL,''),(13,NULL,''),(14,44,'');
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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locations`
--

LOCK TABLES `locations` WRITE;
/*!40000 ALTER TABLE `locations` DISABLE KEYS */;
INSERT INTO `locations` VALUES (1,'Seattle'),(2,'Amsterdam'),(3,'Moskou'),(4,'Berlijn'),(5,'New York'),(6,'Nieuw-Vennep'),(7,'Londen'),(8,'Shanghai'),(9,'Tokio'),(10,'Vancouver'),(11,'Los Angeles'),(12,'Miami'),(13,'Rio de Janeiro');
/*!40000 ALTER TABLE `locations` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `luggage`
--

LOCK TABLES `luggage` WRITE;
/*!40000 ALTER TABLE `luggage` DISABLE KEYS */;
INSERT INTO `luggage` VALUES (1,1,1,10,1,1,'Dit is een testkoffer',1,1,1,'Wow jij bent echt mooi!',1,'2015-12-03','2015-12-03',NULL,'Verloren',NULL),(2,2,2,12,2,2,'Dit is ook een testkoffer',0,2,2,'Wat een aantekening is dit, zeg!',2,'2015-12-07','2015-12-07',NULL,'Verloren',NULL),(3,3,3,13,3,3,'Wat een kenmerken zeg.',1,3,3,'Dit is geschreven door Tom',3,'2015-11-09','2015-12-05',NULL,'Verloren',NULL),(4,4,4,14,4,4,'Het is zo leuk om een database te vullen',0,4,4,'School is stom.',4,'2014-09-15','2015-05-03',NULL,'Verloren',NULL);
/*!40000 ALTER TABLE `luggage` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materials`
--

LOCK TABLES `materials` WRITE;
/*!40000 ALTER TABLE `materials` DISABLE KEYS */;
INSERT INTO `materials` VALUES (1,'Plastic'),(2,'Hout'),(3,'Karton'),(4,'Glas');
/*!40000 ALTER TABLE `materials` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passenger`
--

DROP TABLE IF EXISTS `passenger`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `passenger` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(255) DEFAULT NULL,
  `mname` varchar(255) DEFAULT NULL,
  `lname` varchar(255) DEFAULT NULL,
  `comment` text,
  `users_id` int(11) DEFAULT NULL,
  `date_added` date DEFAULT NULL,
  `date_changed` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passenger`
--

LOCK TABLES `passenger` WRITE;
/*!40000 ALTER TABLE `passenger` DISABLE KEYS */;
INSERT INTO `passenger` VALUES (1,'Tom','','Scholten',' ',9,'2015-12-03','2015-12-04'),(35,'Kah Kit','','Zheng','Kah Kit, de enig echte!',9,'2015-11-07','2015-11-07'),(36,'Jimmy','van','Wieringen','Jimmy jo Jimmy jo Jimmy yeeeh!',9,'2015-11-07','2015-11-07'),(37,'Alex','','Lisenkov','Alexus. Dankjewel.',9,'2015-11-07','2015-11-07'),(38,'Thomas','','Kamp','Mee naar Diemen-Zuid, want je bent een stukje fruit.',9,'2015-11-07','2015-11-07'),(39,'Tarik','','Kilic','Tarik met zijn pik.',9,'2015-11-07','2015-11-07'),(40,'Petra','','Scholten','',9,'2015-11-07','2015-11-07'),(41,'Richard','','Scholten','',9,'2015-11-07','2015-11-07'),(42,'Joelle','','Scholten','',9,'2015-11-07','2015-11-07'),(43,'Mitchell','','Scholten','',9,'2015-11-07','2015-11-07'),(44,'Jaap','van den ','Heuvel','',9,'2015-11-07','2015-11-07');
/*!40000 ALTER TABLE `passenger` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phone`
--

DROP TABLE IF EXISTS `phone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `phone` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `passenger_id` int(11) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phone`
--

LOCK TABLES `phone` WRITE;
/*!40000 ALTER TABLE `phone` DISABLE KEYS */;
INSERT INTO `phone` VALUES (7,35,''),(8,36,''),(9,37,''),(10,38,''),(11,39,''),(12,40,''),(13,41,''),(14,42,''),(15,43,''),(16,44,''),(17,44,'0659483722');
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `types`
--

LOCK TABLES `types` WRITE;
/*!40000 ALTER TABLE `types` DISABLE KEYS */;
INSERT INTO `types` VALUES (1,'Suitcase'),(2,'Carry-on'),(3,'Rucksack'),(4,'Electronica'),(5,'Clothes');
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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'broodjetom','115026','Tom','','Scholten','0648128767','12345',1,0,0,1),(2,'bob','-874524924','Thomas',NULL,'Kamp','0613245342','54321',0,1,0,2),(3,'drdick','101129530','Jimmy','van','Wieringen','0676543233','34567',0,0,1,3),(4,'alextosti','2996766','Alex',NULL,'Lisenkov','0687634522','96857',1,0,0,4),(5,'totaltarik','110131079','Tarik',NULL,'Kilic','0697867535','47386',1,0,0,5),(6,'blazingspirit420','717401928','Kah Kit',NULL,'Zheng','0614254786','15368',0,1,0,6),(7,'manager','3556498','Manager',NULL,'Test','0909090909','09090',0,1,0,4),(8,'admin','3556498','Admin','','Test','0909090909','09090',0,0,1,3),(9,'employee','3556498','Employee',NULL,'Test','0909090909','09090',1,0,0,5),(10,'DarrellWorld','-1338961692','Darrell','','Poleon','0695847362','39284',0,0,0,6),(11,'CorrieVD','-1354661432','Corrie','van den ','Heuvel','06978574636','39458',0,0,0,8);
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

-- Dump completed on 2015-12-07 20:38:10
