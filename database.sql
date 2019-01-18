-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.10-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for sample
DROP DATABASE IF EXISTS `sample`;
CREATE DATABASE IF NOT EXISTS `sample` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `sample`;

-- Dumping structure for table sample.add_ons
DROP TABLE IF EXISTS `add_ons`;
CREATE TABLE IF NOT EXISTS `add_ons` (
  `add_on_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`add_on_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dumping data for table sample.add_ons: 4 rows
DELETE FROM `add_ons`;
/*!40000 ALTER TABLE `add_ons` DISABLE KEYS */;
INSERT INTO `add_ons` (`add_on_id`, `name`) VALUES
	(1, 'Choice Of Bread'),
	(2, 'Chees and Toasted'),
	(3, 'Choice of Souce'),
	(4, 'Choice of Vegetables');
/*!40000 ALTER TABLE `add_ons` ENABLE KEYS */;

-- Dumping structure for table sample.add_on_items
DROP TABLE IF EXISTS `add_on_items`;
CREATE TABLE IF NOT EXISTS `add_on_items` (
  `add_on_item_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `add_on_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`add_on_item_id`),
  KEY `FKakuw7cn1u7lnwdjvyd2kmtso1` (`add_on_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dumping data for table sample.add_on_items: 4 rows
DELETE FROM `add_on_items`;
/*!40000 ALTER TABLE `add_on_items` DISABLE KEYS */;
INSERT INTO `add_on_items` (`add_on_item_id`, `name`, `add_on_id`) VALUES
	(1, 'Multigrain Bread', 1),
	(2, 'Italian Bread', 1),
	(3, 'Plain Bread', 2),
	(4, 'Toasted Bread', 2);
/*!40000 ALTER TABLE `add_on_items` ENABLE KEYS */;

-- Dumping structure for table sample.categories
DROP TABLE IF EXISTS `categories`;
CREATE TABLE IF NOT EXISTS `categories` (
  `category_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `parent_category_id` bigint(20) DEFAULT NULL,
  `menu_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`category_id`),
  KEY `FK1ei1fuucpa95mdwncc0dpo69x` (`parent_category_id`),
  KEY `FKrsqti0wi1nu5x6w97bv29sd98` (`menu_id`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- Dumping data for table sample.categories: 12 rows
DELETE FROM `categories`;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` (`category_id`, `name`, `parent_category_id`, `menu_id`) VALUES
	(1, 'Veg Main Course', NULL, 1),
	(2, 'Non-Veg Main Course', NULL, 1),
	(3, 'Dal', NULL, 1),
	(4, 'Briyanis', NULL, 1),
	(5, 'Rice', NULL, 1),
	(6, 'Indian Breads', NULL, 1),
	(7, 'Veg Startes', NULL, 4),
	(8, 'Chicken Startes', NULL, 4),
	(9, 'Fried Rice', NULL, 4),
	(10, 'Munich', NULL, 9),
	(11, 'Chaat', NULL, 9),
	(12, 'Chole Bhature', NULL, 9);
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;

-- Dumping structure for table sample.choices
DROP TABLE IF EXISTS `choices`;
CREATE TABLE IF NOT EXISTS `choices` (
  `choice_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`choice_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table sample.choices: 1 rows
DELETE FROM `choices`;
/*!40000 ALTER TABLE `choices` DISABLE KEYS */;
INSERT INTO `choices` (`choice_id`, `name`) VALUES
	(1, 'Choice of Bread');
/*!40000 ALTER TABLE `choices` ENABLE KEYS */;

-- Dumping structure for table sample.choice_items
DROP TABLE IF EXISTS `choice_items`;
CREATE TABLE IF NOT EXISTS `choice_items` (
  `choice_item_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `choice_id` bigint(20) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`choice_item_id`),
  KEY `FK41fllpsvowetnwt6ruf82e2jb` (`choice_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table sample.choice_items: 2 rows
DELETE FROM `choice_items`;
/*!40000 ALTER TABLE `choice_items` DISABLE KEYS */;
INSERT INTO `choice_items` (`choice_item_id`, `choice_id`, `name`) VALUES
	(1, 1, 'Tandoori'),
	(2, 1, 'Tawa');
/*!40000 ALTER TABLE `choice_items` ENABLE KEYS */;

-- Dumping structure for table sample.cuisines
DROP TABLE IF EXISTS `cuisines`;
CREATE TABLE IF NOT EXISTS `cuisines` (
  `cuisine_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cuisine_id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Dumping data for table sample.cuisines: 5 rows
DELETE FROM `cuisines`;
/*!40000 ALTER TABLE `cuisines` DISABLE KEYS */;
INSERT INTO `cuisines` (`cuisine_id`, `name`) VALUES
	(1, 'North Indian'),
	(2, 'South Indian'),
	(3, 'Chinese'),
	(4, 'Continental'),
	(5, 'Fast Food');
/*!40000 ALTER TABLE `cuisines` ENABLE KEYS */;

-- Dumping structure for table sample.customizes
DROP TABLE IF EXISTS `customizes`;
CREATE TABLE IF NOT EXISTS `customizes` (
  `customize_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `customize_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`customize_id`),
  KEY `FKbuy2hr3ifjdocvmp81bbg75vd` (`customize_type`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- Dumping data for table sample.customizes: 0 rows
DELETE FROM `customizes`;
/*!40000 ALTER TABLE `customizes` DISABLE KEYS */;
/*!40000 ALTER TABLE `customizes` ENABLE KEYS */;

-- Dumping structure for table sample.customize_types
DROP TABLE IF EXISTS `customize_types`;
CREATE TABLE IF NOT EXISTS `customize_types` (
  `customize_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`customize_type_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table sample.customize_types: 1 rows
DELETE FROM `customize_types`;
/*!40000 ALTER TABLE `customize_types` DISABLE KEYS */;
INSERT INTO `customize_types` (`customize_type_id`, `name`) VALUES
	(1, 'Quantity');
/*!40000 ALTER TABLE `customize_types` ENABLE KEYS */;

-- Dumping structure for table sample.customize_types_customizes
DROP TABLE IF EXISTS `customize_types_customizes`;
CREATE TABLE IF NOT EXISTS `customize_types_customizes` (
  `customize_type_customize_type_id` int(11) NOT NULL,
  `customizes_customize_id` int(11) NOT NULL,
  `option_type_customize_type_id` int(11) NOT NULL,
  UNIQUE KEY `UK_62q0i6pvbvgoiuegivvqhfnsx` (`customizes_customize_id`),
  KEY `FKb8ujfrm3in44hl4h5ch5qw8nv` (`customize_type_customize_type_id`),
  KEY `FK5r5ole3a2uodif11hd8pfhle` (`option_type_customize_type_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- Dumping data for table sample.customize_types_customizes: 0 rows
DELETE FROM `customize_types_customizes`;
/*!40000 ALTER TABLE `customize_types_customizes` DISABLE KEYS */;
/*!40000 ALTER TABLE `customize_types_customizes` ENABLE KEYS */;

-- Dumping structure for table sample.menus
DROP TABLE IF EXISTS `menus`;
CREATE TABLE IF NOT EXISTS `menus` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`menu_id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- Dumping data for table sample.menus: 9 rows
DELETE FROM `menus`;
/*!40000 ALTER TABLE `menus` DISABLE KEYS */;
INSERT INTO `menus` (`menu_id`, `name`) VALUES
	(1, 'Main Course'),
	(2, 'Recommended'),
	(3, 'Combos'),
	(4, 'Chinese'),
	(5, 'Thalis'),
	(6, 'Indian'),
	(7, 'Burgers'),
	(8, 'Breads'),
	(9, 'Quick Bites');
/*!40000 ALTER TABLE `menus` ENABLE KEYS */;

-- Dumping structure for table sample.oauth_access_token
DROP TABLE IF EXISTS `oauth_access_token`;
CREATE TABLE IF NOT EXISTS `oauth_access_token` (
  `token_id` varchar(256) DEFAULT NULL,
  `token` blob,
  `authentication_id` varchar(256) DEFAULT NULL,
  `user_name` varchar(256) DEFAULT NULL,
  `client_id` varchar(256) DEFAULT NULL,
  `authentication` blob,
  `refresh_token` varchar(256) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table sample.oauth_access_token: ~0 rows (approximately)
DELETE FROM `oauth_access_token`;
/*!40000 ALTER TABLE `oauth_access_token` DISABLE KEYS */;
/*!40000 ALTER TABLE `oauth_access_token` ENABLE KEYS */;

-- Dumping structure for table sample.oauth_approvals
DROP TABLE IF EXISTS `oauth_approvals`;
CREATE TABLE IF NOT EXISTS `oauth_approvals` (
  `userId` varchar(255) DEFAULT NULL,
  `clientId` varchar(255) DEFAULT NULL,
  `scope` varchar(255) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `expiresAt` datetime DEFAULT NULL,
  `lastModifiedAt` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table sample.oauth_approvals: ~0 rows (approximately)
DELETE FROM `oauth_approvals`;
/*!40000 ALTER TABLE `oauth_approvals` DISABLE KEYS */;
/*!40000 ALTER TABLE `oauth_approvals` ENABLE KEYS */;

-- Dumping structure for table sample.oauth_client_details
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE IF NOT EXISTS `oauth_client_details` (
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

-- Dumping data for table sample.oauth_client_details: ~2 rows (approximately)
DELETE FROM `oauth_client_details`;
/*!40000 ALTER TABLE `oauth_client_details` DISABLE KEYS */;
INSERT INTO `oauth_client_details` (`client_id`, `resource_ids`, `client_secret`, `scope`, `authorized_grant_types`, `web_server_redirect_uri`, `authorities`, `access_token_validity`, `refresh_token_validity`, `additional_information`, `autoapprove`) VALUES
	('customer', NULL, '{noop}secret', 'write', 'authorization_code,password,refresh_token,implicit', NULL, NULL, 9000, NULL, '{}', NULL),
	('delivery-agent', NULL, '{noop}secret', 'write', 'authorization_code,password,refresh_token,implicit', NULL, NULL, 9000, NULL, '{}', NULL),
	('restaurant', NULL, '{noop}secret', 'write', 'authorization_code,password,refresh_token,implicit', NULL, NULL, 9000, NULL, '{}', NULL);
/*!40000 ALTER TABLE `oauth_client_details` ENABLE KEYS */;

-- Dumping structure for table sample.oauth_client_token
DROP TABLE IF EXISTS `oauth_client_token`;
CREATE TABLE IF NOT EXISTS `oauth_client_token` (
  `token_id` varchar(255) DEFAULT NULL,
  `token` mediumblob,
  `authentication_id` varchar(255) NOT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `client_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`authentication_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table sample.oauth_client_token: ~0 rows (approximately)
DELETE FROM `oauth_client_token`;
/*!40000 ALTER TABLE `oauth_client_token` DISABLE KEYS */;
/*!40000 ALTER TABLE `oauth_client_token` ENABLE KEYS */;

-- Dumping structure for table sample.oauth_code
DROP TABLE IF EXISTS `oauth_code`;
CREATE TABLE IF NOT EXISTS `oauth_code` (
  `code` varchar(255) DEFAULT NULL,
  `authentication` mediumblob
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table sample.oauth_code: ~0 rows (approximately)
DELETE FROM `oauth_code`;
/*!40000 ALTER TABLE `oauth_code` DISABLE KEYS */;
/*!40000 ALTER TABLE `oauth_code` ENABLE KEYS */;

-- Dumping structure for table sample.oauth_refresh_token
DROP TABLE IF EXISTS `oauth_refresh_token`;
CREATE TABLE IF NOT EXISTS `oauth_refresh_token` (
  `token_id` varchar(256) DEFAULT NULL,
  `token` blob,
  `authentication` blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table sample.oauth_refresh_token: ~0 rows (approximately)
DELETE FROM `oauth_refresh_token`;
/*!40000 ALTER TABLE `oauth_refresh_token` DISABLE KEYS */;
/*!40000 ALTER TABLE `oauth_refresh_token` ENABLE KEYS */;

-- Dumping structure for table sample.offer_types
DROP TABLE IF EXISTS `offer_types`;
CREATE TABLE IF NOT EXISTS `offer_types` (
  `offer_type_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`offer_type_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dumping data for table sample.offer_types: 4 rows
DELETE FROM `offer_types`;
/*!40000 ALTER TABLE `offer_types` DISABLE KEYS */;
INSERT INTO `offer_types` (`offer_type_id`, `name`) VALUES
	(1, 'Combo Offer'),
	(2, 'On all orders'),
	(3, 'Free Deliver'),
	(4, 'On orders above');
/*!40000 ALTER TABLE `offer_types` ENABLE KEYS */;

-- Dumping structure for table sample.options
DROP TABLE IF EXISTS `options`;
CREATE TABLE IF NOT EXISTS `options` (
  `option_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `option_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`option_id`),
  KEY `FKmfwxc15cnrhu5y3k2f4ki8ak5` (`option_type`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Dumping data for table sample.options: 5 rows
DELETE FROM `options`;
/*!40000 ALTER TABLE `options` DISABLE KEYS */;
INSERT INTO `options` (`option_id`, `name`, `option_type`) VALUES
	(1, 'Half', 1),
	(2, 'Full', 1),
	(3, 'Regular size', 2),
	(4, 'Medium size', 2),
	(5, 'Large size', 2);
/*!40000 ALTER TABLE `options` ENABLE KEYS */;

-- Dumping structure for table sample.option_types
DROP TABLE IF EXISTS `option_types`;
CREATE TABLE IF NOT EXISTS `option_types` (
  `option_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`option_type_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table sample.option_types: 2 rows
DELETE FROM `option_types`;
/*!40000 ALTER TABLE `option_types` DISABLE KEYS */;
INSERT INTO `option_types` (`option_type_id`, `name`) VALUES
	(1, 'Quantity'),
	(2, 'Size');
/*!40000 ALTER TABLE `option_types` ENABLE KEYS */;

-- Dumping structure for table sample.option_types_options
DROP TABLE IF EXISTS `option_types_options`;
CREATE TABLE IF NOT EXISTS `option_types_options` (
  `option_type_option_type_id` int(11) NOT NULL,
  `options_option_id` int(11) NOT NULL,
  UNIQUE KEY `UK_q02hc6skty1mq8pbtnp0dalyd` (`options_option_id`),
  KEY `FKhgq040l3ckcv04dhmme3shmoo` (`option_type_option_type_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- Dumping data for table sample.option_types_options: 0 rows
DELETE FROM `option_types_options`;
/*!40000 ALTER TABLE `option_types_options` DISABLE KEYS */;
/*!40000 ALTER TABLE `option_types_options` ENABLE KEYS */;

-- Dumping structure for table sample.parent_categories
DROP TABLE IF EXISTS `parent_categories`;
CREATE TABLE IF NOT EXISTS `parent_categories` (
  `category_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table sample.parent_categories: 1 rows
DELETE FROM `parent_categories`;
/*!40000 ALTER TABLE `parent_categories` DISABLE KEYS */;
INSERT INTO `parent_categories` (`category_id`, `name`) VALUES
	(1, 'dddd');
/*!40000 ALTER TABLE `parent_categories` ENABLE KEYS */;

-- Dumping structure for table sample.restaurants
DROP TABLE IF EXISTS `restaurants`;
CREATE TABLE IF NOT EXISTS `restaurants` (
  `restaurant_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `price_for_two` float DEFAULT NULL,
  `rating` float DEFAULT NULL,
  `delivery_time` int(11) NOT NULL,
  `packaging_charge` float DEFAULT NULL,
  PRIMARY KEY (`restaurant_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table sample.restaurants: 1 rows
DELETE FROM `restaurants`;
/*!40000 ALTER TABLE `restaurants` DISABLE KEYS */;
INSERT INTO `restaurants` (`restaurant_id`, `address`, `created_date`, `description`, `latitude`, `longitude`, `name`, `price_for_two`, `rating`, `delivery_time`, `packaging_charge`) VALUES
	(1, 'erererere ', '2019-01-08 16:01:44', NULL, 30.712463, 76.845615, 'My Restaurant', 0, 0, 0, 0);
/*!40000 ALTER TABLE `restaurants` ENABLE KEYS */;

-- Dumping structure for table sample.restaurants_cuisines
DROP TABLE IF EXISTS `restaurants_cuisines`;
CREATE TABLE IF NOT EXISTS `restaurants_cuisines` (
  `restaurant_id` bigint(20) NOT NULL,
  `cuisine_id` bigint(20) NOT NULL,
  KEY `FKssp2uu548yv1te3yspuxdj99d` (`cuisine_id`),
  KEY `FKdk1y2e7d8s778bhtxden294fn` (`restaurant_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- Dumping data for table sample.restaurants_cuisines: 5 rows
DELETE FROM `restaurants_cuisines`;
/*!40000 ALTER TABLE `restaurants_cuisines` DISABLE KEYS */;
INSERT INTO `restaurants_cuisines` (`restaurant_id`, `cuisine_id`) VALUES
	(1, 1),
	(1, 2),
	(1, 3),
	(1, 4),
	(1, 5);
/*!40000 ALTER TABLE `restaurants_cuisines` ENABLE KEYS */;

-- Dumping structure for table sample.restaurants_menus
DROP TABLE IF EXISTS `restaurants_menus`;
CREATE TABLE IF NOT EXISTS `restaurants_menus` (
  `restaurant_restaurant_id` bigint(20) NOT NULL,
  `menus_restaurant_menu_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_9b152ryemquxe5i3gpee5d13n` (`menus_restaurant_menu_id`),
  KEY `FKq59uj04qf6ted74tpj3gwquql` (`restaurant_restaurant_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- Dumping data for table sample.restaurants_menus: 0 rows
DELETE FROM `restaurants_menus`;
/*!40000 ALTER TABLE `restaurants_menus` DISABLE KEYS */;
/*!40000 ALTER TABLE `restaurants_menus` ENABLE KEYS */;

-- Dumping structure for table sample.restaurant_add_ons
DROP TABLE IF EXISTS `restaurant_add_ons`;
CREATE TABLE IF NOT EXISTS `restaurant_add_ons` (
  `restaurant_add_on_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `add_on_id` bigint(20) DEFAULT NULL,
  `restaurant_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`restaurant_add_on_id`),
  KEY `FKc1jyexmfro0qix7nocu96wyjn` (`add_on_id`),
  KEY `FKmqfwn2yfl2egk7v96p7cn96ne` (`restaurant_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table sample.restaurant_add_ons: 2 rows
DELETE FROM `restaurant_add_ons`;
/*!40000 ALTER TABLE `restaurant_add_ons` DISABLE KEYS */;
INSERT INTO `restaurant_add_ons` (`restaurant_add_on_id`, `add_on_id`, `restaurant_id`) VALUES
	(1, 1, 1),
	(2, 2, 1);
/*!40000 ALTER TABLE `restaurant_add_ons` ENABLE KEYS */;

-- Dumping structure for table sample.restaurant_add_on_items
DROP TABLE IF EXISTS `restaurant_add_on_items`;
CREATE TABLE IF NOT EXISTS `restaurant_add_on_items` (
  `restaurant_add_on_item_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `add_on_item_id` bigint(20) DEFAULT NULL,
  `restaurant_add_on_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`restaurant_add_on_item_id`),
  KEY `FKfyaa88x6m49em24o6xuejf4wi` (`add_on_item_id`),
  KEY `FK8892cu2t63i8jxmwvsolwc29l` (`restaurant_add_on_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dumping data for table sample.restaurant_add_on_items: 4 rows
DELETE FROM `restaurant_add_on_items`;
/*!40000 ALTER TABLE `restaurant_add_on_items` DISABLE KEYS */;
INSERT INTO `restaurant_add_on_items` (`restaurant_add_on_item_id`, `add_on_item_id`, `restaurant_add_on_id`) VALUES
	(1, 1, 1),
	(2, 2, 1),
	(3, 1, 2),
	(4, 2, 2);
/*!40000 ALTER TABLE `restaurant_add_on_items` ENABLE KEYS */;

-- Dumping structure for table sample.restaurant_categories
DROP TABLE IF EXISTS `restaurant_categories`;
CREATE TABLE IF NOT EXISTS `restaurant_categories` (
  `restaurant_category_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_id` bigint(20) DEFAULT NULL,
  `restaurant_menu_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`restaurant_category_id`),
  KEY `FK4kg1d5bcfdt8fn2qh16ptrnfm` (`category_id`),
  KEY `FKkhdsv1oukcawemtiovbyb9ejl` (`restaurant_menu_id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Dumping data for table sample.restaurant_categories: 6 rows
DELETE FROM `restaurant_categories`;
/*!40000 ALTER TABLE `restaurant_categories` DISABLE KEYS */;
INSERT INTO `restaurant_categories` (`restaurant_category_id`, `category_id`, `restaurant_menu_id`) VALUES
	(1, 1, 1),
	(2, 2, 1),
	(3, 3, 1),
	(4, 10, 6),
	(5, 11, 6),
	(6, 12, 6);
/*!40000 ALTER TABLE `restaurant_categories` ENABLE KEYS */;

-- Dumping structure for table sample.restaurant_choices
DROP TABLE IF EXISTS `restaurant_choices`;
CREATE TABLE IF NOT EXISTS `restaurant_choices` (
  `restaurant_choice_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `choice_id` bigint(20) DEFAULT NULL,
  `restaurant_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`restaurant_choice_id`),
  KEY `FKgjpcd99vc8scysck56emn38n` (`choice_id`),
  KEY `FKgwi5vwh2q7q3ev5qyksmpvn7l` (`restaurant_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table sample.restaurant_choices: 1 rows
DELETE FROM `restaurant_choices`;
/*!40000 ALTER TABLE `restaurant_choices` DISABLE KEYS */;
INSERT INTO `restaurant_choices` (`restaurant_choice_id`, `choice_id`, `restaurant_id`) VALUES
	(1, 1, 1);
/*!40000 ALTER TABLE `restaurant_choices` ENABLE KEYS */;

-- Dumping structure for table sample.restaurant_choice_items
DROP TABLE IF EXISTS `restaurant_choice_items`;
CREATE TABLE IF NOT EXISTS `restaurant_choice_items` (
  `restaurant_choice_item_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `price` float DEFAULT NULL,
  `choice_item_id` bigint(20) DEFAULT NULL,
  `restaurant_choice_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`restaurant_choice_item_id`),
  KEY `FKtjqtck855d5p4rwud9gsa7odg` (`choice_item_id`),
  KEY `FK6273qch3epn6fo6uv1wj1s7k4` (`restaurant_choice_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table sample.restaurant_choice_items: 2 rows
DELETE FROM `restaurant_choice_items`;
/*!40000 ALTER TABLE `restaurant_choice_items` DISABLE KEYS */;
INSERT INTO `restaurant_choice_items` (`restaurant_choice_item_id`, `price`, `choice_item_id`, `restaurant_choice_id`) VALUES
	(1, NULL, 1, 1),
	(2, NULL, 2, 1);
/*!40000 ALTER TABLE `restaurant_choice_items` ENABLE KEYS */;

-- Dumping structure for table sample.restaurant_foods
DROP TABLE IF EXISTS `restaurant_foods`;
CREATE TABLE IF NOT EXISTS `restaurant_foods` (
  `restaurant_food_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `restaurant_category_id` bigint(20) DEFAULT NULL,
  `restaurant_menu_id` bigint(20) DEFAULT NULL,
  `discount` float DEFAULT NULL,
  `price` float DEFAULT NULL,
  `customizable` bit(1) DEFAULT NULL,
  PRIMARY KEY (`restaurant_food_id`),
  KEY `FKom57go5i8kqdddridn6g933wu` (`restaurant_category_id`),
  KEY `FK228ute1iyitu0ml7cvgeejojd` (`restaurant_menu_id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- Dumping data for table sample.restaurant_foods: 10 rows
DELETE FROM `restaurant_foods`;
/*!40000 ALTER TABLE `restaurant_foods` DISABLE KEYS */;
INSERT INTO `restaurant_foods` (`restaurant_food_id`, `name`, `restaurant_category_id`, `restaurant_menu_id`, `discount`, `price`, `customizable`) VALUES
	(1, 'Shahi Paneer', 1, 2, 0, 10, b'1'),
	(2, 'Chiili Paneer', 1, 2, 0, 10, b'1'),
	(3, 'Kadhai Paneer', 1, 2, 0, 10, b'1'),
	(4, 'Kadhai Chicken', 2, 2, 0, 10, b'1'),
	(5, 'Butter Chicken', 2, 2, 0, 10, b'1'),
	(6, 'Veg Thali', NULL, 5, 0, 10, b'1'),
	(7, 'Non Veg Thali', NULL, 5, 0, 10, b'1'),
	(8, 'Spl. Non Veg Thali', NULL, 5, 0, 10, b'1'),
	(9, 'Dal + Rice', NULL, 3, 0, 10, b'1'),
	(10, 'Kadhai + Rice', NULL, 3, 0, 10, b'1');
/*!40000 ALTER TABLE `restaurant_foods` ENABLE KEYS */;

-- Dumping structure for table sample.restaurant_food_add_on_items
DROP TABLE IF EXISTS `restaurant_food_add_on_items`;
CREATE TABLE IF NOT EXISTS `restaurant_food_add_on_items` (
  `restaurant_food_add_on_item_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `price` float DEFAULT NULL,
  `restaurant_add_on_item_id` bigint(20) DEFAULT NULL,
  `restaurant_food_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`restaurant_food_add_on_item_id`),
  KEY `FK5k4dikuesk0ftcbmfice8kbxn` (`restaurant_add_on_item_id`),
  KEY `FKj8m4vhpr89n1rq9uxdca3x5i2` (`restaurant_food_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table sample.restaurant_food_add_on_items: 2 rows
DELETE FROM `restaurant_food_add_on_items`;
/*!40000 ALTER TABLE `restaurant_food_add_on_items` DISABLE KEYS */;
INSERT INTO `restaurant_food_add_on_items` (`restaurant_food_add_on_item_id`, `price`, `restaurant_add_on_item_id`, `restaurant_food_id`) VALUES
	(1, 60, 1, 1),
	(2, 70, 2, 1);
/*!40000 ALTER TABLE `restaurant_food_add_on_items` ENABLE KEYS */;

-- Dumping structure for table sample.restaurant_food_choice_items
DROP TABLE IF EXISTS `restaurant_food_choice_items`;
CREATE TABLE IF NOT EXISTS `restaurant_food_choice_items` (
  `restaurant_food_choice_item_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `price` float DEFAULT NULL,
  `restaurant_choice_item_id` bigint(20) DEFAULT NULL,
  `restaurant_food_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`restaurant_food_choice_item_id`),
  KEY `FKmodsb0cdjhr7wg7v7r3ntl3qk` (`restaurant_choice_item_id`),
  KEY `FKhddkcxbfqurh5mamnn893w946` (`restaurant_food_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table sample.restaurant_food_choice_items: 1 rows
DELETE FROM `restaurant_food_choice_items`;
/*!40000 ALTER TABLE `restaurant_food_choice_items` DISABLE KEYS */;
INSERT INTO `restaurant_food_choice_items` (`restaurant_food_choice_item_id`, `price`, `restaurant_choice_item_id`, `restaurant_food_id`) VALUES
	(1, 120, 1, 1);
/*!40000 ALTER TABLE `restaurant_food_choice_items` ENABLE KEYS */;

-- Dumping structure for table sample.restaurant_food_options
DROP TABLE IF EXISTS `restaurant_food_options`;
CREATE TABLE IF NOT EXISTS `restaurant_food_options` (
  `restaurant_food_option_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `discount` float DEFAULT NULL,
  `price` float DEFAULT NULL,
  `restaurant_food_id` bigint(20) DEFAULT NULL,
  `restaurant_option_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`restaurant_food_option_id`),
  KEY `FKbicrv4sdn6ak2khow8fkemnet` (`restaurant_food_id`),
  KEY `FKdn0ajrvdhpct74cxuvu0o0mce` (`restaurant_option_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table sample.restaurant_food_options: 2 rows
DELETE FROM `restaurant_food_options`;
/*!40000 ALTER TABLE `restaurant_food_options` DISABLE KEYS */;
INSERT INTO `restaurant_food_options` (`restaurant_food_option_id`, `discount`, `price`, `restaurant_food_id`, `restaurant_option_id`) VALUES
	(1, 10, 100, 1, 1),
	(2, 10, 150, 1, 2);
/*!40000 ALTER TABLE `restaurant_food_options` ENABLE KEYS */;

-- Dumping structure for table sample.restaurant_menus
DROP TABLE IF EXISTS `restaurant_menus`;
CREATE TABLE IF NOT EXISTS `restaurant_menus` (
  `restaurant_menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `menu_id` bigint(20) DEFAULT NULL,
  `restaurant_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`restaurant_menu_id`),
  KEY `FKtmc335lpuxbgtt2xc6ocl8tdx` (`menu_id`),
  KEY `FKpdk398ti12pov57x5to24kskq` (`restaurant_id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Dumping data for table sample.restaurant_menus: 6 rows
DELETE FROM `restaurant_menus`;
/*!40000 ALTER TABLE `restaurant_menus` DISABLE KEYS */;
INSERT INTO `restaurant_menus` (`restaurant_menu_id`, `menu_id`, `restaurant_id`) VALUES
	(1, 1, 1),
	(2, 2, 1),
	(3, 3, 1),
	(4, 5, 1),
	(5, 7, 1),
	(6, 9, 1);
/*!40000 ALTER TABLE `restaurant_menus` ENABLE KEYS */;

-- Dumping structure for table sample.restaurant_offers
DROP TABLE IF EXISTS `restaurant_offers`;
CREATE TABLE IF NOT EXISTS `restaurant_offers` (
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

-- Dumping data for table sample.restaurant_offers: 2 rows
DELETE FROM `restaurant_offers`;
/*!40000 ALTER TABLE `restaurant_offers` DISABLE KEYS */;
INSERT INTO `restaurant_offers` (`restaurant_offer_id`, `above_price`, `created_date`, `expired_date`, `is_valid`, `percentage`, `offer_type_id`) VALUES
	(1, 0, NULL, NULL, b'0', 20, 1),
	(2, 300, NULL, NULL, b'0', 30, 4);
/*!40000 ALTER TABLE `restaurant_offers` ENABLE KEYS */;

-- Dumping structure for table sample.restaurant_options
DROP TABLE IF EXISTS `restaurant_options`;
CREATE TABLE IF NOT EXISTS `restaurant_options` (
  `restaurant_option_id` int(11) NOT NULL AUTO_INCREMENT,
  `option_id` bigint(20) DEFAULT NULL,
  `restaurant_option_type_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`restaurant_option_id`),
  KEY `FKem62wfytr38xuvb6n50h06wf7` (`option_id`),
  KEY `FK9o48e34v5lh70wpq38ejn5gsf` (`restaurant_option_type_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table sample.restaurant_options: 2 rows
DELETE FROM `restaurant_options`;
/*!40000 ALTER TABLE `restaurant_options` DISABLE KEYS */;
INSERT INTO `restaurant_options` (`restaurant_option_id`, `option_id`, `restaurant_option_type_id`) VALUES
	(1, 1, 1),
	(2, 2, 1);
/*!40000 ALTER TABLE `restaurant_options` ENABLE KEYS */;

-- Dumping structure for table sample.restaurant_option_types
DROP TABLE IF EXISTS `restaurant_option_types`;
CREATE TABLE IF NOT EXISTS `restaurant_option_types` (
  `restaurant_option_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `option_type_id` bigint(20) DEFAULT NULL,
  `restaurant_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`restaurant_option_type_id`),
  KEY `FKlgbnpv3en0pt3h1beq8v7dila` (`option_type_id`),
  KEY `FK3j2do2sqxawa147ls8g60ange` (`restaurant_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table sample.restaurant_option_types: 1 rows
DELETE FROM `restaurant_option_types`;
/*!40000 ALTER TABLE `restaurant_option_types` DISABLE KEYS */;
INSERT INTO `restaurant_option_types` (`restaurant_option_type_id`, `option_type_id`, `restaurant_id`) VALUES
	(1, 1, 1);
/*!40000 ALTER TABLE `restaurant_option_types` ENABLE KEYS */;

-- Dumping structure for table sample.roles
DROP TABLE IF EXISTS `roles`;
CREATE TABLE IF NOT EXISTS `roles` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dumping data for table sample.roles: 4 rows
DELETE FROM `roles`;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` (`role_id`, `role`) VALUES
	(1, 'CUSTOMER'),
	(2, 'RESTAURANT'),
	(3, 'DELIVERY_AGENT'),
	(4, 'DELIVERY_AGENCY');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;

-- Dumping structure for table sample.users
DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `inserted_time` datetime DEFAULT NULL,
  `modified_time` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table sample.users: 2 rows
DELETE FROM `users`;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`user_id`, `email`, `inserted_time`, `modified_time`, `name`, `password`, `phone`) VALUES
	(1, 'ddd@g.com', NULL, NULL, 'dddee', 'eeeee', 'abc1111111'),
	(2, 'ddd8@g.com', '2018-11-30 17:41:11', NULL, 'dddee', 'eeeeew', 'abc11111121');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

-- Dumping structure for table sample.users_roles
DROP TABLE IF EXISTS `users_roles`;
CREATE TABLE IF NOT EXISTS `users_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` int(11) NOT NULL,
  KEY `FKj6m8fwv7oqv74fcehir1a9ffy` (`role_id`),
  KEY `FK2o0jvgh89lemvvo17cbqvdxaa` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- Dumping data for table sample.users_roles: 1 rows
DELETE FROM `users_roles`;
/*!40000 ALTER TABLE `users_roles` DISABLE KEYS */;
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES
	(2, 1);
/*!40000 ALTER TABLE `users_roles` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
