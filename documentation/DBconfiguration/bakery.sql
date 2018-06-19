-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: bakery
-- ------------------------------------------------------
-- Server version	5.7.21-log

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

drop database if exists bakery;

create database bakery;

use bakery;

--
-- Table structure for table `access_flags`
--

DROP TABLE IF EXISTS `access_flags`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `access_flags` (
  `accessFlagId` int(11) NOT NULL AUTO_INCREMENT,
  `accessFlag` varchar(50) NOT NULL,
  PRIMARY KEY (`accessFlagId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `access_flags`
--

LOCK TABLES `access_flags` WRITE;
/*!40000 ALTER TABLE `access_flags` DISABLE KEYS */;
INSERT INTO `access_flags` VALUES (1,'addProductAF'),(2,'deleteProductAF'),(3,'addUserAF'),(4,'deleteUserAF');
/*!40000 ALTER TABLE `access_flags` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `accessflag_role_x_ref`
--

DROP TABLE IF EXISTS `accessflag_role_x_ref`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `accessflag_role_x_ref` (
  `accessFlagId` int(11) DEFAULT NULL,
  `roleId` int(11) DEFAULT NULL,
  KEY `accessFlagId` (`accessFlagId`),
  KEY `roleId` (`roleId`),
  CONSTRAINT `accessflag_role_x_ref_ibfk_1` FOREIGN KEY (`accessFlagId`) REFERENCES `access_flags` (`accessFlagId`),
  CONSTRAINT `accessflag_role_x_ref_ibfk_2` FOREIGN KEY (`roleId`) REFERENCES `roles` (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accessflag_role_x_ref`
--

LOCK TABLES `accessflag_role_x_ref` WRITE;
/*!40000 ALTER TABLE `accessflag_role_x_ref` DISABLE KEYS */;
INSERT INTO `accessflag_role_x_ref` VALUES (1,3),(1,4),(2,1),(2,2),(NULL,NULL);
/*!40000 ALTER TABLE `accessflag_role_x_ref` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingredients`
--

DROP TABLE IF EXISTS `ingredients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ingredients` (
  `ingredientId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`ingredientId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingredients`
--

LOCK TABLES `ingredients` WRITE;
/*!40000 ALTER TABLE `ingredients` DISABLE KEYS */;
INSERT INTO `ingredients` VALUES (1,'Whole weath bread'),(2,'Honey'),(3,'Jam'),(4,'Tuna'),(5,'Edamer'),(6,'Meat'),(7,'Salad');
/*!40000 ALTER TABLE `ingredients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_categories`
--

DROP TABLE IF EXISTS `product_categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_categories` (
  `productCategoryId` int(11) NOT NULL AUTO_INCREMENT,
  `category` varchar(50) NOT NULL,
  PRIMARY KEY (`productCategoryId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_categories`
--

LOCK TABLES `product_categories` WRITE;
/*!40000 ALTER TABLE `product_categories` DISABLE KEYS */;
INSERT INTO `product_categories` VALUES (1,'Breads'),(2,'Crepes'),(3,'Sandwiches and Quiches'),(4,'Viennoiseries'),(5,'Pastries'),(6,'Catering');
/*!40000 ALTER TABLE `product_categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_ingredient_x_ref`
--

DROP TABLE IF EXISTS `product_ingredient_x_ref`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_ingredient_x_ref` (
  `productId` int(11) DEFAULT NULL,
  `ingredientId` int(11) DEFAULT NULL,
  KEY `productId` (`productId`),
  KEY `ingredientId` (`ingredientId`),
  CONSTRAINT `product_ingredient_x_ref_ibfk_1` FOREIGN KEY (`productId`) REFERENCES `products` (`productId`),
  CONSTRAINT `product_ingredient_x_ref_ibfk_2` FOREIGN KEY (`ingredientId`) REFERENCES `ingredients` (`ingredientId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_ingredient_x_ref`
--

LOCK TABLES `product_ingredient_x_ref` WRITE;
/*!40000 ALTER TABLE `product_ingredient_x_ref` DISABLE KEYS */;
INSERT INTO `product_ingredient_x_ref` VALUES (1,1),(2,1),(3,1),(3,2),(5,2);
/*!40000 ALTER TABLE `product_ingredient_x_ref` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `products` (
  `productId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `price` double NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `productCategoryId` int(11) NOT NULL,
  PRIMARY KEY (`productId`),
  KEY `productCategoryId` (`productCategoryId`),
  CONSTRAINT `products_ibfk_1` FOREIGN KEY (`productCategoryId`) REFERENCES `product_categories` (`productCategoryId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'Ordinary bread',1.1,'Description for just ordinary bread','images/pic1.jpg',1),(2,'Whole weath bread',1.1,'Description for Whole weath bread','images/pic2.jpg',1),(3,'Honey crepes',1.1,'Description for Honey crepes','images/pic3.jpg',2),(4,'Jam crepes',1.1,'Description for Jam crepes','images/pic4.jpg',2),(5,'Cheese sandwich',1.1,'Description for Cheese sandwich','images/pic5.jpg',3),(6,'Tuna sandwich',1.1,'Description for Tuna sandwich','images/pic6.jpg',3);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roles` (
  `roleId` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(50) NOT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'superadmin'),(2,'menager'),(3,'headcheaf'),(4,'waiter'),(5,'cashier');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(30) NOT NULL,
  `lastName` varchar(30) NOT NULL,
  `roleId` int(11) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  `phoneNumber` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`userId`),
  KEY `roleId` (`roleId`),
  CONSTRAINT `users_ibfk_1` FOREIGN KEY (`roleId`) REFERENCES `roles` (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Nedim','Kulovac',1,'nedim.kulovac@gmail.com','pass1','061 061 061'),(2,'Dino','Spreco',2,'spavas.li.mirno@gmail.com','pass2','062 062 062'),(3,'Zeljko','AlStvarno',3,'zeljko.stvarno@gmail.com','pass3','063 063 063');
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

-- Dump completed on 2018-06-19 13:50:07
