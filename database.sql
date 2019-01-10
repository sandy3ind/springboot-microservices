-- MySQL dump 10.13  Distrib 5.7.10, for Win64 (x86_64)
--
-- Host: localhost    Database: sample
-- ------------------------------------------------------
-- Server version	5.7.10-log

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
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categories` (
  `category_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `parent_category_id` bigint(20) DEFAULT NULL,
  `menu_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`category_id`),
  KEY `FK1ei1fuucpa95mdwncc0dpo69x` (`parent_category_id`),
  KEY `FKrsqti0wi1nu5x6w97bv29sd98` (`menu_id`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'Veg Main Course',NULL,1),(2,'Non-Veg Main Course',NULL,1),(3,'Dal',NULL,1),(4,'Briyanis',NULL,1),(5,'Rice',NULL,1),(6,'Indian Breads',NULL,1),(7,'Veg Startes',NULL,4),(8,'Chicken Startes',NULL,4),(9,'Fried Rice',NULL,4),(10,'Munich',NULL,9),(11,'Chaat',NULL,9),(12,'Chole Bhature',NULL,9);
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuisines`
--

DROP TABLE IF EXISTS `cuisines`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cuisines` (
  `cuisine_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cuisine_id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuisines`
--

LOCK TABLES `cuisines` WRITE;
/*!40000 ALTER TABLE `cuisines` DISABLE KEYS */;
INSERT INTO `cuisines` VALUES (1,'North Indian'),(2,'South Indian'),(3,'Chinese'),(4,'Continental'),(5,'Fast Food');
/*!40000 ALTER TABLE `cuisines` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customize_types`
--

