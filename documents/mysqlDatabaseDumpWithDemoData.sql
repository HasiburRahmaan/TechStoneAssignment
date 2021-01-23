CREATE DATABASE  IF NOT EXISTS `springdemo` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `springdemo`;
-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: springdemo
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bank_account`
--

DROP TABLE IF EXISTS `bank_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bank_account` (
                                `bank_account_number` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
                                `bank_account_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
                                `bank_account_type_id` int(11) NOT NULL,
                                `branch_info` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
                                `current_balance` double NOT NULL,
                                PRIMARY KEY (`bank_account_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bank_account`
--

LOCK TABLES `bank_account` WRITE;
/*!40000 ALTER TABLE `bank_account` DISABLE KEYS */;
INSERT INTO `bank_account` VALUES ('1','Demo account One',0,'Branch Info',40500),('10','Demo account Ten',0,'Branch Info',6750),('2','Demo account Two',0,'Branch Info',33750),('3','Demo account Three',0,'Branch Info',27000),('4','Demo account Four',0,'Branch Info',27000),('5','Demo account Five',0,'Branch Info',20250),('6','Demo account Six',0,'Branch Info',20250),('7','Demo account Seven',0,'Branch Info',13500),('8','Demo account Eight',0,'Branch Info',13500),('9','Demo account Nine',0,'Branch Info',6750);
/*!40000 ALTER TABLE `bank_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bank_account_type`
--

DROP TABLE IF EXISTS `bank_account_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bank_account_type` (
                                     `bank_account_type_id` int(11) NOT NULL,
                                     `bank_account_type` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
                                     PRIMARY KEY (`bank_account_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bank_account_type`
--

LOCK TABLES `bank_account_type` WRITE;
/*!40000 ALTER TABLE `bank_account_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `bank_account_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `company` (
                           `id` int(11) NOT NULL,
                           `basic_salary_of_lowest_grade` double NOT NULL,
                           `initial_balance` double NOT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (1,5000,219250);
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
                            `employee_id` int(11) NOT NULL,
                            `employee_address` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
                            `employee_bank_account_number` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
                            `employee_grade_id` int(11) NOT NULL,
                            `employee_mobile` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
                            `employee_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
                            PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (8,NULL,'1',7,NULL,'EmployeeOne'),(9,NULL,'2',6,NULL,'EmployeeTwo'),(10,NULL,'3',5,NULL,'EmployeeThree'),(11,NULL,'4',5,NULL,'EmployeeFour'),(12,NULL,'5',4,NULL,'EmployeeFive'),(13,NULL,'6',4,NULL,'EmployeeSix'),(14,NULL,'7',3,NULL,'EmployeeSeven'),(15,NULL,'8',3,NULL,'EmployeeEight'),(16,NULL,'9',2,NULL,'EmployeeNine'),(17,NULL,'10',2,NULL,'EmployeeTen');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grade`
--

DROP TABLE IF EXISTS `grade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grade` (
                         `grade_id` int(11) NOT NULL,
                         `grade_basic_salary` double NOT NULL,
                         `grade_house_rent` double NOT NULL,
                         `grade_medical_allowance` double NOT NULL,
                         `grade_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
                         `grade_rank` int(11) DEFAULT NULL,
                         PRIMARY KEY (`grade_id`),
                         UNIQUE KEY `UK_f2xkudyghikvlkl6touka5ktu` (`grade_rank`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grade`
--

LOCK TABLES `grade` WRITE;
/*!40000 ALTER TABLE `grade` DISABLE KEYS */;
INSERT INTO `grade` VALUES (2,5000,1000,750,'Grade Six',1),(3,10000,2000,1500,'Grade Five',2),(4,15000,3000,2250,'Grade Four',3),(5,20000,4000,3000,'Grade Three',4),(6,25000,5000,3750,'Grade Two',5),(7,30000,6000,4500,'Grade One',6);
/*!40000 ALTER TABLE `grade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
    `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (18);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
                           `id` int(11) NOT NULL,
                           `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
                           `price` double NOT NULL,
                           `quantity` int(11) NOT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-23 11:15:43
