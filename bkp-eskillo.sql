-- MySQL dump 10.13  Distrib 8.0.20, for macos10.15 (x86_64)
--
-- Host: localhost    Database: eskillo
-- ------------------------------------------------------
-- Server version	8.0.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `area_estudo`
--

DROP TABLE IF EXISTS `area_estudo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `area_estudo` (
  `id_area_estudo` bigint NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_area_estudo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `area_estudo`
--

LOCK TABLES `area_estudo` WRITE;
/*!40000 ALTER TABLE `area_estudo` DISABLE KEYS */;
INSERT INTO `area_estudo` VALUES (1,'Engenharia de Software'),(2,'Administração'),(3,'Direito');
/*!40000 ALTER TABLE `area_estudo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `competencia`
--

DROP TABLE IF EXISTS `competencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `competencia` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `tipo_competencia_id_tipo_competencia` bigint DEFAULT NULL,
  `id_perfil` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKps9eg34v72odn64fgq4xdl3xe` (`tipo_competencia_id_tipo_competencia`),
  KEY `FKododsrmhlrf2vjjqdkpwml2wf` (`id_perfil`),
  CONSTRAINT `FKododsrmhlrf2vjjqdkpwml2wf` FOREIGN KEY (`id_perfil`) REFERENCES `perfil` (`id`),
  CONSTRAINT `FKps9eg34v72odn64fgq4xdl3xe` FOREIGN KEY (`tipo_competencia_id_tipo_competencia`) REFERENCES `tipo_competencia` (`id_tipo_competencia`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `competencia`
--

LOCK TABLES `competencia` WRITE;
/*!40000 ALTER TABLE `competencia` DISABLE KEYS */;
INSERT INTO `competencia` VALUES (1,1,1),(2,2,1),(3,3,1);
/*!40000 ALTER TABLE `competencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso`
--

DROP TABLE IF EXISTS `curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `curso` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `carga_horaria` int NOT NULL,
  `data_fim` date DEFAULT NULL,
  `data_inicio` date DEFAULT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `organizacao` varchar(255) DEFAULT NULL,
  `id_perfil` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKthbd45wp5qfgjwjmsms3iklvf` (`id_perfil`),
  CONSTRAINT `FKthbd45wp5qfgjwjmsms3iklvf` FOREIGN KEY (`id_perfil`) REFERENCES `perfil` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` VALUES (1,40,'2020-10-12','2020-10-01','Oracle','Centro de Artesanato',1),(2,32,'2019-11-09','2019-11-05','WebDesign com HTML5 e CSS3','Tapioca Design',1);
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `experiencia`
--

DROP TABLE IF EXISTS `experiencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `experiencia` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cargo` varchar(255) DEFAULT NULL,
  `data_fim` date DEFAULT NULL,
  `data_inicio` date DEFAULT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `nome_empresa` varchar(255) DEFAULT NULL,
  `ocupacao_atual` bit(1) NOT NULL,
  `tipo_emprego` varchar(255) DEFAULT NULL,
  `id_localidade` bigint DEFAULT NULL,
  `id_perfil` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqxn7xxfj4o3ilx2ckvvgv5tey` (`id_localidade`),
  KEY `FKdpn61awefv773o7ncacvnwu0x` (`id_perfil`),
  CONSTRAINT `FKdpn61awefv773o7ncacvnwu0x` FOREIGN KEY (`id_perfil`) REFERENCES `perfil` (`id`),
  CONSTRAINT `FKqxn7xxfj4o3ilx2ckvvgv5tey` FOREIGN KEY (`id_localidade`) REFERENCES `localidade` (`id_localidade`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `experiencia`
--

LOCK TABLES `experiencia` WRITE;
/*!40000 ALTER TABLE `experiencia` DISABLE KEYS */;
INSERT INTO `experiencia` VALUES (1,'Professor','2019-09-20','2018-03-01','Disciplina: Algoritmo e Lógica de Programação','Faculdade do Saber',_binary '\0','TEMPO_INTEGRAL',1,1),(2,'Gerente de Projetos',NULL,'2019-10-05','Projetos de cooperativas agrícolas','Organizações Tabajaras',_binary '','TEMPO_INTEGRAL',2,1);
/*!40000 ALTER TABLE `experiencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `formacao`
--

DROP TABLE IF EXISTS `formacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `formacao` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `ano_fim` int NOT NULL,
  `ano_inicio` int NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `em_andamento` bit(1) NOT NULL,
  `nome_instituicao` varchar(255) DEFAULT NULL,
  `id_area_estudo` bigint DEFAULT NULL,
  `id_tipo_formacao` bigint DEFAULT NULL,
  `id_perfil` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3e8uklqwdws93o1n6qk5x8p5f` (`id_area_estudo`),
  KEY `FKod4ig5rwsysrs3srxg5rpdb3f` (`id_tipo_formacao`),
  KEY `FKiort21hwfun2j2qkusnfjrrrc` (`id_perfil`),
  CONSTRAINT `FK3e8uklqwdws93o1n6qk5x8p5f` FOREIGN KEY (`id_area_estudo`) REFERENCES `area_estudo` (`id_area_estudo`),
  CONSTRAINT `FKiort21hwfun2j2qkusnfjrrrc` FOREIGN KEY (`id_perfil`) REFERENCES `perfil` (`id`),
  CONSTRAINT `FKod4ig5rwsysrs3srxg5rpdb3f` FOREIGN KEY (`id_tipo_formacao`) REFERENCES `tipo_formacao` (`id_tipo_formacao`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `formacao`
--

LOCK TABLES `formacao` WRITE;
/*!40000 ALTER TABLE `formacao` DISABLE KEYS */;
INSERT INTO `formacao` VALUES (1,2019,2016,'Dissertação: As tranças do Rei Careca aplicadas à Engenharia de Requisitos',_binary '\0','Faculdade Menina Bonita',1,1,1);
/*!40000 ALTER TABLE `formacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fotografia`
--

DROP TABLE IF EXISTS `fotografia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fotografia` (
  `fotografia` longblob,
  `tipo_arquivo` varchar(255) DEFAULT NULL,
  `id_perfil` bigint NOT NULL,
  PRIMARY KEY (`id_perfil`),
  CONSTRAINT `FK58dxwq1qljmcay1yso8s10uj7` FOREIGN KEY (`id_perfil`) REFERENCES `perfil` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fotografia`
--

LOCK TABLES `fotografia` WRITE;
/*!40000 ALTER TABLE `fotografia` DISABLE KEYS */;
/*!40000 ALTER TABLE `fotografia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `localidade`
--

DROP TABLE IF EXISTS `localidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `localidade` (
  `id_localidade` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `uf` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_localidade`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `localidade`
--

LOCK TABLES `localidade` WRITE;
/*!40000 ALTER TABLE `localidade` DISABLE KEYS */;
INSERT INTO `localidade` VALUES (1,'Teresina','PI'),(2,'Parnaíba','PI'),(3,'Ipojuca','PE');
/*!40000 ALTER TABLE `localidade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perfil`
--

DROP TABLE IF EXISTS `perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `perfil` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `bairro` varchar(255) DEFAULT NULL,
  `cargo_atual` varchar(255) DEFAULT NULL,
  `cidade` varchar(255) DEFAULT NULL,
  `complemento` varchar(255) DEFAULT NULL,
  `data_nascimento` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `sobre` varchar(255) DEFAULT NULL,
  `uf` varchar(255) DEFAULT NULL,
  `visibilidade_perfil` bit(1) NOT NULL,
  `id_localidade` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnm0ljog42w5498f3wd94brqxt` (`id_localidade`),
  CONSTRAINT `FKnm0ljog42w5498f3wd94brqxt` FOREIGN KEY (`id_localidade`) REFERENCES `localidade` (`id_localidade`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfil`
--

LOCK TABLES `perfil` WRITE;
/*!40000 ALTER TABLE `perfil` DISABLE KEYS */;
INSERT INTO `perfil` VALUES (1,'Centro','Professor','Teresina','Apto 101',NULL,'fulano@gmail.com','Rua Cafundó de Judas, 100','Fulano de Tal','De boa!','PI',_binary '',1);
/*!40000 ALTER TABLE `perfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `telefone`
--

DROP TABLE IF EXISTS `telefone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `telefone` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `numero` varchar(255) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `id_perfil` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKrli50uei6m1frumw4s8u4vjbh` (`id_perfil`),
  CONSTRAINT `FKrli50uei6m1frumw4s8u4vjbh` FOREIGN KEY (`id_perfil`) REFERENCES `perfil` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `telefone`
--

LOCK TABLES `telefone` WRITE;
/*!40000 ALTER TABLE `telefone` DISABLE KEYS */;
INSERT INTO `telefone` VALUES (1,'(86) 91234-5678','CELULAR',1),(2,'(86) 3123-9876','FIXO_RESIDENCIAL',1);
/*!40000 ALTER TABLE `telefone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_competencia`
--

DROP TABLE IF EXISTS `tipo_competencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_competencia` (
  `id_tipo_competencia` bigint NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_tipo_competencia`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_competencia`
--

LOCK TABLES `tipo_competencia` WRITE;
/*!40000 ALTER TABLE `tipo_competencia` DISABLE KEYS */;
INSERT INTO `tipo_competencia` VALUES (1,'Javascript'),(2,'Front-end'),(3,'Oracle');
/*!40000 ALTER TABLE `tipo_competencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_formacao`
--

DROP TABLE IF EXISTS `tipo_formacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_formacao` (
  `id_tipo_formacao` bigint NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_tipo_formacao`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_formacao`
--

LOCK TABLES `tipo_formacao` WRITE;
/*!40000 ALTER TABLE `tipo_formacao` DISABLE KEYS */;
INSERT INTO `tipo_formacao` VALUES (1,'Bacharelado'),(2,'Mestrado'),(3,'Doutorado');
/*!40000 ALTER TABLE `tipo_formacao` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-10-26 17:30:13
