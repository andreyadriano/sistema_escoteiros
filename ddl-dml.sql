-- MySQL dump 10.13  Distrib 8.0.35, for Linux (x86_64)
--
-- Host: ampto.sj.ifsc.edu.br    Database: pp1andrey
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `alergia`
--

DROP TABLE IF EXISTS `alergia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alergia` (
  `id_alergia` bigint NOT NULL AUTO_INCREMENT,
  `alergia` varchar(255) NOT NULL,
  PRIMARY KEY (`id_alergia`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alergia`
--

LOCK TABLES `alergia` WRITE;
/*!40000 ALTER TABLE `alergia` DISABLE KEYS */;
INSERT INTO `alergia` VALUES (1,'Leite'),(2,'Ovo'),(3,'Rinite alérgica'),(4,'Picada de aranha');
/*!40000 ALTER TABLE `alergia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `area_do_conhecimento`
--

DROP TABLE IF EXISTS `area_do_conhecimento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `area_do_conhecimento` (
  `id_area` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`id_area`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `area_do_conhecimento`
--

LOCK TABLES `area_do_conhecimento` WRITE;
/*!40000 ALTER TABLE `area_do_conhecimento` DISABLE KEYS */;
INSERT INTO `area_do_conhecimento` VALUES (1,'Ciência e Tecnologia'),(2,'Cultura'),(3,'Desportos'),(4,'Habilidades Escoteiras'),(5,'Serviços');
/*!40000 ALTER TABLE `area_do_conhecimento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `distintivo`
--

DROP TABLE IF EXISTS `distintivo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `distintivo` (
  `id_distintivo` bigint NOT NULL AUTO_INCREMENT,
  `progressao` varchar(255) NOT NULL,
  PRIMARY KEY (`id_distintivo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `distintivo`
--

LOCK TABLES `distintivo` WRITE;
/*!40000 ALTER TABLE `distintivo` DISABLE KEYS */;
INSERT INTO `distintivo` VALUES (1,'Lobo Pata Tenra'),(2,'Lobo Saltador'),(3,'Lobo Rastreador'),(4,'Lobo Caçador'),(5,'Cruzeiro do Sul');
/*!40000 ALTER TABLE `distintivo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `especialidade`
--

DROP TABLE IF EXISTS `especialidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `especialidade` (
  `id_area` bigint NOT NULL,
  `id_especialidade` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `modalidade` enum('AR','MAR','BASICO') DEFAULT NULL,
  PRIMARY KEY (`id_especialidade`),
  KEY `FKde7r3y5ryw22jtwvn7r5o60ba` (`id_area`),
  CONSTRAINT `FKde7r3y5ryw22jtwvn7r5o60ba` FOREIGN KEY (`id_area`) REFERENCES `area_do_conhecimento` (`id_area`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `especialidade`
--

LOCK TABLES `especialidade` WRITE;
/*!40000 ALTER TABLE `especialidade` DISABLE KEYS */;
INSERT INTO `especialidade` VALUES (1,1,'Criptografia',NULL),(2,2,'Comédia',NULL),(3,3,'Basquetebol',NULL),(4,4,'Culinária',NULL),(5,5,'Arte Digital',NULL);
/*!40000 ALTER TABLE `especialidade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `insignia`
--

DROP TABLE IF EXISTS `insignia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `insignia` (
  `id_insignia` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`id_insignia`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `insignia`
--

LOCK TABLES `insignia` WRITE;
/*!40000 ALTER TABLE `insignia` DISABLE KEYS */;
INSERT INTO `insignia` VALUES (1,'Insígnia do Aprender'),(2,'Insígnia do Cone Sul'),(3,'Insígnia da Boa Ação'),(4,'Insígnia da Lusofonia');
/*!40000 ALTER TABLE `insignia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jovem`
--

DROP TABLE IF EXISTS `jovem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jovem` (
  `altura` int DEFAULT NULL,
  `data_nascimento` date NOT NULL,
  `peso` float DEFAULT NULL,
  `id_jovem` bigint NOT NULL AUTO_INCREMENT,
  `id_tipo_sanguineo` bigint NOT NULL,
  `cpf` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `endereco` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `telefone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_jovem`),
  UNIQUE KEY `UK_4pdrra4efd4x22h54eajnyy7e` (`cpf`),
  KEY `FK7ht3pt6lnft5oof96l8i6e92w` (`id_tipo_sanguineo`),
  CONSTRAINT `FK7ht3pt6lnft5oof96l8i6e92w` FOREIGN KEY (`id_tipo_sanguineo`) REFERENCES `tipo_sanguineo` (`id_tipo_sanguineo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jovem`
--

LOCK TABLES `jovem` WRITE;
/*!40000 ALTER TABLE `jovem` DISABLE KEYS */;
INSERT INTO `jovem` VALUES (NULL,'2015-07-15',NULL,1,5,'609.475.479-40',NULL,'Rua Raquel de Queiroz, 809','Bruno Kevin Jesus',NULL),(NULL,'2016-09-14',NULL,2,1,'111.222.333-44',NULL,'Rua dos Bobos, 0','Arlindo Cruz',NULL),(NULL,'2015-12-10',NULL,3,4,'123.456.789-10',NULL,'Church of St. Mary Magdalene, Hucknall','Ada Lovelace',NULL),(NULL,'2014-07-23',NULL,4,8,'321.456.987-11',NULL,'Sackville Park','Alan Turing',NULL);
/*!40000 ALTER TABLE `jovem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jovem_alergias`
--

DROP TABLE IF EXISTS `jovem_alergias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jovem_alergias` (
  `id_alergia` bigint NOT NULL,
  `id_jovem` bigint NOT NULL,
  KEY `FKd51d1awybs7joapyrw3cjtcal` (`id_alergia`),
  KEY `FKm0dka07rrmoptj567lgmf3ly6` (`id_jovem`),
  CONSTRAINT `FKd51d1awybs7joapyrw3cjtcal` FOREIGN KEY (`id_alergia`) REFERENCES `alergia` (`id_alergia`),
  CONSTRAINT `FKm0dka07rrmoptj567lgmf3ly6` FOREIGN KEY (`id_jovem`) REFERENCES `jovem` (`id_jovem`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jovem_alergias`
--

LOCK TABLES `jovem_alergias` WRITE;
/*!40000 ALTER TABLE `jovem_alergias` DISABLE KEYS */;
INSERT INTO `jovem_alergias` VALUES (1,1),(2,2);
/*!40000 ALTER TABLE `jovem_alergias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jovem_responsaveis`
--

DROP TABLE IF EXISTS `jovem_responsaveis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jovem_responsaveis` (
  `id_jovem` bigint NOT NULL,
  `id_responsavel` bigint NOT NULL,
  KEY `FKnr8xwp9yac4hcg0cgh7hwa25l` (`id_responsavel`),
  KEY `FKnl89nk4qafprylpgc9htu1ugy` (`id_jovem`),
  CONSTRAINT `FKnl89nk4qafprylpgc9htu1ugy` FOREIGN KEY (`id_jovem`) REFERENCES `jovem` (`id_jovem`),
  CONSTRAINT `FKnr8xwp9yac4hcg0cgh7hwa25l` FOREIGN KEY (`id_responsavel`) REFERENCES `responsavel` (`id_responsavel`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jovem_responsaveis`
--

LOCK TABLES `jovem_responsaveis` WRITE;
/*!40000 ALTER TABLE `jovem_responsaveis` DISABLE KEYS */;
INSERT INTO `jovem_responsaveis` VALUES (1,1),(1,4),(2,5),(3,6),(4,6);
/*!40000 ALTER TABLE `jovem_responsaveis` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `progressao_distintivo`
--

DROP TABLE IF EXISTS `progressao_distintivo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `progressao_distintivo` (
  `data` date NOT NULL,
  `id_jovem` bigint NOT NULL,
  `id_requisito_distintivo` bigint NOT NULL,
  PRIMARY KEY (`id_jovem`,`id_requisito_distintivo`),
  KEY `FK8adaq37746ysfvksa3guti7px` (`id_requisito_distintivo`),
  CONSTRAINT `FK8adaq37746ysfvksa3guti7px` FOREIGN KEY (`id_requisito_distintivo`) REFERENCES `requisito_distintivo` (`id_requisito_distintivo`),
  CONSTRAINT `FKi6mcodqxiws0vqguqy6uxpcrx` FOREIGN KEY (`id_jovem`) REFERENCES `jovem` (`id_jovem`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `progressao_distintivo`
--

LOCK TABLES `progressao_distintivo` WRITE;
/*!40000 ALTER TABLE `progressao_distintivo` DISABLE KEYS */;
/*!40000 ALTER TABLE `progressao_distintivo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `progressao_especialidade`
--

DROP TABLE IF EXISTS `progressao_especialidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `progressao_especialidade` (
  `data` date NOT NULL,
  `id_jovem` bigint NOT NULL,
  `id_requisito_especialidade` bigint NOT NULL,
  PRIMARY KEY (`id_jovem`,`id_requisito_especialidade`),
  KEY `FKhrllmfcjme6iyeenl9dlyn0dw` (`id_requisito_especialidade`),
  CONSTRAINT `FKhrllmfcjme6iyeenl9dlyn0dw` FOREIGN KEY (`id_requisito_especialidade`) REFERENCES `requisito_especialidade` (`id_requisito_especialidade`),
  CONSTRAINT `FKmxi1incyk4si2ov051u1mkc52` FOREIGN KEY (`id_jovem`) REFERENCES `jovem` (`id_jovem`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `progressao_especialidade`
--

LOCK TABLES `progressao_especialidade` WRITE;
/*!40000 ALTER TABLE `progressao_especialidade` DISABLE KEYS */;
INSERT INTO `progressao_especialidade` VALUES ('2015-07-05',1,1),('2015-07-06',1,2),('2015-07-07',1,3),('2015-07-08',1,4),('2015-07-09',1,5),('2015-07-10',1,6),('2015-07-11',1,7),('2015-07-12',1,8),('2015-07-13',1,9),('2015-07-14',1,10),('2015-07-15',1,11),('2015-07-16',1,12),('2015-06-03',1,13),('2015-06-04',1,14),('2015-06-05',1,15),('2015-06-06',1,16),('2015-06-07',1,17),('2015-06-08',1,18),('2015-06-09',1,19),('2015-06-10',1,20),('2015-06-11',1,21),('2015-06-12',1,22),('2015-06-13',1,23),('2015-06-14',1,24),('2015-08-07',1,25),('2015-08-08',1,26),('2015-08-09',1,27),('2015-08-10',1,28),('2015-08-11',1,29),('2015-08-12',1,30),('2015-08-13',1,31),('2015-08-14',1,32),('2015-08-15',1,33),('2015-08-16',1,34),('2015-08-17',1,35),('2015-08-18',1,36),('2015-09-10',1,37),('2015-09-11',1,38),('2015-09-12',1,39),('2015-09-13',1,40),('2015-09-14',1,41),('2015-09-15',1,42),('2015-09-16',1,43),('2015-09-17',1,44),('2015-09-18',1,45),('2015-09-19',1,46),('2015-09-20',1,47),('2015-09-21',1,48),('2015-10-10',1,49),('2015-10-11',1,50),('2015-10-12',1,51),('2015-10-13',1,52),('2015-10-14',1,53),('2015-10-15',1,54);
/*!40000 ALTER TABLE `progressao_especialidade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `progressao_insignia`
--

DROP TABLE IF EXISTS `progressao_insignia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `progressao_insignia` (
  `data` date NOT NULL,
  `id_jovem` bigint NOT NULL,
  `id_requisito_insignia` bigint NOT NULL,
  PRIMARY KEY (`id_jovem`,`id_requisito_insignia`),
  KEY `FKmkws4xojo910kdkbxal3kknx0` (`id_requisito_insignia`),
  CONSTRAINT `FKg84q7xxdkh5bm8xb9kny648cb` FOREIGN KEY (`id_jovem`) REFERENCES `jovem` (`id_jovem`),
  CONSTRAINT `FKmkws4xojo910kdkbxal3kknx0` FOREIGN KEY (`id_requisito_insignia`) REFERENCES `requisito_insignia` (`id_requisito_insignia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `progressao_insignia`
--

LOCK TABLES `progressao_insignia` WRITE;
/*!40000 ALTER TABLE `progressao_insignia` DISABLE KEYS */;
INSERT INTO `progressao_insignia` VALUES ('2015-07-05',1,1),('2015-07-06',1,2),('2015-07-07',1,3),('2015-07-08',1,4),('2015-07-09',1,5),('2015-07-10',1,6),('2015-07-11',1,7);
/*!40000 ALTER TABLE `progressao_insignia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requisito_distintivo`
--

DROP TABLE IF EXISTS `requisito_distintivo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `requisito_distintivo` (
  `id_distintivo` bigint NOT NULL,
  `id_requisito_distintivo` bigint NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) NOT NULL,
  PRIMARY KEY (`id_requisito_distintivo`),
  KEY `FKo1o7etc1lmbkjgyfic4os6co8` (`id_distintivo`),
  CONSTRAINT `FKo1o7etc1lmbkjgyfic4os6co8` FOREIGN KEY (`id_distintivo`) REFERENCES `distintivo` (`id_distintivo`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requisito_distintivo`
--

LOCK TABLES `requisito_distintivo` WRITE;
/*!40000 ALTER TABLE `requisito_distintivo` DISABLE KEYS */;
INSERT INTO `requisito_distintivo` VALUES (1,1,'Completar o Caminho do Integrar'),(2,2,'Para conquistar o distintivo de Lobo Saltador, você precisa fazer pelo menos a metade das atividades propostas no seu guia/aplicativo.'),(3,3,'Para conquistar o distintivo de Lobo Rastreador, você precisa fazer as atividades que restam, e assim cumprir 100% das atividades.'),(4,4,'Para conquistar o distintivo de Lobo Caçador, você deve realizar a metade das atividades deste bloco.'),(5,5,'Estrela ALFA: Você deve cumprir o restante das atividades deste bloco'),(5,6,'Estrela BETA: Participar de três acampamentos ou acantonamentos com a sua Alcateia;'),(5,7,'Estrela DELTA: Conquistar 5 especialidades de 3 áreas do conhecimento diferentes'),(5,8,'Estrela GAMA: Conquistar uma das sete Insígnias de Interesse Especial do Ramo Lobinho'),(5,9,'Estrela EPSILON: Ser recomendado pelos Velhos Lobos e pela Roca de Conselho por ser um Lobinho dedicado, frequente às atividades da Alcateia e cumpridor da Lei e Promessa do Lobinho.');
/*!40000 ALTER TABLE `requisito_distintivo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requisito_especialidade`
--

DROP TABLE IF EXISTS `requisito_especialidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `requisito_especialidade` (
  `id_especialidade` bigint NOT NULL,
  `id_requisito_especialidade` bigint NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) NOT NULL,
  PRIMARY KEY (`id_requisito_especialidade`),
  KEY `FKrhh5ukpknmwep2apxvves0tgs` (`id_especialidade`),
  CONSTRAINT `FKrhh5ukpknmwep2apxvves0tgs` FOREIGN KEY (`id_especialidade`) REFERENCES `especialidade` (`id_especialidade`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requisito_especialidade`
--

LOCK TABLES `requisito_especialidade` WRITE;
/*!40000 ALTER TABLE `requisito_especialidade` DISABLE KEYS */;
INSERT INTO `requisito_especialidade` VALUES (1,1,'Entender o que é encriptação e decriptação e realizar uma apresentação sobre o assunto.'),(1,2,'Saber o que é criptografia e explicar o seu significado e sua utilidade.'),(1,3,'Conhecer e apresentar a história de Alan Turing e sua importância na história da criptografia.'),(1,4,'Conhecer e explicar o que foi a Cifra de César e qual a importância dela na história da criptografia.'),(1,5,'Conhecer a diferença entre Cifras e Códigos.'),(1,6,'Conhecer e explicar a importância da frequência das letras em uma mensagem criptografada e qual sua vantagem para conseguir descriptografá-la.'),(1,7,'Conhecer 3 tipos de cifras ou códigos incluindo a função totiente de Euler, quando foram criadas e para que são usadas.'),(1,8,'Criar e apresentar sua própria cifra e código explicando-a.'),(1,9,'Realizar 1 (um) texto com algum tipo de cifra e código falando sobre o escotismo com no mínimo quinze palavras.'),(1,10,'Conhecer e explicar o sigilo perfeito exemplificando-o.'),(1,11,'Conhecer e explicar o que é a configuração da chave e o que é o espaço da chave e o que é criptografia de chave pública.'),(1,12,'Explique a importância da criptografia no armazenamento de dados e informações para a segurança pessoal.'),(2,13,'Relatar como surgiu a comédia e quais os seus principais gêneros.'),(2,14,'Contar pelo menos 5 (cinco) piadas a sua escolha sendo 3 (três) delas específicas da sua região, podendo as piadas estarem em 1 (um) mesmo roteiro (stand-up) ou não.'),(2,15,'Contar detalhes sobre seu filme, show ou livro de comédia predileto, relatando suas partes prediletas e como estão estruturadas as piadas.'),(2,16,'Contar qual a situação mais engraçada que você vivenciou, dramatizando de uma forma bem engraçada.'),(2,17,'Escrever 1 (um) esquete curta de comédia com sua matilha ou matilha/patrulha, e apresentar num fogo de conselho ou flor vermelha.'),(2,18,'Explicar como se estrutura uma piada, usando para isto 1 (um) roteiro/piada escrito por você ou apresentar (e executar) como funciona 1 (um) jogo de improviso na comédia.'),(2,19,'Criar uma paródia engraçada de uma música famosa e apresentar sozinho ou com sua matilha/patrulha ou matilha num fogo de conselho ou flor vermelha.'),(2,20,'Criar e contar uma piada relacionada ao escotismo.'),(2,21,'Fazer 1 (um) esquete engraçada sobre a história de Baden-Powell e do escotismo.'),(2,22,'Assistir a uma peça teatral de comédia e depois relatar a experiência.'),(2,23,'Produzir 1 (um) vídeo de comédia sozinho ou com os membros da sua matilha/patrulha, apresentando-o na internet.'),(2,24,'Escrever e apresentar 1 (um) show de comédia de no mínimo 5 (cinco) minutos.'),(3,25,'Apresentar a história do basquetebol brasileiro, citando seus principais títulos.'),(3,26,'Escrever uma breve biografia sobre 1 (um) jogador de basquetebol, que você considere relevante.'),(3,27,'Demonstrar as regras básicas do basquetebol, encenando, quando aplicável.'),(3,28,'Apresentar os principais esquemas táticos e a sua necessidade no desenvolvimento do jogo.'),(3,29,'Assistir uma partida de basquetebol, com o examinador, e explicar durante o jogo os nomes e funções das posições dos jogadores em quadra.'),(3,30,'Apontar os principais fundamentos técnicos usados, durante 1 (um) jogo.'),(3,31,'Assistir a 1 (um) jogo de basquetebol televisionado, fazendo anotações, e nos intervalos fazer 1 (um) retrospecto dos melhores lances e assistir a 1 (um) jogo em 1 (um) ginásio, apresentando 1 (um) relatório no término.'),(3,32,'Fazer uma visita a 1 (um) ginásio com quadra de basquetebol em 1 (um) dia que não haja jogo, e conhecer suas dependências.'),(3,33,'Explicar as regras de segurança ao assistir a uma partida de basquetebol em 1 (um) ginásio, o que deve ser feito para evitar confusões e tumultos, dando sua opinião sobre o que os torcedores devem fazer para promover a paz nos ginásios.'),(3,34,'Apresentar o sistema de pontuação de campeonatos regionais e nacionais regulamentados pela FIBA.'),(3,35,'Participar de uma competição de basquetebol, sendo capaz de reconhecer os principais gestos efetuados por 1 (um) árbitro.'),(3,36,'Organizar 1 (um) torneio de basquetebol, na modalidade de sua preferência, na sua seção ou com outros grupos escoteiros e convidados, com no mínimo 4 (quatro) times, utilizando 1 (um) dos sistemas de pontuação apresentados no item 11'),(4,37,'Abrir latas de conserva, cortar legumes e preparar uma bebida.'),(4,38,'Identificar os utensílios necessários para a preparação de uma refeição definida pelo examinador.'),(4,39,'Fritar ovos e preparar saladas, decorando os pratos, e preparar uma bebida quente.'),(4,40,'Fazer uma lista dos mantimentos com quantidades necessárias para uma refeição festiva para a seção.'),(4,41,'Explicar como conservar os alimentos conforme a temperatura ambiente.'),(4,42,'Preparar 1 (um) cardápio equilibrado para 1 (um) acampamento de final de semana, calculando as quantidades dos gêneros para a matilha/patrulha.'),(4,43,'Cozinhar para a matilha/patrulha durante 1 (um) acampamento de final de semana, a lenha e a gás, demonstrando cuidados com a segurança e a higiene.'),(4,44,'Preparar alguma iguaria da cozinha mateira, como pão de caçador, ovo na laranja, ovo no espeto, carne moída no espeto, etc.'),(4,45,'Projetar e participar da montagem da cozinha do canto da matilha/patrulha em 1 (um) acampamento, justificando os cuidados adotados para reduzir os riscos de incêndio.'),(4,46,'Preparar, em 1 (um) acampamento, 3 (três) tipos de sobremesa.'),(4,47,'Limpar e preparar uma peça de carne e 1 (um) peixe.'),(4,48,'Construir uma intendência no canto de matilha/patrulha, durante 1 (um) acampamento.'),(5,49,'Apresentar à sua seção 1 (um) programa de desenho digital a sua escolha, demonstrando o uso de diversas ferramentas disponíveis, como texturas e filtros de cor.'),(5,50,'Explicar a importância do trabalho com layers, demonstrando a formatação de uma imagem utilizando esta ferramenta.'),(5,51,'Organizar uma exposição em sua seção, contendo pelo menos 5 (cinco) de seus trabalhos.'),(5,52,'Explicar ou à seção a importância dos efeitos de luz e sombra e quais as melhores técnicas para se conseguir os resultados desejados.'),(5,53,'Explicar o que é e como funciona uma mesa digitalizadora, demonstrando seu uso à seção.'),(5,54,'Fazer uma apresentação à matilha ou matilha/patrulha sobre a importância da paleta de cores selecionada para 1 (um) trabalho, utilizando recursos midiáticos de escolha livre (vídeos, apresentações de slides, cartazes.)');
/*!40000 ALTER TABLE `requisito_especialidade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requisito_insignia`
--

DROP TABLE IF EXISTS `requisito_insignia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `requisito_insignia` (
  `id_insignia` bigint NOT NULL,
  `id_requisito_insignia` bigint NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) NOT NULL,
  PRIMARY KEY (`id_requisito_insignia`),
  KEY `FKr0aasmv3ldohheq85jpfs1u96` (`id_insignia`),
  CONSTRAINT `FKr0aasmv3ldohheq85jpfs1u96` FOREIGN KEY (`id_insignia`) REFERENCES `insignia` (`id_insignia`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requisito_insignia`
--

LOCK TABLES `requisito_insignia` WRITE;
/*!40000 ALTER TABLE `requisito_insignia` DISABLE KEYS */;
INSERT INTO `requisito_insignia` VALUES (1,1,'Organizar o espaço de estudo adequadamente, observando a sua iluminação, local para acondicionamento dos materiais e ambiente.'),(1,2,'Ter o seu material escolar devidamente organizado, demonstrado cuidados com os livros, cadernos e demais materiais.'),(1,3,'Destinar o tempo adequado para seu estudo e tarefas de casa, relatando aos pais, a Akela ou outro Velho Lobo quanto tempo utiliza para essas atividades.'),(1,4,'Participar, como Lobinho, de pelo menos uma edição do Projeto Educação Escoteira com sua Alcateia, ou de outra atividade em conjunto com escolas realizada pela sua Alcateia ou pelo seu Grupo Escoteiro/Seção Autônoma.'),(1,5,'Participar ativamente de pelo menos duas atividades especiais em sua escola (Ex.: Festa Junina, Feira de Ciências, Excursão, etc.) e mostrar fotos ou relatório para a Alcateia.'),(1,6,'Apoiar um colega de classe em alguma tarefa ou ajudá-lo a aprender algum conteúdo que tenha dificuldade.'),(1,7,'Conversar com seus pais , Akela ou outro Velho Lobo sobre sua participação na escola, seu interesse pelos estudos e sobre os pontos que podem ser melhorados para ser um melhor aluno.'),(2,8,'Indicar, no mapa mundi, onde estão localizados os demais países do Cone Sul, sabendo reconhecer suas bandeiras e explicar o significado das cores de cada uma delas.'),(2,9,'Pesquisar a história de algo importante por sua utilidade que tenha sido inventado em um dos países do Cone Sul.'),(2,10,'Degustar pelo menos um prato típico de outro país do Cone Sul, conhecendo sua história e origem.'),(2,11,'Visitar exposições ou feiras culturais referentes a outros países do Cone Sul.'),(2,12,'Conhecer uma lenda ou conto de outro país do Cone Sul e contá-la para Alcateia.'),(2,13,'Conhecer a principal dança típica de pelo menos dois países do Cone Sul.'),(2,14,'Ir a uma peça de teatro cujo roteiro seja de outro país do Cone Sul e não esteja adaptado.'),(2,15,'Assistir uma animação ou filme nacional de outro país do Cone Sul.'),(2,16,'Enviar e receber uma correspondência, ou e-mail, contendo uma foto de sua Alcateia, para um lobinho de outro país do Cone Sul.'),(2,17,'Entrevistar alguém que esteja morando, ou tenha morado em algum país do Cone Sul.'),(2,18,'Descobrir quais distintivos poderia conquistar se fosse de outro país do Cone Sul.'),(2,19,'Ensinar a Alcateia a cantar uma canção escoteira de outro país do Cone Sul.'),(2,20,'Conhecer as principais terminologias do Ramo Lobinho (Alcateia, Matilha, acampamento, etc) em castelhano ou em outro idioma falado em países do Cone Sul, como o guarani.'),(2,21,'Conhecer os nomes e os símbolos das Associações Escoteiras dos países que integram o Cone Sul.'),(3,22,'Conhecer os principais problemas sociais de sua rua ou bairro e conversar com seus pais ou velhos lobos sobre como você poderia contribuir para resolvê-los.'),(3,23,'Conhecer instituições de sua comunidade que realizam ações assistenciais a pessoas necessitadas ou orientação para a melhoria da vida das pessoas, procurando saber de que forma sua Alcateia poderia ajudá-las.'),(3,24,'Participar de pelo menos uma edição do Mutirão Nacional Escoteiro de Ação Comunitária com sua Alcateia ou de outra atividade de ação comunitária realizada pela sua Alcateia ou por seu Grupo Escoteiro.'),(3,25,'Perceber os eventuais perigos a que estão expostos os lobinhos em uma excursão ou acampamento/acantonamento e ajudar a aplicar as regras de segurança para evitá-los.'),(3,26,'Participar de pelo menos três boas ações coletivas com sua Alcateia, contribuindo com ideias e ações para o planejamento e execução das atividades.'),(3,27,'Participar de uma ação comunitária promovida por alguma instituição de sua comunidade: igreja, clube, escola, posto de saúde, polícia, bombeiros, casa comercial, etc. e fazer um relatório sobre essa participação.'),(3,28,'Planejar e executar uma boa ação, diferente das realizadas anteriormente, que seja útil em sua Alcateia, casa, escola ou comunidade, com duração mínima de um mês, apresentando posteriormente os resultados para sua Alcateia.'),(4,29,'Pesquisar os temperos e especiarias típicos dos países lusófonos, também presentes no Brasil.'),(4,30,'Pesquisar a fauna e flora típicos dos países lusófonos, também presentes no Brasil.'),(4,31,'Pesquisar utensílios e invenções utilizadas no Brasil, criados em algum país lusófonos.'),(4,32,'Indicar, no mapa mundi, onde estão localizados os países lusófonos e reconhecer suas respectivas bandeiras.'),(4,33,'Visitar exposições ou feiras culturais referentes a outros países lusófonos.'),(4,34,'Degustar pelo menos uma refeição típica de outro país lusófono, conhecendo sua história e origem.'),(4,35,'Ir a uma peça de teatro cujo roteiro seja de outro país lusófono e não esteja adaptado.'),(4,36,'Assistir um espetáculo (circo, show musical etc) que seja originário de outro país lusófono.'),(4,37,'Conhecer uma lenda ou conto de um outro país lusófono, e contá-la para sua Alcateia.'),(4,38,'Entrevistar alguém que tenha morado, ou esteja morando, em um país lusófono;'),(4,39,'Ver um filme nacional ou animação de outro país Lusófono;'),(4,40,'Enviar e receber uma correspondência, ou e-mail, contendo uma foto de sua Alcateia, para um lobinho de outro país Lusófono'),(4,41,'Descobrir quais distintivos o Lobinho poderia conquistar se fosse de outro país lusófono.'),(4,42,'Fazer uma lista de termos escoteiros utilizados em outro país lusófono.'),(4,43,'Conhecer o símbolo das Associações Escoteiras dos países lusófonos.');
/*!40000 ALTER TABLE `requisito_insignia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `responsavel`
--

DROP TABLE IF EXISTS `responsavel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `responsavel` (
  `id_responsavel` bigint NOT NULL AUTO_INCREMENT,
  `cpf` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `telefone` varchar(255) NOT NULL,
  PRIMARY KEY (`id_responsavel`),
  UNIQUE KEY `UK_19crnd5p78y9x4iifm56shoah` (`cpf`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `responsavel`
--

LOCK TABLES `responsavel` WRITE;
/*!40000 ALTER TABLE `responsavel` DISABLE KEYS */;
INSERT INTO `responsavel` VALUES (1,'491.979.710-90','nicolas.dacruz@example.org','Nicolas Severino da Cruz','(77) 2912-9691'),(2,'016.005.900-39','raul.alves@example.org','Raul Julio Bruno Alves','(68) 99255-8601'),(3,'213.118.798-03','osvaldo.rezende@example.org','Osvaldo Kaique Hugo Rezende','(86) 99910-8836'),(4,'828.107.861-86','beatriz.silveira@example.org','Beatriz Hadassa Manuela Silveira','(82) 99576-6751'),(5,'864.292.258-36','luzia.novaes@example.org','Luzia Alessandra Novaes','(84) 98490-4275'),(6,'150.579.862-01','caroline.farias@example.org','Caroline Eduarda Benedita Farias','(42) 99309-1098');
/*!40000 ALTER TABLE `responsavel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_sanguineo`
--

DROP TABLE IF EXISTS `tipo_sanguineo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_sanguineo` (
  `id_tipo_sanguineo` bigint NOT NULL AUTO_INCREMENT,
  `tipo` varchar(255) NOT NULL,
  PRIMARY KEY (`id_tipo_sanguineo`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_sanguineo`
--

LOCK TABLES `tipo_sanguineo` WRITE;
/*!40000 ALTER TABLE `tipo_sanguineo` DISABLE KEYS */;
INSERT INTO `tipo_sanguineo` VALUES (1,'A+'),(2,'A-'),(3,'B+'),(4,'B-'),(5,'AB+'),(6,'AB-'),(7,'O+'),(8,'O-');
/*!40000 ALTER TABLE `tipo_sanguineo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-16 19:11:28