DROP TABLE IF EXISTS `customize_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customize_types` (
  `customize_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`customize_type_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customize_types`
--

LOCK TABLES `customize_types` WRITE;
/*!40000 ALTER TABLE `customize_types` DISABLE KEYS */;
INSERT INTO `customize_types` VALUES (1,'Quantity');
/*!40000 ALTER TABLE `customize_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customize_types_customizes`
--

DROP TABLE IF EXISTS `customize_types_customizes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customize_types_customizes` (
  `customize_type_customize_type_id` int(11) NOT NULL,
  `customizes_customize_id` int(11) NOT NULL,
  `option_type_customize_type_id` int(11) NOT NULL,
  UNIQUE KEY `UK_62q0i6pvbvgoiuegivvqhfnsx` (`customizes_customize_id`),
  KEY `FKb8ujfrm3in44hl4h5ch5qw8nv` (`customize_type_customize_type_id`),
  KEY `FK5r5ole3a2uodif11hd8pfhle` (`option_type_customize_type_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customize_types_customizes`
--

LOCK TABLES `customize_types_customizes` WRITE;
/*!40000 ALTER TABLE `customize_types_customizes` DISABLE KEYS */;
/*!40000 ALTER TABLE `customize_types_customizes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customizes`
--

DROP TABLE IF EXISTS `customizes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customizes` (
  `customize_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `customize_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`customize_id`),
  KEY `FKbuy2hr3ifjdocvmp81bbg75vd` (`customize_type`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customizes`
--

LOCK TABLES `customizes` WRITE;
/*!40000 ALTER TABLE `customizes` DISABLE KEYS */;
/*!40000 ALTER TABLE `customizes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menus`
--

DROP TABLE IF EXISTS `menus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menus` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`menu_id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menus`
--

LOCK TABLES `menus` WRITE;
/*!40000 ALTER TABLE `menus` DISABLE KEYS */;
INSERT INTO `menus` VALUES (1,'Main Course'),(2,'Recommended'),(3,'Combos'),(4,'Chinese'),(5,'Thalis'),(6,'Indian'),(7,'Burgers'),(8,'Breads'),(9,'Quick Bites');
/*!40000 ALTER TABLE `menus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oauth_access_token`
--

DROP TABLE IF EXISTS `oauth_access_token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `oauth_access_token` (
  `token_id` varchar(256) DEFAULT NULL,
  `token` blob,
  `authentication_id` varchar(256) DEFAULT NULL,
  `user_name` varchar(256) DEFAULT NULL,
  `client_id` varchar(256) DEFAULT NULL,
  `authentication` blob,
  `refresh_token` varchar(256) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oauth_access_token`
--

LOCK TABLES `oauth_access_token` WRITE;
/*!40000 ALTER TABLE `oauth_access_token` DISABLE KEYS */;
/*!40000 ALTER TABLE `oauth_access_token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oauth_approvals`
--

DROP TABLE IF EXISTS `oauth_approvals`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `oauth_approvals` (
  `userId` varchar(255) DEFAULT NULL,
  `clientId` varchar(255) DEFAULT NULL,
  `scope` varchar(255) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `expiresAt` datetime DEFAULT NULL,
  `lastModifiedAt` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oauth_approvals`
--

LOCK TABLES `oauth_approvals` WRITE;
/*!40000 ALTER TABLE `oauth_approvals` DISABLE KEYS */;
/*!40000 ALTER TABLE `oauth_approvals` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oauth_client_details`
--

DROP TABLE IF EXISTS `oauth_client_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `oauth_client_details` (
  `client_id` varchar(255) NOT NULL,
  `resource_ids` varchar(255) DEFAULT NULL,
  `client_secret` varchar(255) DEFAULT NULL,
  `scope` varchar(255) DEFAULT NULL,
  `authorized_grant_types` varchar(255) DEFAULT NULL,
  `web_server_redirect_uri` varchar(255) DEFAULT NULL,
  `authorities` varchar(255) DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT NULL,
  `refresh_token_validity` int(11) DEFAULT NULL,
  `additional_information` varchar(4096) DEFAULT NULL,
  `autoapprove` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oauth_client_details`
--

LOCK TABLES `oauth_client_details` WRITE;
/*!40000 ALTER TABLE `oauth_client_details` DISABLE KEYS */;
INSERT INTO `oauth_client_details` VALUES ('customer',NULL,'{noop}secret','write','authorization_code,password,refresh_token,implicit',NULL,NULL,9000,NULL,'{}',NULL),('delivery-agent',NULL,'{noop}secret','write','authorization_code,password,refresh_token,implicit',NULL,NULL,9000,NULL,'{}',NULL),('restaurant',NULL,'{noop}secret','write','authorization_code,password,refresh_token,implicit',NULL,NULL,9000,NULL,'{}',NULL);
/*!40000 ALTER TABLE `oauth_client_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oauth_client_token`
--

DROP TABLE IF EXISTS `oauth_client_token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `oauth_client_token` (
  `token_id` varchar(255) DEFAULT NULL,
  `token` mediumblob,
  `authentication_id` varchar(255) NOT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `client_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`authentication_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oauth_client_token`
--

LOCK TABLES `oauth_client_token` WRITE;
/*!40000 ALTER TABLE `oauth_client_token` DISABLE KEYS */;
/*!40000 ALTER TABLE `oauth_client_token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oauth_code`
--

DROP TABLE IF EXISTS `oauth_code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `oauth_code` (
  `code` varchar(255) DEFAULT NULL,
  `authentication` mediumblob
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oauth_code`
--

LOCK TABLES `oauth_code` WRITE;
/*!40000 ALTER TABLE `oauth_code` DISABLE KEYS */;
/*!40000 ALTER TABLE `oauth_code` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oauth_refresh_token`
--

DROP TABLE IF EXISTS `oauth_refresh_token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `oauth_refresh_token` (
  `token_id` varchar(256) DEFAULT NULL,
  `token` blob,
  `authentication` blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oauth_refresh_token`
--

LOCK TABLES `oauth_refresh_token` WRITE;
/*!40000 ALTER TABLE `oauth_refresh_token` DISABLE KEYS */;
/*!40000 ALTER TABLE `oauth_refresh_token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `offer_types`
--

DROP TABLE IF EXISTS `offer_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `offer_types` (
  `offer_type_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`offer_type_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `offer_types`
--

LOCK TABLES `offer_types` WRITE;
/*!40000 ALTER TABLE `offer_types` DISABLE KEYS */;
INSERT INTO `offer_types` VALUES (1,'Combo Offer'),(2,'On all orders'),(3,'Free Deliver'),(4,'On orders above');
/*!40000 ALTER TABLE `offer_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `option_types`
--

DROP TABLE IF EXISTS `option_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `option_types` (
  `option_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`option_type_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `option_types`
--

LOCK TABLES `option_types` WRITE;
/*!40000 ALTER TABLE `option_types` DISABLE KEYS */;
INSERT INTO `option_types` VALUES (1,'Quantity'),(2,'Size');
/*!40000 ALTER TABLE `option_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `option_types_options`
--

DROP TABLE IF EXISTS `option_types_options`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `option_types_options` (
  `option_type_option_type_id` int(11) NOT NULL,
  `options_option_id` int(11) NOT NULL,
  UNIQUE KEY `UK_q02hc6skty1mq8pbtnp0dalyd` (`options_option_id`),
  KEY `FKhgq040l3ckcv04dhmme3shmoo` (`option_type_option_type_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `option_types_options`
--

LOCK TABLES `option_types_options` WRITE;
/*!40000 ALTER TABLE `option_types_options` DISABLE KEYS */;
/*!40000 ALTER TABLE `option_types_options` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `options`
--

DROP TABLE IF EXISTS `options`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `options` (
  `option_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `option_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`option_id`),
  KEY `FKmfwxc15cnrhu5y3k2f4ki8ak5` (`option_type`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `options`
--

LOCK TABLES `options` WRITE;
/*!40000 ALTER TABLE `options` DISABLE KEYS */;
INSERT INTO `options` VALUES (1,'Half',1),(2,'Full',1),(3,'Regular size',2),(4,'Medium size',2),(5,'Large size',2);
/*!40000 ALTER TABLE `options` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parent_categories`
--

DROP TABLE IF EXISTS `parent_categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parent_categories` (
  `category_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parent_categories`
--

LOCK TABLES `parent_categories` WRITE;
/*!40000 ALTER TABLE `parent_categories` DISABLE KEYS */;
INSERT INTO `parent_categories` VALUES (1,'dddd');
/*!40000 ALTER TABLE `parent_categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurant_categories`
--

DROP TABLE IF EXISTS `restaurant_categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `restaurant_categories` (
  `restaurant_category_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_id` bigint(20) DEFAULT NULL,
  `restaurant_menu_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`restaurant_category_id`),
  KEY `FK4kg1d5bcfdt8fn2qh16ptrnfm` (`category_id`),
  KEY `FKkhdsv1oukcawemtiovbyb9ejl` (`restaurant_menu_id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurant_categories`
--

LOCK TABLES `restaurant_categories` WRITE;
/*!40000 ALTER TABLE `restaurant_categories` DISABLE KEYS */;
INSERT INTO `restaurant_categories` VALUES (1,1,1),(2,2,1),(3,3,1),(4,10,6),(5,11,6),(6,12,6);
/*!40000 ALTER TABLE `restaurant_categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurant_food_options`
--

DROP TABLE IF EXISTS `restaurant_food_options`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `restaurant_food_options` (
  `restaurant_food_option_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `discount` float DEFAULT NULL,
  `price` float DEFAULT NULL,
  `restaurant_food_id` bigint(20) DEFAULT NULL,
  `restaurant_option_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`restaurant_food_option_id`),
  KEY `FKbicrv4sdn6ak2khow8fkemnet` (`restaurant_food_id`),
  KEY `FKdn0ajrvdhpct74cxuvu0o0mce` (`restaurant_option_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurant_food_options`
--

LOCK TABLES `restaurant_food_options` WRITE;
/*!40000 ALTER TABLE `restaurant_food_options` DISABLE KEYS */;
INSERT INTO `restaurant_food_options` VALUES (1,10,100,1,1),(2,10,150,1,2);
/*!40000 ALTER TABLE `restaurant_food_options` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurant_foods`
--

DROP TABLE IF EXISTS `restaurant_foods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `restaurant_foods` (
  `restaurant_food_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `restaurant_category_id` bigint(20) DEFAULT NULL,
  `restaurant_menu_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`restaurant_food_id`),
  KEY `FKom57go5i8kqdddridn6g933wu` (`restaurant_category_id`),
  KEY `FK228ute1iyitu0ml7cvgeejojd` (`restaurant_menu_id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurant_foods`
--

LOCK TABLES `restaurant_foods` WRITE;
/*!40000 ALTER TABLE `restaurant_foods` DISABLE KEYS */;
INSERT INTO `restaurant_foods` VALUES (1,'Shahi Paneer',1,2),(2,'Chiili Paneer',1,2),(3,'Kadhai Paneer',1,2),(4,'Kadhai Chicken',2,2),(5,'Butter Chicken',2,2),(6,'Veg Thali',NULL,5),(7,'Non Veg Thali',NULL,5),(8,'Spl. Non Veg Thali',NULL,5),(9,'Dal + Rice',NULL,3),(10,'Kadhai + Rice',NULL,3);
/*!40000 ALTER TABLE `restaurant_foods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurant_menus`
--

DROP TABLE IF EXISTS `restaurant_menus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `restaurant_menus` (
  `restaurant_menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `menu_id` bigint(20) DEFAULT NULL,
  `restaurant_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`restaurant_menu_id`),
  KEY `FKtmc335lpuxbgtt2xc6ocl8tdx` (`menu_id`),
  KEY `FKpdk398ti12pov57x5to24kskq` (`restaurant_id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurant_menus`
--

LOCK TABLES `restaurant_menus` WRITE;
/*!40000 ALTER TABLE `restaurant_menus` DISABLE KEYS */;
INSERT INTO `restaurant_menus` VALUES (1,1,1),(2,2,1),(3,3,1),(4,5,1),(5,7,1),(6,9,1);
/*!40000 ALTER TABLE `restaurant_menus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurant_offers`
--

DROP TABLE IF EXISTS `restaurant_offers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `restaurant_offers` (
  `restaurant_offer_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `above_price` float DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `expired_date` datetime DEFAULT NULL,
  `is_valid` bit(1) DEFAULT NULL,
  `percentage` float DEFAULT NULL,
  `offer_type_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`restaurant_offer_id`),
  KEY `FKdpf4vqqecu0wtbqi5821o1mub` (`offer_type_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurant_offers`
--

LOCK TABLES `restaurant_offers` WRITE;
/*!40000 ALTER TABLE `restaurant_offers` DISABLE KEYS */;
INSERT INTO `restaurant_offers` VALUES (1,0,NULL,NULL,'\0',20,1),(2,300,NULL,NULL,'\0',30,4);
/*!40000 ALTER TABLE `restaurant_offers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurant_option_types`
--

DROP TABLE IF EXISTS `restaurant_option_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `restaurant_option_types` (
  `restaurant_option_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `option_type_id` bigint(20) DEFAULT NULL,
  `restaurant_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`restaurant_option_type_id`),
  KEY `FKlgbnpv3en0pt3h1beq8v7dila` (`option_type_id`),
  KEY `FK3j2do2sqxawa147ls8g60ange` (`restaurant_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurant_option_types`
--

LOCK TABLES `restaurant_option_types` WRITE;
/*!40000 ALTER TABLE `restaurant_option_types` DISABLE KEYS */;
INSERT INTO `restaurant_option_types` VALUES (1,1,1);
/*!40000 ALTER TABLE `restaurant_option_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurant_options`
--

DROP TABLE IF EXISTS `restaurant_options`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `restaurant_options` (
  `restaurant_option_id` int(11) NOT NULL AUTO_INCREMENT,
  `option_id` bigint(20) DEFAULT NULL,
  `restaurant_option_type_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`restaurant_option_id`),
  KEY `FKem62wfytr38xuvb6n50h06wf7` (`option_id`),
  KEY `FK9o48e34v5lh70wpq38ejn5gsf` (`restaurant_option_type_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurant_options`
--

LOCK TABLES `restaurant_options` WRITE;
/*!40000 ALTER TABLE `restaurant_options` DISABLE KEYS */;
INSERT INTO `restaurant_options` VALUES (1,1,1),(2,2,1);
/*!40000 ALTER TABLE `restaurant_options` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurants`
--

DROP TABLE IF EXISTS `restaurants`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `restaurants` (
  `restaurant_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `price_for_two` float DEFAULT NULL,
  `rating` float DEFAULT NULL,
  PRIMARY KEY (`restaurant_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurants`
--

LOCK TABLES `restaurants` WRITE;
/*!40000 ALTER TABLE `restaurants` DISABLE KEYS */;
INSERT INTO `restaurants` VALUES (1,'erererere ','2019-01-08 16:01:44',NULL,30.712463,76.845615,'My Restaurant',0,0);
/*!40000 ALTER TABLE `restaurants` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurants_cuisines`
--

DROP TABLE IF EXISTS `restaurants_cuisines`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `restaurants_cuisines` (
  `restaurant_id` bigint(20) NOT NULL,
  `cuisine_id` bigint(20) NOT NULL,
  KEY `FKssp2uu548yv1te3yspuxdj99d` (`cuisine_id`),
  KEY `FKdk1y2e7d8s778bhtxden294fn` (`restaurant_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurants_cuisines`
--

LOCK TABLES `restaurants_cuisines` WRITE;
/*!40000 ALTER TABLE `restaurants_cuisines` DISABLE KEYS */;
INSERT INTO `restaurants_cuisines` VALUES (1,1),(1,2),(1,3),(1,4),(1,5);
/*!40000 ALTER TABLE `restaurants_cuisines` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roles` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'CUSTOMER'),(2,'RESTAURANT'),(3,'DELIVERY_AGENT'),(4,'DELIVERY_AGENCY');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `inserted_time` datetime DEFAULT NULL,
  `modified_time` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'ddd@g.com',NULL,NULL,'dddee','eeeee','abc1111111'),(2,'ddd8@g.com','2018-11-30 17:41:11',NULL,'dddee','eeeeew','abc11111121');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_roles`
--

DROP TABLE IF EXISTS `users_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` int(11) NOT NULL,
  KEY `FKj6m8fwv7oqv74fcehir1a9ffy` (`role_id`),
  KEY `FK2o0jvgh89lemvvo17cbqvdxaa` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_roles`
--

LOCK TABLES `users_roles` WRITE;
/*!40000 ALTER TABLE `users_roles` DISABLE KEYS */;
INSERT INTO `users_roles` VALUES (2,1);
/*!40000 ALTER TABLE `users_roles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-10 18:32:01
