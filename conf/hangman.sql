-- MySQL dump 10.13  Distrib 5.6.19, for osx10.7 (i386)
--
-- Host: 127.0.0.1    Database: hangman
-- ------------------------------------------------------
-- Server version	5.6.23

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
-- Table structure for table `config`
--

DROP TABLE IF EXISTS `config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `config` (
  `key` varchar(20) NOT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`key`)
) ENGINE=InnoDB DEFAULT CHARSET=big5;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config`
--

LOCK TABLES `config` WRITE;
/*!40000 ALTER TABLE `config` DISABLE KEYS */;
/*!40000 ALTER TABLE `config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game`
--

DROP TABLE IF EXISTS `game`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `game` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `status` varchar(255) DEFAULT NULL,
  `word` varchar(255) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `failed_guesses` varchar(255) DEFAULT NULL,
  `right_guesses` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=big5;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game`
--

LOCK TABLES `game` WRITE;
/*!40000 ALTER TABLE `game` DISABLE KEYS */;
INSERT INTO `game` VALUES (1,'inprogress','testing','2015-07-13 12:41:49','a4tzxocvd','esngi'),(2,'won','work','2015-07-13 12:41:54','f','rwok'),(3,'won','work','2015-07-13 12:41:57','','work'),(4,'lost','work','2015-07-13 12:41:59','dlmnbcxv','k'),(5,'inprogress','fantastic','2015-07-13 12:42:02','',''),(6,'inprogress','wit','2015-07-13 13:27:01','',''),(7,'inprogress','delighted','2015-07-13 14:46:28','',''),(8,'inprogress','dragon','2015-07-13 14:47:03','',''),(9,'inprogress','wit','2015-07-13 14:48:09','',''),(10,'inprogress','delighted','2015-07-13 14:49:13','',''),(11,'inprogress','testing','2015-07-13 14:50:23','',''),(12,'inprogress','wit','2015-07-13 14:52:08','',''),(13,'inprogress','try','2015-07-13 14:52:32','',''),(14,'inprogress','delighted','2015-07-13 14:55:22','',''),(15,'inprogress','wit','2015-07-13 15:02:01','',''),(16,'inprogress','testing','2015-07-13 15:02:48','','s'),(17,'inprogress','testing','2015-07-13 15:11:05','','s'),(18,'inprogress','fantastic','2015-07-13 15:12:56','','sa'),(19,'inprogress','fantastic','2015-07-13 15:15:09','',''),(20,'inprogress','testing','2015-07-13 15:16:01','',''),(21,'inprogress','fantastic','2015-07-13 15:16:12','','a'),(22,'won','try','2015-07-13 15:34:18','swdjnax','tyr'),(23,'inprogress','testing','2015-07-13 15:40:15','a','s'),(24,'inprogress','try','2015-07-13 15:41:59','ai','t'),(25,'lost','work','2015-07-13 15:46:51','saeqtyui','wok'),(26,'lost','dragon','2015-07-13 15:57:34','wetyuipv','rod'),(27,'lost','delighted','2015-07-13 15:59:42','sfyjkoxca','dgl'),(28,'won','fantastic','2015-07-13 16:02:11','','fantsic'),(29,'lost','try','2015-07-13 16:04:36','weauiodc',''),(30,'inprogress','testing','2015-07-13 17:20:13','d','g'),(31,'inprogress','work','2015-07-13 18:22:27','','');
/*!40000 ALTER TABLE `game` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `play_evolutions`
--

DROP TABLE IF EXISTS `play_evolutions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `play_evolutions` (
  `id` int(11) NOT NULL,
  `hash` varchar(255) NOT NULL,
  `applied_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `apply_script` text,
  `revert_script` text,
  `state` varchar(255) DEFAULT NULL,
  `last_problem` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=big5;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `play_evolutions`
--

LOCK TABLES `play_evolutions` WRITE;
/*!40000 ALTER TABLE `play_evolutions` DISABLE KEYS */;
INSERT INTO `play_evolutions` VALUES (1,'147472b7b3f95206f341f2cca1b449057952f974','2015-07-13 11:33:32','create table game (\nid                        integer auto_increment not null,\nstatus                    varchar(255),\nword                      varchar(255),\nstart_time                datetime,\nfailed_guesses            varchar(255),\nright_guesses             varchar(255),\nconstraint pk_game primary key (id))\n;\n\ncreate table seed_word (\nid                        integer auto_increment not null,\nword                      varchar(255),\nconstraint pk_seed_word primary key (id))\n;\n\ncreate table word (\nid                        integer auto_increment not null,\nword                      varchar(255),\nfailed_guesses            varchar(255),\nconstraint pk_word primary key (id))\n;','SET FOREIGN_KEY_CHECKS=0;\n\ndrop table game;\n\ndrop table seed_word;\n\ndrop table word;\n\nSET FOREIGN_KEY_CHECKS=1;','applied','');
/*!40000 ALTER TABLE `play_evolutions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seed_word`
--

DROP TABLE IF EXISTS `seed_word`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seed_word` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `word` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=big5;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seed_word`
--

LOCK TABLES `seed_word` WRITE;
/*!40000 ALTER TABLE `seed_word` DISABLE KEYS */;
INSERT INTO `seed_word` VALUES (1,'testing'),(2,'work'),(3,'wit'),(4,'try'),(5,'dragon'),(6,'delighted'),(7,'fantastic');
/*!40000 ALTER TABLE `seed_word` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-07-13 19:51:32
