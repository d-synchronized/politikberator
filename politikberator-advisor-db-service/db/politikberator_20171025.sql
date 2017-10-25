-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: politikberator
-- ------------------------------------------------------
-- Server version	5.6.26-log

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
  `address_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `house_name` varchar(255) DEFAULT NULL,
  `house_number` varchar(255) DEFAULT NULL,
  `locality` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `zipcode` varchar(255) DEFAULT NULL,
  `city_id` bigint(20) DEFAULT NULL,
  `state_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`address_id`),
  KEY `FKpo044ng5x4gynb291cv24vtea` (`city_id`),
  KEY `FK4cx5jughttw4h3qfxrcitbtxl` (`state_id`),
  CONSTRAINT `FK4cx5jughttw4h3qfxrcitbtxl` FOREIGN KEY (`state_id`) REFERENCES `state` (`lookup_id`),
  CONSTRAINT `FKpo044ng5x4gynb291cv24vtea` FOREIGN KEY (`city_id`) REFERENCES `city` (`lookup_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (3,'string','string','string','string','string',1001,1001);
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `advisory_enquiry`
--

DROP TABLE IF EXISTS `advisory_enquiry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `advisory_enquiry` (
  `advisory_enquiry_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cover_amount` double NOT NULL,
  `enquiry_number` varchar(255) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`advisory_enquiry_id`),
  UNIQUE KEY `UK_hy1k74j7pdk7bmp12887tshfv` (`enquiry_number`),
  KEY `advisory_enquiry_enquiry_number_idx` (`enquiry_number`),
  KEY `FKe65gl1iba6r31cmovdhimyvyg` (`user_id`),
  CONSTRAINT `FKe65gl1iba6r31cmovdhimyvyg` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `advisory_enquiry`
--

LOCK TABLES `advisory_enquiry` WRITE;
/*!40000 ALTER TABLE `advisory_enquiry` DISABLE KEYS */;
INSERT INTO `advisory_enquiry` VALUES (1,10000000,'0cc891ff-c512-4052-8198-a8caa0bd3c08',7);
/*!40000 ALTER TABLE `advisory_enquiry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `city` (
  `city_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `lookup_id` bigint(20) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`city_id`),
  UNIQUE KEY `UK_e8rheme78bl9adq7g9h51tiqw` (`lookup_id`),
  KEY `city_lookup_id_idx` (`lookup_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,1001,'Gurgaon'),(2,1002,'New Delhi');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contact_detail`
--

DROP TABLE IF EXISTS `contact_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contact_detail` (
  `contact_detail_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fax` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `primary_email` varchar(255) NOT NULL,
  `secondary_email` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`contact_detail_id`),
  UNIQUE KEY `UK_47jvio878i0eyphwugfndq3r8` (`primary_email`),
  KEY `contact_detail_primary_email_idx` (`primary_email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact_detail`
--

LOCK TABLES `contact_detail` WRITE;
/*!40000 ALTER TABLE `contact_detail` DISABLE KEYS */;
INSERT INTO `contact_detail` VALUES (3,'string','string','string','string','string');
/*!40000 ALTER TABLE `contact_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `occupation`
--

DROP TABLE IF EXISTS `occupation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `occupation` (
  `occupation_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `from_date` datetime DEFAULT NULL,
  `organization` varchar(255) DEFAULT NULL,
  `is_permanent` bit(1) DEFAULT NULL,
  `salary` double DEFAULT NULL,
  `to_date` datetime DEFAULT NULL,
  PRIMARY KEY (`occupation_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `occupation`
--

LOCK TABLES `occupation` WRITE;
/*!40000 ALTER TABLE `occupation` DISABLE KEYS */;
INSERT INTO `occupation` VALUES (7,'2017-10-12 17:53:30','string','',100000,'2017-10-12 17:53:30');
/*!40000 ALTER TABLE `occupation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `policy`
--

DROP TABLE IF EXISTS `policy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `policy` (
  `policy_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) NOT NULL,
  `policy_name` varchar(255) NOT NULL,
  `policy_nunber` varchar(255) NOT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`policy_id`),
  UNIQUE KEY `UK_q22a266qas8obf9s84ohgfseq` (`policy_nunber`),
  KEY `policy_policy_nunber_idx` (`policy_nunber`),
  KEY `FKov9wba1wej5al77llh2wy9043` (`product_id`),
  CONSTRAINT `FKov9wba1wej5al77llh2wy9043` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `policy`
--

LOCK TABLES `policy` WRITE;
/*!40000 ALTER TABLE `policy` DISABLE KEYS */;
/*!40000 ALTER TABLE `policy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `product_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) NOT NULL,
  `product_number` varchar(255) NOT NULL,
  PRIMARY KEY (`product_id`),
  UNIQUE KEY `UK_o9lr7abbchek72c2xu8x0g884` (`product_number`),
  KEY `product_product_number_idx` (`product_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `state`
--

DROP TABLE IF EXISTS `state`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `state` (
  `state_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `lookup_id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`state_id`),
  UNIQUE KEY `UK_lmcbymt0os69pu0s9r5jhaq93` (`lookup_id`),
  KEY `state_lookup_id_idx` (`lookup_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `state`
--

LOCK TABLES `state` WRITE;
/*!40000 ALTER TABLE `state` DISABLE KEYS */;
INSERT INTO `state` VALUES (1,1001,'Haryana'),(2,1002,'Delhi');
/*!40000 ALTER TABLE `state` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `blood_group_type` varchar(255) DEFAULT NULL,
  `date_of_birth` datetime DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `is_smoker` bit(1) DEFAULT NULL,
  `occupation_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`),
  KEY `FKlk6hcoqfq70afuxb20ro7nc9b` (`occupation_id`),
  CONSTRAINT `FKlk6hcoqfq70afuxb20ro7nc9b` FOREIGN KEY (`occupation_id`) REFERENCES `occupation` (`occupation_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (7,'A_PLUS','2017-10-12 17:53:30','string','string','',7);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_address_detail`
--

DROP TABLE IF EXISTS `user_address_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_address_detail` (
  `user_id` bigint(20) NOT NULL,
  `address_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_30vuyx6kbkrxmxovrued7cey2` (`address_id`),
  KEY `FKe0ae0cg1gaj4x7c7tm1d03aty` (`user_id`),
  CONSTRAINT `FK8w4uxfewajdslckt67rkfrhby` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`),
  CONSTRAINT `FKe0ae0cg1gaj4x7c7tm1d03aty` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_address_detail`
--

LOCK TABLES `user_address_detail` WRITE;
/*!40000 ALTER TABLE `user_address_detail` DISABLE KEYS */;
INSERT INTO `user_address_detail` VALUES (7,3);
/*!40000 ALTER TABLE `user_address_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_contact_detail`
--

DROP TABLE IF EXISTS `user_contact_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_contact_detail` (
  `user_id` bigint(20) NOT NULL,
  `contact_detail_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_mtwnwdf1q8h6c5k4lkshuxub1` (`contact_detail_id`),
  KEY `FK3um8rngltxkqh4154f0fj1341` (`user_id`),
  CONSTRAINT `FK3um8rngltxkqh4154f0fj1341` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FK5gkxbl96c08ualdchek2kliuh` FOREIGN KEY (`contact_detail_id`) REFERENCES `contact_detail` (`contact_detail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_contact_detail`
--

LOCK TABLES `user_contact_detail` WRITE;
/*!40000 ALTER TABLE `user_contact_detail` DISABLE KEYS */;
INSERT INTO `user_contact_detail` VALUES (7,3);
/*!40000 ALTER TABLE `user_contact_detail` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-25 18:37:38
